package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class BowlingLineScoreReaderTest {

    private BowlingLineScoreReader bowlingLineScoreReaderUnderTest;
    @Mock
    private BufferedReader bufferedReaderMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.bowlingLineScoreReaderUnderTest = new BowlingLineScoreReader();
        try {
            when(bufferedReaderMock.readLine())
                    .thenReturn(STRING_LINE_12_STRIKES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void readBowlingLineScore() {
        try {
            List<IFrame> frameList =generateFramesList12Strikes();
            BowlingLineScore bowlingLineScoreExpected = new BowlingLineScore();
            frameList.stream().forEach(frame -> bowlingLineScoreExpected.addFrame(frame));
            BowlingLineScore bowlingLineScoreCurrent = (BowlingLineScore) bowlingLineScoreReaderUnderTest.readBowlingLineScore(bufferedReaderMock);
            assertThat(bowlingLineScoreCurrent)
                    .isEqualTo(bowlingLineScoreExpected);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}