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
    public Integer pointsFirstBall() {
        return this.pointsFirstBall;
    }

    @Override
    public Integer pointsSecondBall() {
        return this.pointsSecondBall;
    }

    @Override
    public Integer bonusForStrike() {
        return pointsFirstBall + pointsSecondBall;
    }

    @Override
    public Integer bonusForSpare() {
        return pointsFirstBall;
    }

    @Override
    public IFrame nextFrame() {
        return this.nextFrame;
    }

    @Override
    public Integer totalPoints() {
        return this.pointsFirstBall + this.pointsSecondBall;
    }
}
