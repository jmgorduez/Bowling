package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    void getTotalScore12Strikes() {
        addFrames(generateFramesList12Strikes());
        assertThat(bowlingLineScoreUnderTest.getTotalScore())
                .isEqualTo(THREE_HUNDRED);
    }

    @Test
    void getTotalScore10PairsOf9AndMiss() {
        addFrames(generateFramesList10PairsOf9AndMiss());
        assertThat(bowlingLineScoreUnderTest.getTotalScore())
                .isEqualTo(NINETY);
    }

    @Test
    void getTotalScore10PairsOf5AndSpareWithAFinal5() {
        addFrames(generateFramesList10PairsOf5AndSpareWithAFinal5());
        assertThat(bowlingLineScoreUnderTest.getTotalScore())
                .isEqualTo(ONE_HUNDRED_FIFTY);
    }

    private void addFrames(List<IFrame> frameList) {
        frameList.stream()
                .forEach(frame -> bowlingLineScoreUnderTest.addFrame(frame));
    }

    @Test
    void addFrame() {
        List<IFrame> frameListExpected = new ArrayList<>();
        frameListExpected.add(NORMAL_FRAME_4_5);
        bowlingLineScoreUnderTest.addFrame(NORMAL_FRAME_4_5);
        assertThat(bowlingLineScoreUnderTest.frameList)
                .isEqualTo(frameListExpected);
        frameListExpected.add(NORMAL_FRAME_4_4);
        bowlingLineScoreUnderTest.addFrame(NORMAL_FRAME_4_4);
        assertThat(bowlingLineScoreUnderTest.frameList)
                .isEqualTo(frameListExpected);
        frameListExpected.add(STRIKE_FRAME);
        bowlingLineScoreUnderTest.addFrame(STRIKE_FRAME);
        assertThat(bowlingLineScoreUnderTest.frameList)
                .isEqualTo(frameListExpected);
    }

    @Test
    void isNotEmptyFramesList() {
        assertThat(bowlingLineScoreUnderTest.isNotEmptyFramesList())
                .isFalse();
        bowlingLineScoreUnderTest.addFrame(STRIKE_FRAME);
        assertThat(bowlingLineScoreUnderTest.isNotEmptyFramesList())
                .isTrue();
    }

    @Test
    void equals() {
        assertThat(bowlingLineScoreUnderTest.equals(bowlingLineScoreUnderTest))
                .isTrue();
        assertThat(bowlingLineScoreUnderTest.equals(this))
                .isFalse();
        assertThat(bowlingLineScoreUnderTest.equals(new BowlingLineScore()))
                .isTrue();
        bowlingLineScoreUnderTest.addFrame(STRIKE_FRAME);
        assertThat(bowlingLineScoreUnderTest.equals(new BowlingLineScore()))
                .isFalse();
    }
}