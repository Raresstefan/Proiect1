package main;

import java.util.List;

public class YoungAdultStrategy implements AverageScoreStrategy {
    List<Double> scores;

    public YoungAdultStrategy(List<Double> scores) {
        this.scores = scores;
    }

    @Override
    public Double getAverageScore() {
        return null;
    }
}
