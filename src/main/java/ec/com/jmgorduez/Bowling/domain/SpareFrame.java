package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.AbstractFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

public class SpareFrame extends AbstractFrame {

    public SpareFrame(Integer pointsFirstBall, Integer pointsSecondBall, IFrame nextFrame){
        super(pointsFirstBall, pointsSecondBall, nextFrame);
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
    public Integer totalPoints() {
        return pointsFirstBall + pointsSecondBall + nextFrame.pointsFirstBall();
    }
}
