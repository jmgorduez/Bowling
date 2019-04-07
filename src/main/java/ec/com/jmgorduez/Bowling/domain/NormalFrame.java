package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

public class NormalFrame implements IFrame {
    private Integer pointsFirstBall;
    private Integer pointsSecondBall;

    public NormalFrame(Integer pointsFirstBall, Integer pointsSecondBall){
        this.pointsFirstBall = pointsFirstBall;
        this.pointsSecondBall = pointsSecondBall;
    }

    @Override
    public Integer getPointsFirstBall() {
        return this.pointsFirstBall;
    }

    @Override
    public Integer getPointsSecondBall() {
        return this.pointsSecondBall;
    }

    @Override
    public Integer getBonusForStrike() {
        return pointsFirstBall + pointsSecondBall;
    }

    @Override
    public Integer getBonusForSpare() {
        return pointsFirstBall;
    }

    @Override
    public IFrame nextFrame() {
        return null;
    }
}
