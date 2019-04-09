package ec.com.jmgorduez.Bowling.domain.abstractions;

import java.util.Optional;
import java.util.function.Supplier;

public abstract class AbstractFrame implements IFrame {
    protected Integer pointsFirstBall;
    protected Integer pointsSecondBall;
    protected Optional<Supplier<IFrame>> nextFrame;

    public AbstractFrame(Integer pointsFirstBall, Integer pointsSecondBall, Supplier<IFrame> nextFrame){
        this(pointsFirstBall, pointsSecondBall);
        this.nextFrame = Optional.ofNullable(nextFrame);
    }

    public AbstractFrame(Integer pointsFirstBall, Integer pointsSecondBall){
        this.pointsFirstBall = pointsFirstBall;
        this.pointsSecondBall = pointsSecondBall;
        this.nextFrame = Optional.empty();
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
    public Optional<IFrame> nextFrame() {
        if(!nextFrame.isPresent()){
            return Optional.empty();
        }
        return Optional.ofNullable(this.nextFrame.get().get());
    }

    @Override
    public Integer totalPoints() {
        return this.pointsFirstBall + this.pointsSecondBall;
    }
}
