package ec.com.jmgorduez.Bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;

class BowlingLineScoreTest {

    private BowlingLineScore bowlingLineScoreUnderTest;

    @BeforeEach
    void setUp() {
        bowlingLineScoreUnderTest
                = new BowlingLineScore(generateFramesList12Strikes());
    }

    @Test
    void getTotalScore() {
        assertThat(bowlingLineScoreUnderTest.getTotalScore())
                .isEqualTo(THREE_HUNDRED);
        bowlingLineScoreUnderTest
                = new BowlingLineScore(generateFramesList10PairsOf9AndMiss());
        assertThat(bowlingLineScoreUnderTest.getTotalScore())
                .isEqualTo(NINETY);
    }
}