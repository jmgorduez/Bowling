package ec.com.jmgorduez.Bowling.domain.abstractions;

public abstract class AbstractFrame implements IFrame {
    protected Integer pointsFirstBall;
    protected Integer pointsSecondBall;
    protected IFrame nextFrame;

    public AbstractFrame(Integer pointsFirstBall, Integer pointsSecondBall, IFrame nextFrame){
        this.pointsFirstBall = pointsFirstBall;
        this.pointsSecondBall = pointsSecondBall;
        this.nextFrame = nextFrame;
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
}
