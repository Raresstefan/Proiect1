package main;

import java.util.List;

public class KidAverageScoreStrategy implements AverageScoreStrategy {
    private List<Double> scores;

    public KidAverageScoreStrategy(final List<Double> scores) {
        this.scores = scores;
    }
    /**
     * Method that returns the averageScore of a kid
     */
    @Override
    public Double getAverageScore() {
        Double s = 0.0;
        for (Double score : this.scores) {
            s += score;
        }
        return (s / this.scores.size());
    }
}
