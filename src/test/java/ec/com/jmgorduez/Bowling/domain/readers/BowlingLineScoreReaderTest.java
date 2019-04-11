package ec.com.jmgorduez.Bowling.domain.readers;

import ec.com.jmgorduez.Bowling.domain.BowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrameReader;
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
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class BowlingLineScoreReaderTest {

    private BowlingLineScoreReader bowlingLineScoreReaderUnderTest;
    @Mock
    private BufferedReader bufferedReaderMock;
    @Mock
    private BufferedReader bufferedReaderEmptyLineMock;
    private IFrameReader frameReader;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.bowlingLineScoreReaderUnderTest = new BowlingLineScoreReader();
        frameReader = new FrameReader();
        try {
            when(bufferedReaderMock.readLine())
                    .thenReturn(STRING_LINE_12_STRIKES);
            when(bufferedReaderEmptyLineMock.readLine())
                    .thenReturn(NULL_STRING_LINE);
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
                    = (BowlingLineScore) bowlingLineScoreReaderUnderTest.readBowlingLineScore(bufferedReaderMock, frameReader);
            assertThat(bowlingLineScoreCurrent)
                    .isEqualTo(bowlingLineScoreExpected);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void readEmptyBowlingLineScore() {
        assertThatThrownBy(() -> bowlingLineScoreReaderUnderTest
                .readBowlingLineScore(bufferedReaderEmptyLineMock, frameReader))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void stringToFramesList() {
        assertThat(bowlingLineScoreReaderUnderTest
                .stringToFramesList(STRING_LINE_12_STRIKES, frameReader))
                .isEqualTo(generateFramesList12Strikes());
        assertThat(bowlingLineScoreReaderUnderTest
                .stringToFramesList(STRING_LINE_10_PAIRS_OF_5_AND_SPARE_WITH_A_FINAL_5, frameReader))
                .isEqualTo(generateFramesList10PairsOf5AndSpareWithAFinal5());
        assertThat(bowlingLineScoreReaderUnderTest
                .stringToFramesList(STRING_LINE_10_PAIRS_OF_9_AND_MISS, frameReader))
                .isEqualTo(generateFramesList10PairsOf9AndMiss());
    }

    @Test
    void takeFinalFrameString() {
        assertThat(bowlingLineScoreReaderUnderTest
                .takeFinalFrameString(STRING_ARRAY_12_STRIKES))
                .isEqualTo(STRIKE_FINAL_FRAME_STRING);

        assertThat(bowlingLineScoreReaderUnderTest
                .takeFinalFrameString(STRING_ARRAY_10_PAIRS_OF_9_AND_MISS))
                .isEqualTo(FINAL_FRAME_10_PAIRS_OF_9_AND_MISS_STRING_FILL);

        assertThat(bowlingLineScoreReaderUnderTest
                .takeFinalFrameString(STRING_ARRAY_10_PAIRS_OF_5_AND_SPARE_WITH_A_FINAL_5))
                .isEqualTo(FINAL_FRAME_5_AND_SPARE_WITH_A_FINAL_5_STRING);
    }

    @Test
    void takeInitFrames12Strike() {
        List<IFrame> frameList = generateFramesList12Strikes();
        List<IFrame> initFramesListExpected = frameList.subList(ZERO, NINE);
        IFrame lastFrame = frameList.get(NINE);
        assertThat(bowlingLineScoreReaderUnderTest
                .takeInitFrames(STRING_ARRAY_12_STRIKES, lastFrame, new FrameReader()))
                .isEqualTo(initFramesListExpected);
    }

    @Test
    void takeinitframes10PairsOf9AndMiss() {
        List<IFrame> frameList = generateFramesList10PairsOf9AndMiss();
        List<IFrame> initFramesListExpected = frameList.subList(ZERO, NINE);
        IFrame lastFrame = frameList.get(NINE);
        assertThat(bowlingLineScoreReaderUnderTest
                .takeInitFrames(STRING_ARRAY_10_PAIRS_OF_9_AND_MISS, lastFrame, new FrameReader()))
                .isEqualTo(initFramesListExpected);
    }

    @Test
    void takeFinalFrame() {
        assertThat(bowlingLineScoreReaderUnderTest
                .takeFinalFrame(STRING_ARRAY_12_STRIKES, frameReader))
                .isEqualTo(STRIKE_FINAL_FRAME);

        assertThat(bowlingLineScoreReaderUnderTest
                .takeFinalFrame(STRING_ARRAY_10_PAIRS_OF_9_AND_MISS, frameReader))
                .isEqualTo(FINAL_NORMAL_FRAME_9_);

        assertThat(bowlingLineScoreReaderUnderTest
                .takeFinalFrame(STRING_ARRAY_10_PAIRS_OF_5_AND_SPARE_WITH_A_FINAL_5, frameReader))
                .isEqualTo(FINAL_NORMAL_FRAME_5_SPARE_5);
    }
}