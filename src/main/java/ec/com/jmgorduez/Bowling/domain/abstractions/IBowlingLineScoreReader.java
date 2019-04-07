package ec.com.jmgorduez.Bowling.domain.abstractions;

import java.io.BufferedReader;

public interface IBowlingLineScoreReader {
    IBowlingLineScore readScoreBowlingGame(BufferedReader bufferedReader);
}
