package ec.com.jmgorduez.Bowling.domain.readers;

import ec.com.jmgorduez.Bowling.domain.FinalFrame;
import ec.com.jmgorduez.Bowling.domain.NormalFrame;
import ec.com.jmgorduez.Bowling.domain.SpareFrame;
import ec.com.jmgorduez.Bowling.domain.StrikeFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrameReader;

import java.util.List;
import java.util.function.Supplier;

import static ec.com.jmgorduez.Bowling.utils.Constants.*;

public class FrameReader implements IFrameReader {

    @Override
    public IFrame readFrame(List<Integer> valuesOfFrame, IFrame nextFrame) {
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
