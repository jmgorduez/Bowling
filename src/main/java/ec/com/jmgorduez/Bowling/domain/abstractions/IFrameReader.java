package ec.com.jmgorduez.Bowling.domain.abstractions;

import java.util.List;
import java.util.function.Supplier;

public interface IFrameReader {
    IFrame readFrame(List<Integer> valuesOfFrame, IFrame nextFrame);
}
