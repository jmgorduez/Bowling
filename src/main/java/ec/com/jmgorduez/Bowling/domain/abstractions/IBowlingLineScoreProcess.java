package ec.com.jmgorduez.Bowling.domain.abstractions;

import java.io.BufferedReader;
import java.util.function.Consumer;

public interface IBowlingLineScoreProcess {
    Integer processBowlingLineScore(BufferedReader bufferedReader,
                                 IBowlingLineScoreReader bowlingLineScoreReader,
                                 Consumer<IBowlingLineScore> writeOutput);
}
