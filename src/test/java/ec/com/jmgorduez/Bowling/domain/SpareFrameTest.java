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
        this.spareFrameUnderTest = new SpareFrame(FIVE, THREE, NORMAL_FRAME_4_5);
    }

    @Test
    void pointsFirstBall() {
        assertThat(spareFrameUnderTest.pointsFirstBall())
                .isEqualTo(FIVE);
    }

    @Test
    void pointsSecondBall() {
        assertThat(spareFrameUnderTest.pointsSecondBall())
                .isEqualTo(THREE);
    }

    @Test
    void bonusForStrike() {
        assertThat(spareFrameUnderTest.bonusForStrike())
                .isEqualTo(FIVE + THREE);
    }

    @Test
    void bonusForSpare() {
        assertThat(spareFrameUnderTest.bonusForSpare())
                .isEqualTo(FIVE);
    }

    @Test
    void nextFrame() {
        assertThat(spareFrameUnderTest.nextFrame())
                .isEqualTo(NORMAL_FRAME_4_5);
    }

    @Test
    void totalPoints() {
        assertThat(spareFrameUnderTest.totalPoints())
                .isEqualTo(TEN + FOUR);
    }
}