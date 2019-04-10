package ec.com.jmgorduez.Bowling.domain.abstractions;

import java.io.BufferedReader;
import java.util.Optional;
import java.util.function.Consumer;

public interface IBowlingLineScoreProcess {
    void processBowlingLineScore(BufferedReader bufferedReader,
                                 IBowlingLineScoreReader bowlingLineScoreReader,
                                 IFrameReader frameReader,
                                 Consumer<Optional<IBowlingLineScore>> writeOutput);
}
