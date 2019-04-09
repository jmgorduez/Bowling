package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.AbstractFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

public class NormalFrame extends AbstractFrame {

    public NormalFrame(Integer pointsFirstBall, Integer pointsSecondBall, IFrame nextFrame) {
        super(pointsFirstBall, pointsSecondBall, nextFrame);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NormalFrame)) {
            return false;
        }
        return this.pointsFirstBall().equals(((NormalFrame)other).pointsFirstBall())
                && this.pointsSecondBall().equals(((NormalFrame)other).pointsSecondBall())
                && this.nextFrame().equals(((NormalFrame)other).nextFrame());
    }
}
