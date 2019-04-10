package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreProcess;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreReader;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrameReader;

import java.io.BufferedReader;
import java.util.function.Consumer;

public class BowlingLineScoreProcess implements IBowlingLineScoreProcess {
    @Override
    public void processBowlingLineScore(BufferedReader bufferedReader,
                                        IBowlingLineScoreReader bowlingLineScoreReader,
                                        IFrameReader frameReader,
                                        Consumer<IBowlingLineScore> writeOutput) {

    }
}
