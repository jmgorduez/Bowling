package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.AbstractFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

public class NormalFrame extends AbstractFrame {

    public NormalFrame(Integer pointsFirstBall, Integer pointsSecondBall, IFrame nextFrame){
        super(pointsFirstBall, pointsSecondBall, nextFrame);
    }
}
