package main;

public class TeenKid extends Child {
    @Override
    public Double getAverageScore() {
        Double sumScores = 0.0;
        int sumIndexes = 0;
        for (Double score : this.getScores()) {
            int index = this.getScores().indexOf(score);
            index++;
            sumScores += score * index;
            sumIndexes += index;
        }
        return sumScores / sumIndexes;
    }
}
