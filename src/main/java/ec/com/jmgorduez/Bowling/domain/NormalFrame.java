package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

public class NormalFrame implements IFrame {
    private Integer pointsFirstBall;
    private Integer pointsSecondBall;
    private IFrame nextFrame;

    public NormalFrame(Integer pointsFirstBall, Integer pointsSecondBall, IFrame nextFrame){
        this.pointsFirstBall = pointsFirstBall;
        this.pointsSecondBall = pointsSecondBall;
        this.nextFrame = nextFrame;
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
        return this.nextFrame;
    }

    @Override
    public Integer getPoints() {
        return this.pointsFirstBall + this.pointsSecondBall;
    }
}
