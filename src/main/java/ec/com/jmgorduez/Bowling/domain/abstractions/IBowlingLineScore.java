package ec.com.jmgorduez.Bowling.domain.abstractions;

import java.io.BufferedReader;

public interface IBowlingLineScore {
    Integer getTotalScore();
    void addFrame(IFrame frame);
}
