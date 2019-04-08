package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.NORMAL_FRAME_4_5;
import static ec.com.jmgorduez.Bowling.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class SpareFrameTest {
    private SpareFrame spareFrameUnderTest;

    @BeforeEach
    void setUp() {
        this.spareFrameUnderTest = new SpareFrame(SEVEN, THREE, () -> NORMAL_FRAME_4_5);
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
    void bonusForStrike() {
        assertThat(spareFrameUnderTest.bonusForStrike())
                .isEqualTo(SEVEN + THREE);
    }

    @Test
    void bonusForSpare() {
        assertThat(spareFrameUnderTest.bonusForSpare())
                .isEqualTo(SEVEN);
    }

    @Test
    void nextFrame() {
        assertThat(spareFrameUnderTest.nextFrame().get())
                .isEqualTo(NORMAL_FRAME_4_5);
    }

    @Test
    void totalPoints() {
        assertThat(spareFrameUnderTest.totalPoints())
                .isEqualTo(TEN + FOUR);
    }
}