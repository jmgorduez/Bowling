package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import java.util.ArrayList;
import java.util.List;

public class BowlingLineScore implements IBowlingLineScore {
    List<IFrame> frameList;

    public BowlingLineScore() {
        this.frameList = new ArrayList<>();
    }

    @Override
    public Integer getTotalScore() {
        return frameList.stream().mapToInt(iFrame -> iFrame.totalPoints())
                .sum();
    }

    @Override
    public void addFrame(IFrame frame) {
        frameList.add(frame);
    }
}
