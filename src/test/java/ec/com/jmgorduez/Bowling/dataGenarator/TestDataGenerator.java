package ec.com.jmgorduez.Bowling.dataGenarator;

import ec.com.jmgorduez.Bowling.domain.NormalFrame;

import static ec.com.jmgorduez.Bowling.utils.Constants.FIVE;
import static ec.com.jmgorduez.Bowling.utils.Constants.FOUR;
import static org.mockito.ArgumentMatchers.any;

public class TestDataGenerator {
    public static final NormalFrame NORMAL_FRAME_4_5 = new NormalFrame(FOUR, FIVE, any());
}
