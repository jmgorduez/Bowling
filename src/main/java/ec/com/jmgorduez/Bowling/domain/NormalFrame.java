package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

public class NormalFrame implements IFrame {
    private Integer pointsFirstBall;

    public NormalFrame(Integer pointsFirstBall){
        this.pointsFirstBall = pointsFirstBall;
    }

    @Override
    public Integer getPointsFirstBall() {
        return this.pointsFirstBall;
    }

    @Override
    public Integer getPointsSecondBall() {
        return null;
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
    public IFrame getNextFrame() {
        return null;
    }
}
