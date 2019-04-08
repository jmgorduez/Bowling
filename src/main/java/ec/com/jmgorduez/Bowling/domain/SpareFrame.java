package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

public class SpareFrame implements IFrame {
    private Integer pointsFirstBall;

    public SpareFrame(Integer pointsFirstBall){
        this.pointsFirstBall = pointsFirstBall;
    }

    @Override
    public Integer pointsFirstBall() {
        return pointsFirstBall;
    }

    @Override
    public Integer pointsSecondBall() {
        return null;
    }

    @Override
    public Integer bonusForStrike() {
        return null;
    }

    @Override
    public Integer bonusForSpare() {
        return null;
    }

    @Override
    public IFrame nextFrame() {
        return null;
    }

    @Override
    public Integer totalPoints() {
        return null;
    }
}
