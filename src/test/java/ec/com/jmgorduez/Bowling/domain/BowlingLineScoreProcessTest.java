package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreReader;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrameReader;
import ec.com.jmgorduez.Bowling.domain.abstractions.factories.IDependencesFactory;
import ec.com.jmgorduez.Bowling.domain.readers.BowlingLineScoreReader;
import ec.com.jmgorduez.Bowling.domain.readers.FrameReader;
import ec.com.jmgorduez.Bowling.utils.DependencesFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.Bowling.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class BowlingLineScoreProcessTest {

    private BowlingLineScoreProcess bowlingLineScoreProcessUnderTest;
    private IBowlingLineScoreReader bowlingLineScoreReader;
    private IFrameReader frameReader;
    private List<Integer> bowlingScoresExpexted;
    private IDependencesFactory factory;

    @BeforeEach
    void setUp() {
        factory = new DependencesFactory();
        bowlingLineScoreProcessUnderTest = (BowlingLineScoreProcess) factory.bowlingLineScoreProcess();
        bowlingLineScoreReader = new BowlingLineScoreReader();
        frameReader = new FrameReader();
        bowlingScoresExpexted = new ArrayList<>();
    }

    @Test
    void processBowlingLineScore() {
        try {
            bowlingLineScoreProcessUnderTest.processBowlingLineScore(
                    new BufferedReader(new FileReader(FILE_PATH_MAIN)),
                    factory::bowlingLineScoreReader,
                    factory::frameReader,
                    this::writeOutput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertThat(bowlingScoresExpexted.indexOf(THREE_HUNDRED))
                .isEqualTo(ZERO);
        assertThat(bowlingScoresExpexted.indexOf(NINETY))
                .isEqualTo(ONE);
        assertThat(bowlingScoresExpexted.indexOf(ONE_HUNDRED_FIFTY))
                .isEqualTo(TWO);
    }

    @Test
    void processEmptyBowlingLineScore() {
        try {
            bowlingLineScoreProcessUnderTest.processBowlingLineScore(
                    new BufferedReader(new FileReader(EMPTY_FILE_PATH)),
                    factory::bowlingLineScoreReader,
                    factory::frameReader,
                    this::writeOutput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertThat(bowlingScoresExpexted.isEmpty())
                .isTrue();
    }

    void writeOutput(Optional<IBowlingLineScore> bowlingLineScore) {
        bowlingLineScore.ifPresent(bowlingLineScore1 ->
                bowlingScoresExpexted.add(bowlingLineScore.get().getTotalScore()));
    }
}