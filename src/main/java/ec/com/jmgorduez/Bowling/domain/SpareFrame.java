package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.AbstractFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import java.util.Optional;
import java.util.function.Supplier;

public class SpareFrame extends AbstractFrame {

    public SpareFrame(Integer pointsFirstBall, Integer pointsSecondBall, IFrame nextFrame){
        super(pointsFirstBall, pointsSecondBall, nextFrame);
    }

    @Override
    public Integer totalPoints() {
        return super.totalPoints() + nextFrame.bonusForSpare();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpareFrame)) {
            return false;
        }
        return this.pointsFirstBall().equals(((SpareFrame)other).pointsFirstBall())
                && this.pointsSecondBall().equals(((SpareFrame)other).pointsSecondBall())
                && this.nextFrame().equals(((SpareFrame)other).nextFrame());
    }
}
