package ec.com.jmgorduez.Bowling.utils;

import ec.com.jmgorduez.Bowling.domain.BowlingLineScoreProcess;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreProcess;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreReader;
import ec.com.jmgorduez.Bowling.domain.abstractions.factories.IDependencesFactory;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrameReader;
import ec.com.jmgorduez.Bowling.domain.readers.BowlingLineScoreReader;
import ec.com.jmgorduez.Bowling.domain.readers.FrameReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;

import static ec.com.jmgorduez.Bowling.utils.Constants.FILE_PATH_MAIN;

public class DependencesFactory implements IDependencesFactory {
    @Override
    public IBowlingLineScoreProcess bowlingLineScoreProcess() {
        return new BowlingLineScoreProcess();
    }

    @Override
    public IBowlingLineScoreReader bowlingLineScoreReader() {
        return new BowlingLineScoreReader();
    }

    @Override
    public IFrameReader frameReader() {
        return new FrameReader();
    }
}
