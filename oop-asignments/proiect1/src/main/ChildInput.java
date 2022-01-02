package main;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import enums.AgeCategory;
import enums.Category;
import enums.Cities;

import java.util.ArrayList;
import java.util.List;
//@JsonIgnoreProperties({ "giftsPreferences"})
public class ChildInput {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private Cities city;
    private Double niceScore;
    private List<Category> giftsPreferences;
    private List<Double> scores = new ArrayList<>();
    private Double budgetAllocated;
    private List<Gift> receivedGifts = new ArrayList<>();
    private Double averageScore;

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public Double getBudgetAllocated() {
        return budgetAllocated;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setBudgetAllocated(Double budgetAllocated) {
        this.budgetAllocated = budgetAllocated;
    }

    public List<Gift> getReceivedGifts() {
        return receivedGifts;
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

    public void incrementAge() {
        this.age++;
    }
    public void update(ChildUpdate childUpdate) {
        // add niceScore to history if it's not null
        if (childUpdate.getNiceScore() != null) {
            this.scores.add(childUpdate.getNiceScore());
            this.niceScore = childUpdate.getNiceScore();
        }
        // add new preferences
        for (Category category : childUpdate.getGiftsPreferences()) {
            this.giftsPreferences.add(0, category);
        }
    }
    public void allocateGiftFromSanta(SantaClaus santaClaus) {
        Double theBudget = this.budgetAllocated;
            for (Category category : this.giftsPreferences) {
                if (theBudget <= 0.0) {
                    break;
                }
                Gift gift = santaClaus.searchGiftByPreference(category);
                if (gift != null) {
                    if (!(receivedGifts.contains(gift))) {
                        receivedGifts.add(gift);
                        theBudget -= gift.getPrice();
                    }
                }
            }
    }
    public List<Category> getGifts() {
        return giftsPreferences;
    }

    public List<Double> getScores() {
        return scores;
    }
}
