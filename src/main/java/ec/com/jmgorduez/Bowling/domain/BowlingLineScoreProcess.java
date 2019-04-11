package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreProcess;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreReader;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrameReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BowlingLineScoreProcess implements IBowlingLineScoreProcess {
    @Override
    public void processBowlingLineScore(BufferedReader bufferedReader,
                                        Supplier<IBowlingLineScoreReader> bowlingLineScoreReader,
                                        Supplier<IFrameReader> frameReader,
                                        Consumer<Optional<IBowlingLineScore>> writeOutput) {
        try {
            while (true) {
                writeOutput.accept(
                        Optional.of(bowlingLineScoreReader.get()
                                .readBowlingLineScore(bufferedReader, frameReader.get())));
            }
        } catch (IOException | UnsupportedOperationException e) {
            writeOutput.accept(Optional.empty());
        }
    }
}
