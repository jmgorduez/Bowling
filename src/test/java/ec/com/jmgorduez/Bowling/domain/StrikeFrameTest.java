package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.NORMAL_FRAME_4_5;
import static ec.com.jmgorduez.Bowling.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class StrikeFrameTest {

    private StrikeFrame strikeFrameUnderTest;

    @BeforeEach
    void setUp() {
        this.strikeFrameUnderTest = new StrikeFrame(NORMAL_FRAME_4_5);
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
                .isEqualTo(TEN + FOUR);
    }

    @Test
    void getBonusForSpare() {
        assertThat(strikeFrameUnderTest.getBonusForSpare())
                .isEqualTo(TEN);
    }

    @Test
    void nextFrame() {
        assertThat(strikeFrameUnderTest.nextFrame())
                .isEqualTo(NORMAL_FRAME_4_5);
    }

    @Test
    void getPoints() {
        assertThat(strikeFrameUnderTest.getPoints())
                .isEqualTo(TEN + FOUR + FIVE);
    }
}