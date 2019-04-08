package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;

class BowlingLineScoreTest {

    private BowlingLineScore bowlingLineScoreUnderTest;

    @BeforeEach
    void setUp() {
        bowlingLineScoreUnderTest
                = new BowlingLineScore();
    }

    @Test
    void getTotalScore() {
        assertThat(bowlingLineScoreUnderTest.getTotalScore())
                .isEqualTo(THREE_HUNDRED);
        bowlingLineScoreUnderTest
                = new BowlingLineScore();
        assertThat(bowlingLineScoreUnderTest.getTotalScore())
                .isEqualTo(NINETY);
        bowlingLineScoreUnderTest
                = new BowlingLineScore();
        assertThat(bowlingLineScoreUnderTest.getTotalScore())
                .isEqualTo(ONE_HUNDRED_FIFTY);
    }

    @Test
    void addFrame(){
        List<IFrame> frameListExpected = new ArrayList<>();
        frameListExpected.add(NORMAL_FRAME_4_5);
        bowlingLineScoreUnderTest.addFrame(NORMAL_FRAME_4_5);
        assertThat(bowlingLineScoreUnderTest.frameList)
                .isEqualTo(frameListExpected);
    }
}