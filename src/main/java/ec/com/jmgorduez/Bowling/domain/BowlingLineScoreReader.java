package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreReader;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        IFrame currentFrame = takeFinalFrame(framesString);
        frameList.add(currentFrame);
        int count = EIGHT;
        do {
            currentFrame = stringToFrame(framesString[count], currentFrame);
            frameList.add(ZERO, currentFrame);
            count--;
        } while (frameList.size() != TEN);
        return frameList;
    }

    String takeFinalFrameSection(String[] frames){
        String[] finalFrameSection = Arrays.copyOfRange(frames, NINE, frames.length);
        return Arrays.stream(finalFrameSection).collect(Collectors.joining());
    }

    FinalFrame takeFinalFrame(String[] frames) {
        String finalframeSection = takeFinalFrameSection(frames);
        if(STRIKE_FINAL_FRAME_STRING.equals(finalframeSection)){
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
