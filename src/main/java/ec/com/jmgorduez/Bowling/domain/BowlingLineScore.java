package ec.com.jmgorduez.Bowling.domain;

import ec.com.jmgorduez.Bowling.domain.abstractions.IBowlingLineScore;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

import java.util.List;

public class BowlingLineScore implements IBowlingLineScore {
    private List<IFrame> frameList;

    public BowlingLineScore(List<IFrame> frameList){
        this.frameList = frameList;
    }

    @Override
    public Integer getTotalScore() {
        return null;
    }
}
