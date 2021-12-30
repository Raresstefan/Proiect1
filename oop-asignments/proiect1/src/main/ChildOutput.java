package main;

import enums.Category;
import enums.Cities;

import java.util.ArrayList;
import java.util.List;

public class ChildOutput {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private Cities city;
    private List<Category> giftsPreference;
    private List<Double> niceScoreHistory = new ArrayList<>();
    private Double assignedBudget;
    private List<Gift> receivedGifts = new ArrayList<>();
    private Double averageScore;

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

    public void setGiftsPreference(List<Category> giftsPreference) {
        this.giftsPreference = giftsPreference;
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
}
