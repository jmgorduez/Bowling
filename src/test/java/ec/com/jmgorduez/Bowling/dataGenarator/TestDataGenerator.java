package ec.com.jmgorduez.Bowling.dataGenarator;

import ec.com.jmgorduez.Bowling.domain.FinalFrame;
import ec.com.jmgorduez.Bowling.domain.NormalFrame;
import ec.com.jmgorduez.Bowling.domain.SpareFrame;
import ec.com.jmgorduez.Bowling.domain.StrikeFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static ec.com.jmgorduez.Bowling.utils.Constants.*;
import static org.mockito.ArgumentMatchers.any;

public class TestDataGenerator {

    public static final NormalFrame NORMAL_FRAME_4_4 = new NormalFrame(FOUR, FOUR, null);
    public static final NormalFrame NORMAL_FRAME_4_5 = new NormalFrame(FOUR, FIVE, NORMAL_FRAME_4_4);
    public static final StrikeFrame STRIKE_FRAME = new StrikeFrame(NORMAL_FRAME_4_5);
    public static final FinalFrame FINAL_NORMAL_FRAME_9_ = new FinalFrame(NINE, ZERO, ZERO);

    public static final Integer THREE_HUNDRED = 300;
    public static final Integer NINETY = 90;
    public static final Integer ONE_HUNDRED_FIFTY = 150;

    public static final String STRING_LINE_12_STRIKES = "X X X X X X X X X X X X";
    public static final String STRING_LINE_10_PAIRS_OF_9_AND_MISS = "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-";

    public static final String FINAL_FRAME_10_PAIRS_OF_9_AND_MISS_STRING = "9-";

    public static final String FINAL_FRAME_10_PAIRS_OF_9_AND_MISS_MISS_STRING
            = FINAL_FRAME_10_PAIRS_OF_9_AND_MISS_STRING.concat(CHARACTER_MISS.toString());

    public static final String[] STRING_ARRAY_12_STRIKES = STRING_LINE_12_STRIKES.split(BLANK_SPACE_STRING);
    public static final String[] STRING_ARRAY_10_PAIRS_OF_9_AND_MISS = STRING_LINE_10_PAIRS_OF_9_AND_MISS.split(BLANK_SPACE_STRING);

    public static List<IFrame> generateFramesList12Strikes() {
        List<IFrame> frameList = new ArrayList<>();
        IFrame nextFrame = new FinalFrame(TEN, TEN, TEN);
        frameList.add(nextFrame);
        for (int i = ZERO; i < NINE; i++) {
            StrikeFrame strikeFrame = new StrikeFrame(nextFrame);
            frameList.add(ZERO, strikeFrame);
            nextFrame = strikeFrame;
        }
        return frameList;
    }

    public static List<IFrame> generateFramesList10PairsOf9AndMiss() {
        List<IFrame> frameList = new ArrayList<>();
        IFrame nextFrame = new FinalFrame(NINE, ZERO, ZERO);
        frameList.add(nextFrame);
        for (int i = ZERO; i < NINE; i++) {
            NormalFrame normalFrame = new NormalFrame(NINE, ZERO, nextFrame);
            frameList.add(ZERO, normalFrame);
            nextFrame = normalFrame;
        }
        return frameList;
    }

    public static List<IFrame> generateFramesList10PairsOf5AndSpareWithAFinal5() {
        List<IFrame> frameList = new ArrayList<>();
        IFrame nextFrame = new FinalFrame(FIVE, FIVE, FIVE);
        frameList.add(nextFrame);
        for (int i = ZERO; i < NINE; i++) {
            SpareFrame normalFrame = new SpareFrame(FIVE, FIVE, nextFrame);
            frameList.add(ZERO, normalFrame);
            nextFrame = normalFrame;
        }
        return frameList;
    }
}
