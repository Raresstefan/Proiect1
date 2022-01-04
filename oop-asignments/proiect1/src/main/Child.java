package main;

import enums.Category;
import enums.Cities;

import java.util.List;
public abstract class Child {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private Cities city;
    private Double niceScore;
    private List<Category> gifts;
    private List<Double> scores;
    /**
     * Method that is implemented by every class that extends Child class
     */
    public abstract Double getAverageScore();
    /**
     * Getter for the list of scores
     */
    public List<Double> getScores() {
        return scores;
    }
    /**
     * Getter for the id
     */
    public int getId() {
        return id;
    }
    /**
     * Getter for the last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Getter for the first name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Getter for age
     */
    public int getAge() {
        return age;
    }
    /**
     * Getter for city
     */
    public Cities getCity() {
        return city;
    }
    /**
     * Getter for nice score
     */
    public Double getNiceScore() {
        return niceScore;
    }
    /**
     * Getter for the list of gifts
     */
    public List<Category> getGifts() {
        return gifts;
    }
}
