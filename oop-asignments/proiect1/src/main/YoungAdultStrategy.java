package main;

import java.util.List;

public class YoungAdultStrategy implements AverageScoreStrategy {
    private List<Double> scores;

    public YoungAdultStrategy(final List<Double> scores) {
        this.scores = scores;
    }
    /**
     * Method overriden for the specific type of child, young adult
     */
    @Override
    public Double getAverageScore() {
        return null;
    }
}
