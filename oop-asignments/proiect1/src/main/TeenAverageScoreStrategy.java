package main;

import java.util.List;

public class TeenAverageScoreStrategy implements AverageScoreStrategy {
    private List<Double> scores;

    public TeenAverageScoreStrategy(List<Double> scores) {
        this.scores = scores;
    }
    /**
     * Method that returns the averageScore of a teen
     */
    @Override
    public Double getAverageScore() {
        Double sumScores = 0.0;
        int sumIndexes = 0;
        for (Double score : this.scores) {
            int index = this.scores.indexOf(score);
            index++;
            sumScores += score * index;
            sumIndexes += index;
        }
        return (sumScores / sumIndexes);
    }
}
