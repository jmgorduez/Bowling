package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.AbstractFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

public class FinalSpareFrame extends AbstractFrame {

    public FinalSpareFrame(Integer pointsFirstBall, Integer pointsSecondBall){
        super(pointsFirstBall, pointsSecondBall);
    }

    @Override
    public Integer totalPoints() {
        return null;
    }
}
