package ec.com.jmgorduez.Bowling.domain.readers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    void readFrame() {
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