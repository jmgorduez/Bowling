package ec.com.jmgorduez.Bowling;


import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IDependencesFactory;
import ec.com.jmgorduez.Bowling.utils.DependencesFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;

import static ec.com.jmgorduez.Bowling.utils.Constants.FILE_PATH_MAIN;

public class BowlingApplication {

    private static IDependencesFactory factory = new DependencesFactory();

    public static void main(String[] args) {
        try {
            factory.bowlingLineScoreProcess().processBowlingLineScore(
                    new BufferedReader(new FileReader(FILE_PATH_MAIN)),
                    factory::bowlingLineScoreReader,
                    factory::frameReader,
                    BowlingApplication::writeOutput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeOutput(Optional<IBowlingLineScore> bowlingLineScore) {
        bowlingLineScore.ifPresent(bowlingScore -> System.out.println(bowlingScore.getTotalScore()));
    }
}
