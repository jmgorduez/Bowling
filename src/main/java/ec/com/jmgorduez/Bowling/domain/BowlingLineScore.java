package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import java.util.List;

public class BowlingLineScore implements IBowlingLineScore {
    List<IFrame> frameList;

    public BowlingLineScore(List<IFrame> frameList) {
        this.frameList = frameList;
    }

    @Override
    public Integer getTotalScore() {
        return frameList.stream().mapToInt(iFrame -> iFrame.totalPoints())
                .sum();
    }

    @Override
    public void addFrame(IFrame frame) {

    }
}
