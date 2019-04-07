package ec.com.jmgorduez.Bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NormalFrameTest {
    private NormalFrame normalFrameUnderTest;

    @BeforeEach
    void setUp() {
        this.normalFrameUnderTest = new NormalFrame(THREE, FIVE, NORMAL_FRAME_4_5);
    }

    @Test
    void getPointsFirstBall() {
        assertThat(normalFrameUnderTest.getPointsFirstBall())
                .isEqualTo(THREE);
    }

    @Test
    void getPointsSecondBall() {
        assertThat(normalFrameUnderTest.getPointsSecondBall())
                .isEqualTo(FIVE);
    }

    @Test
    void getBonusForStrike() {
        assertThat(normalFrameUnderTest.getBonusForStrike())
                .isEqualTo(THREE + FIVE);
    }

    @Test
    void getBonusForSpare() {
        assertThat(normalFrameUnderTest.getBonusForSpare())
                .isEqualTo(THREE);
    }

    @Test
    void getNextFrame() {
        assertThat(normalFrameUnderTest.nextFrame())
                .isEqualTo(NORMAL_FRAME_4_5);
    }
}