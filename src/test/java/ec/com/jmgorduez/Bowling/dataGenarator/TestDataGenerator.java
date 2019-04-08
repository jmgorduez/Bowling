package ec.com.jmgorduez.Bowling.dataGenarator;

import ec.com.jmgorduez.Bowling.domain.FinalFrame;
import ec.com.jmgorduez.Bowling.domain.NormalFrame;
import ec.com.jmgorduez.Bowling.domain.StrikeFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static ec.com.jmgorduez.Bowling.utils.Constants.*;
import static org.mockito.ArgumentMatchers.any;

public class TestDataGenerator {
    public static final NormalFrame NORMAL_FRAME_4_5 = new NormalFrame(FOUR, FIVE, any());
    public static final Integer THREE_HUNDRED = 300;
    public static final Integer NINETY = 90;

    public static List<IFrame> generateFramesList12Strikes() {
        List<IFrame> frameList = new ArrayList<>();
        FinalFrame finalFrame = new FinalFrame(TEN, TEN, TEN);
        frameList.add(finalFrame);
        for (int i = 0; i < 9; i++) {
            StrikeFrame strikeFrame = new StrikeFrame(finalFrame);
            frameList.add(ZERO,strikeFrame);
        }
        return frameList;
    }

    public static List<IFrame> generateFramesList10PairsOf9AndMiss() {
        List<IFrame> frameList = new ArrayList<>();
        FinalFrame finalFrame = new FinalFrame(NINE, ZERO, ZERO);
        frameList.add(finalFrame);
        for (int i = 0; i < 9; i++) {
            NormalFrame normalFrame = new NormalFrame(NINE, ZERO, finalFrame);
            frameList.add(ZERO,normalFrame);
        }
        return frameList;
    }
}
