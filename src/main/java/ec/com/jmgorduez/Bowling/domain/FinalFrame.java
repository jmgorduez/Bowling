package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.AbstractFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import java.util.Optional;
import java.util.function.Supplier;

import static ec.com.jmgorduez.Bowling.utils.Constants.NINE;
import static ec.com.jmgorduez.Bowling.utils.Constants.TEN;

public class FinalFrame extends AbstractFrame {

    private Integer pointsThirdBall;

    public FinalFrame(Integer pointsFirstBall, Integer pointsSecondBall, Integer pointsThirdBall) {
        super(pointsFirstBall, pointsSecondBall);
        this.pointsThirdBall = pointsThirdBall;
    }

    @Override
    public Integer totalPoints() {
        return super.totalPoints() + pointsThirdBall;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FinalFrame)) {
            return false;
        }
        return this.pointsFirstBall().equals(((FinalFrame)other).pointsFirstBall())
                && this.pointsSecondBall().equals(((FinalFrame)other).pointsSecondBall())
                && this.pointsThirdBall.equals(((FinalFrame)other).pointsThirdBall)
                && ((FinalFrame)other).nextFrame() == null;
    }
}
