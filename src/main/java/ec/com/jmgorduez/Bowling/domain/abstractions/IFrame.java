package ec.com.jmgorduez.Bowling.domain.abstractions;

public interface IFrame {

    IFrame nextFrame();

    Integer pointsFirstBall();

    Integer pointsSecondBall();

    Integer bonusForStrike();

    Integer bonusForSpare();

    Integer totalPoints();
}
