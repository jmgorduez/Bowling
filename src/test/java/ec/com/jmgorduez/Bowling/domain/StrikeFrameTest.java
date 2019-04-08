package ec.com.jmgorduez.Bowling.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.Bowling.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class StrikeFrameTest {

    private StrikeFrame strikeFrameUnderTest;

    @BeforeEach
    void setUp() {
        this.strikeFrameUnderTest = new StrikeFrame();
    }

    @Test
    void getPointsFirstBall() {
        assertThat(strikeFrameUnderTest.getPointsFirstBall())
                .isEqualTo(TEN);
    }

    @Test
    void getPointsSecondBall() {
        assertThat(strikeFrameUnderTest.getPointsSecondBall())
                .isNotEqualTo(TEN);
        assertThat(strikeFrameUnderTest.getPointsSecondBall())
                .isEqualTo(ZERO);
    }

    @Test
    void getBonusForStrike() {
        assertThat(strikeFrameUnderTest.getBonusForStrike())
                .isEqualTo(TEN + ZERO);
    }

    @Test
    void getBonusForSpare() {
        assertThat(strikeFrameUnderTest.getBonusForSpare())
                .isEqualTo(NINE);
    }

    @Test
    void nextFrame() {
    }

    @Test
    void getPoints() {
    }
}