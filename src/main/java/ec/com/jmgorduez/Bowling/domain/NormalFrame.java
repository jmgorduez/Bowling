package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.AbstractFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import java.util.function.Supplier;

public class NormalFrame extends AbstractFrame {

    public NormalFrame(Integer pointsFirstBall, Integer pointsSecondBall, Supplier<IFrame> nextFrame){
        super(pointsFirstBall, pointsSecondBall, nextFrame);
    }
}
