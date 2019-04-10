package ec.com.jmgorduez.Bowling.domain;

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
import static ec.com.jmgorduez.Bowling.utils.Constants.*;
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
            List<IFrame> frameList = generateFramesList12Strikes();
            BowlingLineScore bowlingLineScoreExpected = new BowlingLineScore();
            frameList.stream().forEach(frame -> bowlingLineScoreExpected.addFrame(frame));
            BowlingLineScore bowlingLineScoreCurrent
                    = (BowlingLineScore) bowlingLineScoreReaderUnderTest.readBowlingLineScore(bufferedReaderMock);
            assertThat(bowlingLineScoreCurrent)
                    .isEqualTo(bowlingLineScoreExpected);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void stringToFramesList() {
        assertThat(bowlingLineScoreReaderUnderTest
                .stringToFramesList(STRING_LINE_12_STRIKES))
                .isEqualTo(generateFramesList12Strikes());
    }

    @Test
    void takeFinalFrameSection() {
        assertThat(bowlingLineScoreReaderUnderTest
                .takeFinalFrameSection(STRING_ARRAY_12_STRIKES))
                .isEqualTo(STRIKE_FINAL_FRAME_STRING);

        assertThat(bowlingLineScoreReaderUnderTest
                .takeFinalFrameSection(STRING_ARRAY_10_PAIRS_OF_9_AND_MISS))
                .isEqualTo(FINAL_FRAME_10_PAIRS_OF_9_AND_MISS_STRING_FILL);

        assertThat(bowlingLineScoreReaderUnderTest
                .takeFinalFrameSection(STRING_ARRAY_10_PAIRS_OF_5_AND_SPARE_WITH_A_FINAL_5))
                .isEqualTo(FINAL_FRAME_5_AND_SPARE_WITH_A_FINAL_5_STRING);
    }

    @Test
    void takeFinalFrame(){
        assertThat(bowlingLineScoreReaderUnderTest
                .takeFinalFrame(STRING_ARRAY_12_STRIKES))
                .isEqualTo(STRIKE_FINAL_FRAME);

        assertThat(bowlingLineScoreReaderUnderTest
                .takeFinalFrame(STRING_ARRAY_10_PAIRS_OF_9_AND_MISS))
                .isEqualTo(FINAL_NORMAL_FRAME_9_);

        assertThat(bowlingLineScoreReaderUnderTest
                .takeFinalFrame(STRING_ARRAY_10_PAIRS_OF_5_AND_SPARE_WITH_A_FINAL_5))
                .isEqualTo(FINAL_NORMAL_FRAME_5_SPARE_5);
    }
}