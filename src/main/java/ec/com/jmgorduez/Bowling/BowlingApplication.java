package ec.com.jmgorduez.Bowling;


import ec.com.jmgorduez.Bowling.domain.BowlingLineScoreProcess;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreProcess;
import ec.com.jmgorduez.Bowling.domain.readers.BowlingLineScoreReader;
import ec.com.jmgorduez.Bowling.domain.readers.FrameReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;

import static ec.com.jmgorduez.Bowling.utils.Constants.FILE_PATH_MAIN;

public class BowlingApplication {

    private static IBowlingLineScoreProcess bowlingLineScoreProcess
            = new BowlingLineScoreProcess();

    public static void main(String[] args) {
        try {
            bowlingLineScoreProcess.processBowlingLineScore(
                    new BufferedReader(new FileReader(FILE_PATH_MAIN)),
                    new BowlingLineScoreReader(),
                    new FrameReader(),
                    BowlingApplication::writeOutput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeOutput(Optional<IBowlingLineScore> bowlingLineScore) {
        bowlingLineScore.ifPresent(bowlingScore -> System.out.println(bowlingScore.getTotalScore()));
    }
}
