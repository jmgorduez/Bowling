package ec.com.jmgorduez.Bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.Bowling.utils.Constants.TEN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FinalSpareFrameTest {
    private FinalSpareFrame finalSpareFrameUnderTest;

    @BeforeEach
    void setUp() {
        finalSpareFrameUnderTest = new FinalSpareFrame(TEN, TEN);
    }

    @Test
    void bonusForStrike() {
        assertThat(finalSpareFrameUnderTest.bonusForStrike())
                .isEqualTo(TEN + TEN);
    }

    @Test
    void bonusForSpare() {
    }

    @Test
    void totalPoints() {
    }
}