package ec.com.jmgorduez.Bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.NORMAL_FRAME_4_5;
import static ec.com.jmgorduez.Bowling.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

class FinalFrameTest {
    private FinalFrame finalSpareFrameUnderTest;

    @BeforeEach
    void setUp() {
        finalSpareFrameUnderTest = new FinalFrame(TEN, TEN, TEN);
    }

    @Test
    void totalPoints() {
        assertThat(finalSpareFrameUnderTest.totalPoints())
                .isEqualTo(TEN + TEN + TEN);
    }

    @Test
    void equals(){
        assertThat(finalSpareFrameUnderTest.equals(finalSpareFrameUnderTest))
                .isTrue();
        assertThat(finalSpareFrameUnderTest.equals(this))
                .isFalse();
        assertThat(finalSpareFrameUnderTest.equals(new FinalFrame(TEN, TEN, FIVE)))
                .isFalse();
        assertThat(finalSpareFrameUnderTest.equals(new FinalFrame(TEN, TEN, TEN)))
                .isTrue();
    }
}