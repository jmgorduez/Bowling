package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreReader;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;
import ec.com.jmgorduez.Bowling.utils.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static ec.com.jmgorduez.Bowling.utils.Constants.*;

public class BowlingLineScoreReader implements IBowlingLineScoreReader {
    @Override
    public IBowlingLineScore readBowlingLineScore(BufferedReader bufferedReader)
            throws IOException {
        String line = bufferedReader.readLine();
        String[] framesString = line.split(BLANK_SPACE_STRING);
        List<IFrame> frameList = new ArrayList<>();
        IFrame nextFrame = stringToFinalStrikeFrame();
        frameList.add(nextFrame);
        int count = EIGHT;
        do {
            nextFrame = stringToFrame(framesString[count], nextFrame);
            frameList.add(ZERO, nextFrame);
            count--;
        } while (frameList.size() != TEN);
        IBowlingLineScore bowlingLineScore = new BowlingLineScore();
        frameList.stream().forEach(frame -> bowlingLineScore.addFrame(frame));
        return bowlingLineScore;
    }

    IFrame stringToFinalStrikeFrame() {
        return new FinalFrame(TEN, TEN, TEN);
    }

    IFrame stringToFrame(String frameString, IFrame nextFrame) {
        switch (frameString) {
            case STRIKE_FRAME_STRING:
                return new StrikeFrame(nextFrame);
        }
        return null;
    }
}
