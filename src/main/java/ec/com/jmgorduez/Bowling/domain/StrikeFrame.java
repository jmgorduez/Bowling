package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.AbstractFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import java.util.Optional;
import java.util.function.Supplier;

import static ec.com.jmgorduez.Bowling.utils.Constants.TEN;
import static ec.com.jmgorduez.Bowling.utils.Constants.ZERO;

public class StrikeFrame extends AbstractFrame {

    public StrikeFrame(IFrame nextFrame) {
        super(TEN, ZERO, nextFrame);
    }

    @Override
    public Integer bonusForStrike() {
        return pointsFirstBall() + nextFrame.pointsFirstBall();
    }

    @Override
    public Integer totalPoints() {
        return super.totalPoints()
                + nextFrame.bonusForStrike();
    }
}
