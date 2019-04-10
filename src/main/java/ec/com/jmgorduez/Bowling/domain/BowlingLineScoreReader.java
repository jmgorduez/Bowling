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
        IFrame finalFrame = takeFinalFrame(framesString);
        frameList.addAll(takeInitFrames(framesString, finalFrame));
        frameList.add(finalFrame);
        return frameList;
    }

    List<IFrame> takeInitFrames(String[] framesString , IFrame lastFrame) {
        List<IFrame> frameList = new ArrayList<>();
        for (int index = EIGHT; frameList.size() != NINE  ; index--) {
            lastFrame = stringToFrame(framesString[index], lastFrame);
            frameList.add(ZERO, lastFrame);
        }
        return frameList;
    }

    String takeFinalFrameString(String[] frames) {
        String[] finalFrameSection = Arrays.copyOfRange(frames, NINE, frames.length);
        return completeFinalCharacterIfItNeed(
                Arrays.stream(finalFrameSection)
                        .collect(Collectors.joining()));
    }

    String completeFinalCharacterIfItNeed(String finalFrameSection) {
        if (finalFrameSection.length() < THREE) {
            return finalFrameSection.concat(CHARACTER_MISS.toString());
        }
        return finalFrameSection;
    }

    FinalFrame takeFinalFrame(String[] frames) {
        String finalFrameSection = takeFinalFrameString(frames);
        return mapFinalValuesOfFrameToFinalFrame(
                mapStringFrameToValuesOfFrame(finalFrameSection));
    }

    List<Integer> mapStringFrameToValuesOfFrame(String finalFrameSection) {
        return finalFrameSection.chars()
                .mapToObj(value -> (char) value)
                .map(character -> mapCharToInteger(character, finalFrameSection))
                .collect(Collectors.toList());
    }

    FinalFrame mapFinalValuesOfFrameToFinalFrame(List<Integer> finalFrameSection) {
        return new FinalFrame(finalFrameSection.get(ZERO),
                finalFrameSection.get(ONE),
                finalFrameSection.get(TWO));
    }

    int mapCharToInteger(char value, String finalFrameSection) {
        if (Character.isDigit(value)) {
            return Character.getNumericValue(value);
        }
        if(isAStrikeValue(value)){
            return TEN;
        }
        if (isAMissValue(value)) {
            return ZERO;
        }
        return getRemainder(finalFrameSection, value);
    }

    boolean isAStrikeValue(char value) {
        return CHARACTER_STRIKE.equals(value);
    }

    boolean isAMissValue(char value) {
        return CHARACTER_MISS.equals(value);
    }

    Integer getRemainder(String finalFrameSection, char value) {
        int index = finalFrameSection.indexOf(value);
        return TEN - Character.getNumericValue(finalFrameSection.charAt(index - ONE));
    }

    IFrame stringToFrame(String frameString, IFrame nextFrame) {
        List<Integer> valuesOfFrame = mapStringFrameToValuesOfFrame(frameString);
        if(isAStrike(valuesOfFrame)) {
            return new StrikeFrame(nextFrame);
        }
        return null;
    }

    boolean isAStrike(List<Integer> valuesOfFrame) {
        return valuesOfFrame.size() == ONE && valuesOfFrame.get(ZERO).equals(TEN);
    }
}
