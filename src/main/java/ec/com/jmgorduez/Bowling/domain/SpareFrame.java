package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.AbstractFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import java.util.function.Supplier;

public class SpareFrame extends AbstractFrame {

    public SpareFrame(Integer pointsFirstBall, Integer pointsSecondBall, Supplier<IFrame> nextFrame){
        super(pointsFirstBall, pointsSecondBall, nextFrame);
    }

    @Override
    public Integer totalPoints() {
        return super.totalPoints() + nextFrame().get().pointsFirstBall();
    }
}
