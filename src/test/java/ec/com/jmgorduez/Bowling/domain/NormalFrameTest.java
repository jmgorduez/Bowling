package ec.com.jmgorduez.Bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.Bowling.utils.Constants.FIVE;
import static ec.com.jmgorduez.Bowling.utils.Constants.THREE;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class NormalFrameTest {
    private NormalFrame normalFrameUnderTest;

    @BeforeEach
    void setUp() {
        this.normalFrameUnderTest = new NormalFrame(THREE, FIVE, ()->NORMAL_FRAME_4_5);
    }

    @Test
    void getPointsFirstBall() {
        assertThat(normalFrameUnderTest.pointsFirstBall())
                .isEqualTo(THREE);
    }

    @Test
    void getPointsSecondBall() {
        assertThat(normalFrameUnderTest.pointsSecondBall())
                .isEqualTo(FIVE);
    }

    @Test
    void getBonusForStrike() {
        assertThat(normalFrameUnderTest.bonusForStrike())
                .isEqualTo(THREE + FIVE);
    }

    @Test
    void getBonusForSpare() {
        assertThat(normalFrameUnderTest.bonusForSpare())
                .isEqualTo(THREE);
    }

    @Test
    void getNextFrame() {
        assertThat(normalFrameUnderTest.nextFrame().get())
                .isEqualTo(NORMAL_FRAME_4_5);
    }

    @Test
    void getPoints(){
        assertThat(normalFrameUnderTest.totalPoints())
                .isEqualTo(THREE + FIVE);
    }

    @Test
    void equals(){
        assertThat(normalFrameUnderTest.equals(normalFrameUnderTest))
                .isTrue();
        assertThat(normalFrameUnderTest.equals(this))
                .isFalse();
        assertThat(normalFrameUnderTest.equals(new NormalFrame(THREE, FIVE, any())))
                .isFalse();
        assertThat(normalFrameUnderTest.equals(new NormalFrame(THREE, FIVE, ()->NORMAL_FRAME_4_5)))
                .isTrue();
    }
}