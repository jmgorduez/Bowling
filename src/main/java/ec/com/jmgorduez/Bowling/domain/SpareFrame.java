package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

public class SpareFrame implements IFrame {
    private Integer pointsFirstBall;
    private Integer pointsSecondBall;

    public SpareFrame(Integer pointsFirstBall, Integer pointsSecondBall){
        this.pointsFirstBall = pointsFirstBall;
        this.pointsSecondBall = pointsSecondBall;
    }

    @Override
    public Integer pointsFirstBall() {
        return pointsFirstBall;
    }

    @Override
    public Integer pointsSecondBall() {
        return pointsSecondBall;
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
