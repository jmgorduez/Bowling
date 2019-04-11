package ec.com.jmgorduez.Bowling.domain.abstractions;

import java.io.BufferedReader;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface IBowlingLineScoreProcess {
    void processBowlingLineScore(BufferedReader bufferedReader,
                                 Supplier<IBowlingLineScoreReader> bowlingLineScoreReader,
                                 Supplier<IFrameReader> frameReader,
                                 Consumer<Optional<IBowlingLineScore>> writeOutput);
}
