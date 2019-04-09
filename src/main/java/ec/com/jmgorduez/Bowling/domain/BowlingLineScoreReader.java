package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreReader;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ec.com.jmgorduez.Bowling.utils.Constants.*;

public class BowlingLineScoreReader implements IBowlingLineScoreReader {
    @Override
    public IBowlingLineScore readBowlingLineScore(BufferedReader bufferedReader)
            throws IOException {
        String line = bufferedReader.readLine();
        List<IFrame> frameList = stringToFramesList(line);
        IBowlingLineScore bowlingLineScore = new BowlingLineScore();
        frameList.stream().forEach(frame -> bowlingLineScore.addFrame(frame));
        return bowlingLineScore;
    }

    List<IFrame> stringToFramesList(String line) {
        String[] framesString = line.split(BLANK_SPACE_STRING);
        List<IFrame> frameList = new ArrayList<>();
        IFrame nextFrame = takeFinalFrame(framesString);
        frameList.add(nextFrame);
        int count = EIGHT;
        do {
            nextFrame = stringToFrame(framesString[count], nextFrame);
            frameList.add(ZERO, nextFrame);
            count--;
        } while (frameList.size() != TEN);
        return frameList;
    }

    String takeFinalFrameSection(String[] frames){
        if(isStrikeFinalFrame(frames)){
            return STRIKE_FINAL_FRAME_STRING;
        }
        return null;
    }

    boolean isStrikeFinalFrame(String[] frames) {
        return frames.length == TWELVE;
    }

    FinalFrame takeFinalFrame(String[] frames) {
        if(STRIKE_FINAL_FRAME_STRING.equals(takeFinalFrameSection(frames))){
            return STRIKE_FINAL_FRAME;
        }
        return null;
    }

    IFrame stringToFrame(String frameString, IFrame nextFrame) {
        switch (frameString) {
            case STRIKE_FRAME_STRING:
                return new StrikeFrame(nextFrame);
        }
        return null;
    }
}
