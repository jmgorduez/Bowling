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
    public Integer getPointsFirstBall() {
        return TEN;
    }

    @Override
    public Integer getPointsSecondBall() {
        return ZERO;
    }

    @Override
    public Integer getBonusForStrike() {
        return TEN + nextFrame.getPointsFirstBall();
    }

    @Override
    public Integer getBonusForSpare() {
        return TEN;
    }

    @Override
    public IFrame nextFrame() {
        return this.nextFrame;
    }

    @Override
    public Integer getPoints() {
        return null;
    }
}
