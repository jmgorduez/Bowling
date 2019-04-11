package ec.com.jmgorduez.Bowling.domain.abstractions;

import java.io.BufferedReader;
import java.io.IOException;

public interface IBowlingLineScoreReader {
    IBowlingLineScore readBowlingLineScore(BufferedReader bufferedReader,
                                           IFrameReader frameReader)
            throws IOException, UnsupportedOperationException;
}
