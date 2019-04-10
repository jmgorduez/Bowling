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

    List<IFrame> takeInitFrames(String[] framesString, IFrame lastFrame) {
        List<IFrame> frameList = new ArrayList<>();
        for (int index = EIGHT; frameList.size() != NINE; index--) {
            List<Integer> valuesOfFrame = mapStringFrameToValuesOfFrame(framesString[index]);
            lastFrame = mapListOfValuesFrameToFrame(valuesOfFrame, lastFrame);
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

    IFrame takeFinalFrame(String[] frames) {
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

    IFrame mapFinalValuesOfFrameToFinalFrame(List<Integer> finalFrameSection) {
        return mapListOfValuesFrameToFrame(finalFrameSection, EMPTY_FRAME);
    }

    int mapCharToInteger(char value, String finalFrameSection) {
        if (Character.isDigit(value)) {
            return Character.getNumericValue(value);
        }
        if (isAStrikeValue(value)) {
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

    IFrame mapListOfValuesFrameToFrame(List<Integer> valuesOfFrame, IFrame nextFrame) {
        if(isAFinalFrame(valuesOfFrame)){
            return new FinalFrame(valuesOfFrame.get(ZERO),
                    valuesOfFrame.get(ONE),valuesOfFrame.get(TWO));
        }
        if (isAStrikeFrame(valuesOfFrame)) {
            return new StrikeFrame(nextFrame);
        }
        if (isASpareFrame(valuesOfFrame)) {
            return new SpareFrame(valuesOfFrame.get(ZERO),
                    valuesOfFrame.get(ONE), nextFrame);
        }
        return new NormalFrame(valuesOfFrame.get(ZERO),
                valuesOfFrame.get(ONE), nextFrame);
    }

    boolean isAFinalFrame(List<Integer> valuesOfFrame) {
        return valuesOfFrame.size()== THREE;
    }

    boolean isASpareFrame(List<Integer> valuesOfFrame) {
        return valuesOfFrame.size() == TWO && valuesOfFrame.stream().mapToInt(Integer::intValue).sum() == TEN;
    }

    boolean isAStrikeFrame(List<Integer> valuesOfFrame) {
        return valuesOfFrame.size() == ONE && valuesOfFrame.get(ZERO).equals(TEN);
    }
}
