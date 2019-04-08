package ec.com.jmgorduez.Bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.THREE_HUNDRED;
import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.generateFramesList12Rolls12Strikes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BowlingLineScoreTest {

    private BowlingLineScore bowlingLineScoreUnderTest;

    @BeforeEach
    void setUp() {
        bowlingLineScoreUnderTest
                = new BowlingLineScore(generateFramesList12Rolls12Strikes());
    }

    @Test
    void getTotalScore() {
        assertThat(bowlingLineScoreUnderTest.getTotalScore())
                .isEqualTo(THREE_HUNDRED);
    }
}