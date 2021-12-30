package main;

import java.util.List;

public class BabyAverageScoreStrategy implements AverageScoreStrategy {
    private List<Double> scores;

    public BabyAverageScoreStrategy(List<Double> scores) {
        this.scores = scores;
    }

    @Override
    public Double getAverageScore() {
        return 10.0;
    }
}
