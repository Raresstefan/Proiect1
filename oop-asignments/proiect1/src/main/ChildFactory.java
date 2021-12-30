package main;

import enums.AgeCategory;

import java.util.List;

public class ChildFactory {
    public static AverageScoreStrategy createChild(final AgeCategory ageCategory, final List<Double> scores) {
        switch (ageCategory) {
            case BABY : return new BabyAverageScoreStrategy(scores);
            case KID : return new KidAverageScoreStrategy(scores);
            case TEEN : return new TeenAverageScoreStrategy(scores);
            case YOUNGADULT : return new YoungAdultStrategy(scores);
        }
        throw new IllegalArgumentException("The age category " + ageCategory + " is not recognized.");
    }
}
