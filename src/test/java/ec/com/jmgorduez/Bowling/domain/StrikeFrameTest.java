package ec.com.jmgorduez.Bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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
        assertThat(strikeFrameUnderTest.pointsFirstBall())
                .isEqualTo(TEN);
    }

    @Test
    void getPointsSecondBall() {
        assertThat(strikeFrameUnderTest.pointsSecondBall())
                .isNotEqualTo(TEN);
        assertThat(strikeFrameUnderTest.pointsSecondBall())
                .isEqualTo(ZERO);
    }

    @Test
    void getBonusForStrike() {
        assertThat(strikeFrameUnderTest.bonusForStrike())
                .isEqualTo(TEN + FOUR);
    }

    @Test
    void getBonusForSpare() {
        assertThat(strikeFrameUnderTest.bonusForSpare())
                .isEqualTo(TEN);
    }

    @Test
    void getPoints() {
        assertThat(strikeFrameUnderTest.totalPoints())
                .isEqualTo(TEN + FOUR + FIVE);
    }

    @Test
    void equals() {
        assertThat(strikeFrameUnderTest.equals(strikeFrameUnderTest))
                .isTrue();
        assertThat(strikeFrameUnderTest.equals(this))
                .isFalse();
        assertThat(strikeFrameUnderTest.equals(new StrikeFrame(EMPTY_FRAME)))
                .isFalse();
        assertThat(strikeFrameUnderTest.equals(new StrikeFrame(NORMAL_FRAME_4_5)))
                .isTrue();
    }
}