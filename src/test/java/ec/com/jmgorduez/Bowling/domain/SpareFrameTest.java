package ec.com.jmgorduez.Bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.Bowling.utils.Constants.FIVE;
import static org.assertj.core.api.Assertions.assertThat;

class SpareFrameTest {
    private SpareFrame spareFrameUnderTest;

    @BeforeEach
    void setUp() {
        this.spareFrameUnderTest = new SpareFrame(FIVE);
    }

    @Test
    void pointsFirstBall() {
        assertThat(spareFrameUnderTest.pointsFirstBall())
                .isEqualTo(FIVE);
    }

    @Test
    void pointsSecondBall() {
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