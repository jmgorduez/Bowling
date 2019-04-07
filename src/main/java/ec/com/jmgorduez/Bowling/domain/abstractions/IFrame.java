package ec.com.jmgorduez.Bowling.domain.abstractions;

public interface IFrame {
    Integer getPointsFirstBall();
    Integer getPointsSecondBall();
    Integer getBonusForStrike();
    Integer getBonusForSpare();
    IFrame nextFrame();
    Integer getPoints();
}
