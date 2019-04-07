package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.NormalFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.FIVE;
import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.THREE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NormalFrameTest {
    private NormalFrame normalFrameUnderTest;

    @BeforeEach
    void setUp() {
        this.normalFrameUnderTest = new NormalFrame(THREE, FIVE);
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

    }

    @Test
    void getNextFrame() {
    }
}