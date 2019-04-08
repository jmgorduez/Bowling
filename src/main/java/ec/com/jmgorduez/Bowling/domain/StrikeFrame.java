package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import static ec.com.jmgorduez.Bowling.utils.Constants.TEN;
import static ec.com.jmgorduez.Bowling.utils.Constants.ZERO;

public class StrikeFrame implements IFrame {

    private IFrame nextFrame;

    public StrikeFrame(IFrame nextFrame) {
        this.nextFrame = nextFrame;
    }

    @Override
    public Integer pointsFirstBall() {
        return TEN;
    }

    @Override
    public Integer pointsSecondBall() {
        return ZERO;
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
    public IFrame nextFrame() {
        return this.nextFrame;
    }

    @Override
    public Integer totalPoints() {
        return TEN + nextFrame.pointsFirstBall() + nextFrame.pointsSecondBall();
    }
}
