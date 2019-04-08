package ec.com.jmgorduez.Bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.Bowling.utils.Constants.FIVE;
import static ec.com.jmgorduez.Bowling.utils.Constants.THREE;
import static org.assertj.core.api.Assertions.assertThat;

class SpareFrameTest {
    private SpareFrame spareFrameUnderTest;

    @BeforeEach
    void setUp() {
        this.spareFrameUnderTest = new SpareFrame(FIVE, THREE);
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
    }

    @Test
    void bonusForSpare() {
    }

    @Test
    void nextFrame() {
    }

    @Test
    void totalPoints() {
    }
}