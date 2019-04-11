package ec.com.jmgorduez.Bowling.domain.abstractions;

import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreProcess;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreReader;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrameReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Optional;

public interface IDependencesFactory {
    IBowlingLineScoreProcess bowlingLineScoreProcess();

    IBowlingLineScoreReader bowlingLineScoreReader();

    IFrameReader frameReader();
}
