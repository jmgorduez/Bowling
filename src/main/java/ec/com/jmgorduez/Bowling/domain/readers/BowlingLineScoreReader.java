package ec.com.jmgorduez.Bowling.domain.readers;

import ec.com.jmgorduez.Bowling.domain.BowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScoreReader;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrameReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static ec.com.jmgorduez.Bowling.utils.Constants.*;

public class BowlingLineScoreReader implements IBowlingLineScoreReader {

    @Override
    public IBowlingLineScore readBowlingLineScore(BufferedReader bufferedReader,
                                                  IFrameReader frameReader)
            throws IOException, UnsupportedOperationException {
        String line = bufferedReader.readLine();
        validateTheEndToRead(line);
        List<IFrame> frameList = stringToFramesList(line, frameReader);
        IBowlingLineScore bowlingLineScore = new BowlingLineScore();
        frameList.stream().forEach(frame -> bowlingLineScore.addFrame(frame));
        return bowlingLineScore;
    }

    void validateTheEndToRead(String line) {
        if(line == null){
            throw new UnsupportedOperationException();
        }
    }

    List<IFrame> stringToFramesList(String line, IFrameReader frameReader) {
        String[] framesString = line.split(BLANK_SPACE_STRING);
        List<IFrame> frameList = new ArrayList<>();
        IFrame finalFrame = takeFinalFrame(framesString, frameReader);
        frameList.addAll(takeInitFrames(framesString, finalFrame, frameReader));
        frameList.add(finalFrame);
        return frameList;
    }

    List<IFrame> takeInitFrames(String[] framesString, IFrame lastFrame, IFrameReader frameReader) {
        List<IFrame> frameList = new ArrayList<>();
        for (int index = EIGHT; frameList.size() != NINE; index--) {
            List<Integer> valuesOfFrame = mapStringFrameToValuesOfFrame(framesString[index]);
            lastFrame = frameReader.readFrame(valuesOfFrame, lastFrame);
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

    IFrame takeFinalFrame(String[] frames, IFrameReader frameReader) {
        String finalFrameSection = takeFinalFrameString(frames);
        return mapFinalValuesOfFrameToFinalFrame(
                mapStringFrameToValuesOfFrame(finalFrameSection),frameReader);
    }

    List<Integer> mapStringFrameToValuesOfFrame(String finalFrameSection) {
        return finalFrameSection.chars()
                .mapToObj(value -> (char) value)
                .map(character -> mapCharToInteger(character, finalFrameSection))
                .collect(Collectors.toList());
    }

    IFrame mapFinalValuesOfFrameToFinalFrame(List<Integer> finalFrameSection, IFrameReader frameReader) {
        return frameReader.readFrame(finalFrameSection, EMPTY_FRAME);
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
}
