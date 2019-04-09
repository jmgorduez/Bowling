package ec.com.jmgorduez.Bowling.domain.abstractions;

public interface IFrame {

    IFrame nextFrame();

    Integer pointsFirstBall();

    Integer pointsSecondBall();

    Integer bonusForStrike();

    Integer bonusForSpare();

    Integer totalPoints();

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
        return this.pointsFirstBall().equals(other.pointsFirstBall())
                && this.pointsSecondBall().equals(other.pointsSecondBall())
                && this.nextFrame().equals(other.nextFrame());
    }
}
