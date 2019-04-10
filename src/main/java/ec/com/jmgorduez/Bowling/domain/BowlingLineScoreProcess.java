package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreProcess;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreReader;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrameReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;
import java.util.function.Consumer;

public class BowlingLineScoreProcess implements IBowlingLineScoreProcess {
    @Override
    public void processBowlingLineScore(BufferedReader bufferedReader,
                                        IBowlingLineScoreReader bowlingLineScoreReader,
                                        IFrameReader frameReader,
                                        Consumer<Optional<IBowlingLineScore>> writeOutput) {
        try {
            while (true) {
                writeOutput.accept(
                        Optional.of(bowlingLineScoreReader
                                .readBowlingLineScore(bufferedReader, frameReader)));
            }
        } catch (IOException e) {
            writeOutput.accept(Optional.empty());
        }
    }
}
