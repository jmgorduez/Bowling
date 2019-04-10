package ec.com.jmgorduez.Bowling.domain.readers;

import ec.com.jmgorduez.Bowling.domain.FinalFrame;
import ec.com.jmgorduez.Bowling.domain.NormalFrame;
import ec.com.jmgorduez.Bowling.domain.SpareFrame;
import ec.com.jmgorduez.Bowling.domain.StrikeFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.Bowling.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class FrameReaderTest {

    private FrameReader frameReaderUnderTest;
    private List<Integer> valuesOfFrame;

    @BeforeEach
    void setUp() {
        frameReaderUnderTest = new FrameReader();
        valuesOfFrame = new ArrayList<>();
    }

    @Test
    void readStrikeFinalFrame() {
        valuesOfFrame.add(TEN);
        valuesOfFrame.add(TEN);
        valuesOfFrame.add(TEN);
        IFrame frame = frameReaderUnderTest.readFrame(valuesOfFrame, EMPTY_FRAME);
        assertThat(frame).isExactlyInstanceOf(FinalFrame.class);
        assertThat(frame).isEqualTo(STRIKE_FINAL_FRAME);
    }

    @Test
    void readStrikeFrame() {
        valuesOfFrame.add(TEN);
        IFrame frame = frameReaderUnderTest.readFrame(valuesOfFrame, NORMAL_FRAME_4_5);
        assertThat(frame).isExactlyInstanceOf(StrikeFrame.class);
        assertThat(frame).isEqualTo(STRIKE_FRAME);
    }

    @Test
    void readSpareFrame() {
        valuesOfFrame.add(NINE);
        valuesOfFrame.add(ONE);
        IFrame frame = frameReaderUnderTest.readFrame(valuesOfFrame, NORMAL_FRAME_4_5);
        assertThat(frame).isExactlyInstanceOf(SpareFrame.class);
        assertThat(frame).isEqualTo(SPARE_FRAME_9_1);
    }

    @Test
    void readNormalFrame() {
        valuesOfFrame.add(FOUR);
        valuesOfFrame.add(FIVE);
        IFrame frame = frameReaderUnderTest.readFrame(valuesOfFrame, NORMAL_FRAME_4_4);
        assertThat(frame).isExactlyInstanceOf(NormalFrame.class);
        assertThat(frame).isEqualTo(NORMAL_FRAME_4_5);
    }

    @Test
    void isAFinalFrame() {
        assertThat(frameReaderUnderTest.isAFinalFrame(valuesOfFrame))
                .isFalse();
        valuesOfFrame.add(ONE);
        assertThat(frameReaderUnderTest.isAFinalFrame(valuesOfFrame))
                .isFalse();
        valuesOfFrame.add(TWO);
        assertThat(frameReaderUnderTest.isAFinalFrame(valuesOfFrame))
                .isFalse();
        valuesOfFrame.add(THREE);
        assertThat(frameReaderUnderTest.isAFinalFrame(valuesOfFrame))
                .isTrue();
    }

    @Test
    void isASpareFrame() {
        assertThat(frameReaderUnderTest.isASpareFrame(valuesOfFrame))
                .isFalse();
        valuesOfFrame.add(ONE);
        assertThat(frameReaderUnderTest.isASpareFrame(valuesOfFrame))
                .isFalse();
        valuesOfFrame.add(NINE);
        assertThat(frameReaderUnderTest.isASpareFrame(valuesOfFrame))
                .isTrue();
    }

    @Test
    void isAStrikeFrame() {
        assertThat(frameReaderUnderTest.isAStrikeFrame(valuesOfFrame))
                .isFalse();
        valuesOfFrame.add(TEN);
        assertThat(frameReaderUnderTest.isAStrikeFrame(valuesOfFrame))
                .isTrue();
        valuesOfFrame.add(ONE);
        assertThat(frameReaderUnderTest.isAStrikeFrame(valuesOfFrame))
                .isFalse();
    }
}