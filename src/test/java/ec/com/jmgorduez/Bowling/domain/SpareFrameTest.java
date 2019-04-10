package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.EMPTY_FRAME;
import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.NORMAL_FRAME_4_5;
import static ec.com.jmgorduez.Bowling.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

class SpareFrameTest {
    private SpareFrame spareFrameUnderTest;

    @BeforeEach
    void setUp() {
        this.spareFrameUnderTest = new SpareFrame(SEVEN, THREE, NORMAL_FRAME_4_5);
    }

    @Test
    void pointsFirstBall() {
        assertThat(spareFrameUnderTest.pointsFirstBall())
                .isEqualTo(SEVEN);
    }

    @Test
    void pointsSecondBall() {
        assertThat(spareFrameUnderTest.pointsSecondBall())
                .isEqualTo(THREE);
    }

    @Test
    void totalPoints() {
        assertThat(spareFrameUnderTest.totalPoints())
                .isEqualTo(TEN + FOUR);
    }

    @Test
    void equals() {
        assertThat(spareFrameUnderTest.equals(spareFrameUnderTest))
                .isTrue();
        assertThat(spareFrameUnderTest.equals(this))
                .isFalse();
        assertThat(spareFrameUnderTest.equals(new SpareFrame(SEVEN, THREE, EMPTY_FRAME)))
                .isFalse();
        assertThat(spareFrameUnderTest.equals(new SpareFrame(SEVEN, THREE, NORMAL_FRAME_4_5)))
                .isTrue();
    }
}