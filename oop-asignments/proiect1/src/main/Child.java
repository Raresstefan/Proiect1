package main;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import enums.AgeCategory;
import enums.Category;
import enums.Cities;

import java.util.List;
@JsonDeserialize(as=Child.class)
public abstract class Child {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private Cities city;
    private Double niceScore;
    private List<Category> gifts;
    private List<Double> scores;
    public abstract Double getAverageScore();



    public List<Double> getScores() {
        return scores;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public Cities getCity() {
        return city;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public List<Category> getGifts() {
        return gifts;
    }
}
