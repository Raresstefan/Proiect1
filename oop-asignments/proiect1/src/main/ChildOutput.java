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

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public void setGiftsPreferences(List<Category> giftsPreference) {
        this.giftsPreferences = giftsPreference;
    }

    public void setNiceScoreHistory(List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public void setAssignedBudget(Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public void setReceivedGifts(List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }
    public Double getAverageScore() {
        return this.averageScore;
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

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }
}
