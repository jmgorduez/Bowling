package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.Bowling.utils.Constants.*;
import static org.assertj.core.api.Assertions.*;

class NormalFrameTest {
    private NormalFrame normalFrameUnderTest;

    @BeforeEach
    void setUp() {
        this.normalFrameUnderTest = new NormalFrame( THREE, FIVE, NORMAL_FRAME_4_5);
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
        assertThat(normalFrameUnderTest.equals(new NormalFrame(THREE, FIVE, EMPTY_FRAME)))
                .isFalse();
        assertThat(normalFrameUnderTest.equals(new NormalFrame(THREE, FIVE, NORMAL_FRAME_4_5)))
                .isTrue();
    }
}