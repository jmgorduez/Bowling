package ec.com.jmgorduez.Bowling.domain.abstractions;

public abstract class AbstractFrame implements IFrame {
    protected Integer pointsFirstBall;
    protected Integer pointsSecondBall;
    protected IFrame nextFrame;

    public AbstractFrame(Integer pointsFirstBall, Integer pointsSecondBall, IFrame nextFrame){
        this(pointsFirstBall, pointsSecondBall);
        this.nextFrame = nextFrame;
    }

    public AbstractFrame(Integer pointsFirstBall, Integer pointsSecondBall){
        this.pointsFirstBall = pointsFirstBall;
        this.pointsSecondBall = pointsSecondBall;
        this.nextFrame = null;
    }

    @Override
    public Integer pointsFirstBall() {
        return this.pointsFirstBall;
    }

    @Override
    public Integer pointsSecondBall() {
        return this.pointsSecondBall;
    }

    @Override
    public IFrame nextFrame() {
        return this.nextFrame;
    }

    @Override
    public Integer bonusForStrike() {
        return pointsFirstBall + pointsSecondBall;
    }

    @Override
    public Integer bonusForSpare() {
        return pointsFirstBall;
    }

    @Override
    public Integer totalPoints() {
        return this.pointsFirstBall + this.pointsSecondBall;
    }

    @Override
    public void setNextFrame(IFrame nextFrame) {
        this.nextFrame = nextFrame;
    }
}
