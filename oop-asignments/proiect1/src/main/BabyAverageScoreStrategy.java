package main;

import java.util.List;

public class BabyAverageScoreStrategy implements AverageScoreStrategy {
    private List<Double> scores;
    /**
     * Method that sets the list of scores of the child
     */
    public BabyAverageScoreStrategy(final List<Double> scores) {
        this.scores = scores;
    }
    /**
     * Method overriden that returns the average score of the specific
     * type of child, baby child
     */
    @Override
    public Double getAverageScore() {
        return 10.0;
    }
}
