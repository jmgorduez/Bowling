package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.NormalFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.THREE;
import static org.assertj.core.api.Assertions.assertThat;

class NormalFrameTest {
    private NormalFrame normalFrameUnderTest;

    @BeforeEach
    void setUp() {
        this.normalFrameUnderTest = new NormalFrame();
    }

    @Test
    void getPointsFirstBall() {
        assertThat(normalFrameUnderTest.getPointsFirstBall())
                .isEqualTo(THREE);
    }

    @Test
    void getPointsSecondBall() {
    }

    @Test
    void getBonusForStrike() {
    }

    @Test
    void getBonusForSpare() {
    }

    @Test
    void getNextFrame() {
    }
}