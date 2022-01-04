package main;

import enums.Category;
import enums.Cities;

import java.util.ArrayList;
import java.util.List;

public class ChildOutput {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private int age;
    private List<Category> giftsPreferences;
    private Double averageScore;
    private List<Double> niceScoreHistory;
    private Double assignedBudget;
    private List<Gift> receivedGifts;

    public ChildOutput() {
        this.giftsPreferences = new ArrayList<>();
        this.niceScoreHistory = new ArrayList<>();
        this.receivedGifts = new ArrayList<>();
    }
    /**
     * Setter for the id
     */
    public void setId(final int id) {
        this.id = id;
    }
    /**
     * Setter for the last name
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    /**
     * Setter for the first name
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    /**
     * Setter for age
     */
    public void setAge(final int age) {
        this.age = age;
    }
    /**
     * Setter for the city
     */
    public void setCity(final Cities city) {
        this.city = city;
    }
    /**
     * Setter for the gifts preferences that the child has
     */
    public void setGiftsPreferences(final List<Category> giftsPreference) {
        this.giftsPreferences.addAll(giftsPreference);
    }
    /**
     * Setter for the list of nice scores of the child
     */
    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory.addAll(niceScoreHistory);
    }
    /**
     * Setter for the budget assigned to the child
     */
    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }
    /**
     * Setter for the list of gifts received by the child
     */
    public void setReceivedGifts(final List<Gift> receivedGifts) {
        this.receivedGifts.addAll(receivedGifts);
    }
    /**
     * Setter for the average score of the child
     */
    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }
    /**
     * Getter for the average score
     */
    public Double getAverageScore() {
        return this.averageScore;
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
     * Getter for the city
     */
    public Cities getCity() {
        return city;
    }
    /**
     * Getter for the list of gifts preferences
     */
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }
    /**
     * Getter for the list of nice scores of the child
     */
    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }
    /**
     * Getter for the budget assigned to the child
     */
    public Double getAssignedBudget() {
        return assignedBudget;
    }
    /**
     * Getter for the list of gifts received by the child
     */
    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }
}
