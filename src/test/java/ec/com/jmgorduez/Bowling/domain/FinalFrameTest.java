package ec.com.jmgorduez.Bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.Bowling.utils.Constants.TEN;
import static org.assertj.core.api.Assertions.assertThat;

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
}