package ec.com.jmgorduez.Bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.IOException;

import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.STRING_LINE_12_STRIKES;
import static ec.com.jmgorduez.Bowling.dataGenarator.TestDataGenerator.generateFramesList12Strikes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class BowlingLineScoreReaderTest {

    private BowlingLineScoreReader bowlingLineScoreReaderUnderTest;
    @Mock
    private BufferedReader bufferedReaderMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.bowlingLineScoreReaderUnderTest = new BowlingLineScoreReader();
        try {
            when(bufferedReaderMock.readLine())
                    .thenReturn(STRING_LINE_12_STRIKES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void readScoreBowlingGame() {
        try {
            assertThat(bowlingLineScoreReaderUnderTest.readBowlingLineScore(bufferedReaderMock))
                    .isEqualTo(generateFramesList12Strikes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}