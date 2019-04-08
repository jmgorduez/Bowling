package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.AbstractFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import static ec.com.jmgorduez.Bowling.utils.Constants.TEN;
import static ec.com.jmgorduez.Bowling.utils.Constants.ZERO;

public class StrikeFrame extends AbstractFrame {

    public StrikeFrame(IFrame nextFrame) {
        super(TEN, ZERO, nextFrame);
    }

    @Override
    public Integer bonusForStrike() {
        return TEN + nextFrame.pointsFirstBall();
    }

    @Override
    public Integer bonusForSpare() {
        return TEN;
    }

    @Override
    public Integer totalPoints() {
        return TEN + nextFrame.pointsFirstBall() + nextFrame.pointsSecondBall();
    }
}
