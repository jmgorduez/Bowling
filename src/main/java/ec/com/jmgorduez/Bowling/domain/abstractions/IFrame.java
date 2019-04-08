package ec.com.jmgorduez.Bowling.domain.abstractions;

import ec.com.jmgorduez.Bowling.domain.NormalFrame;

public interface IFrame {
    Integer getPointsFirstBall();

    Integer getPointsSecondBall();

    Integer getBonusForStrike();

    Integer getBonusForSpare();

    IFrame nextFrame();

    Integer getPoints();

    default boolean equals(IFrame other) {
        if (this == other) {
            return true;
        }
        if (other == null){
            return false;
        }
        if (!(other.getClass().equals(this.getClass()))) {
            return false;
        }
        return this.getPointsFirstBall().equals(other.getPointsFirstBall())
                && this.getPointsSecondBall().equals(other.getPointsSecondBall())
                && this.nextFrame().equals(other.nextFrame());
    }
}
