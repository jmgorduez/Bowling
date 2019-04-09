package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.AbstractFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import java.util.function.Supplier;

import static ec.com.jmgorduez.Bowling.utils.Constants.TEN;
import static ec.com.jmgorduez.Bowling.utils.Constants.ZERO;

public class StrikeFrame extends AbstractFrame {

    public StrikeFrame(Supplier<IFrame> nextFrame) {
        super(TEN, ZERO, nextFrame);
    }

    @Override
    public Integer totalPoints() {
        return super.totalPoints() + nextFrame().get().pointsFirstBall() + nextFrame().get().pointsSecondBall();
    }
}
