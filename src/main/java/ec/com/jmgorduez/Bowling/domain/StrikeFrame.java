package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import static ec.com.jmgorduez.Bowling.utils.Constants.TEN;
import static ec.com.jmgorduez.Bowling.utils.Constants.ZERO;

public class StrikeFrame implements IFrame {

    public StrikeFrame(){

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
        return null;
    }

    @Override
    public Integer getBonusForSpare() {
        return null;
    }

    @Override
    public IFrame nextFrame() {
        return null;
    }

    @Override
    public Integer getPoints() {
        return null;
    }
}
