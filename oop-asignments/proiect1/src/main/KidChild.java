package main;

public class KidChild extends Child {
    @Override
    public Double getAverageScore() {
        Double s = 0.0;
        for (Double score : this.getScores()) {
            s += score;
        }
        return (s / this.getScores().size());
    }
}
