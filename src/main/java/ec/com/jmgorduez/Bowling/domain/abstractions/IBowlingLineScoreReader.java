package ec.com.jmgorduez.Bowling.domain.abstractions;

import java.io.BufferedReader;
import java.io.IOException;

public interface IBowlingLineScoreReader {
    IBowlingLineScore readScoreBowlingGame(BufferedReader bufferedReader) throws IOException;
}
