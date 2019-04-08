package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.AbstractFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

public class FinalFrame extends AbstractFrame {

    private Integer pointsThirdBall;

    public FinalFrame(Integer pointsFirstBall, Integer pointsSecondBall, Integer pointsThirdBall){
        super(pointsFirstBall, pointsSecondBall);
        this.pointsThirdBall = pointsThirdBall;
    }

    @Override
    public Integer totalPoints() {
        return super.totalPoints() + pointsThirdBall;
    }
}
