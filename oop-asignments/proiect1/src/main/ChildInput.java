package main;
import enums.Category;
import enums.Cities;
import java.util.ArrayList;
import java.util.List;
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
    private List<Gift> receivedGifts;
    private Double averageScore;
    /**
     * Setter for the average sore
     */
    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }
    /**
     * Getter for the average sore
     */
    public Double getAverageScore() {
        return averageScore;
    }
    /**
     * Getter for the budget assigned for the child
     */
    public Double getBudgetAllocated() {
        return budgetAllocated;
    }
    /**
     * Getter for the list of preferences for gifts
     */
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }
    /**
     * Setter for the assigned budget
     */
    public void setBudgetAllocated(final Double budgetAllocated) {
        this.budgetAllocated = budgetAllocated;
    }
    /**
     * Getter for the list of received gifts
     */
    public List<Gift> getReceivedGifts() {
        return receivedGifts;
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
     * Getter for the nice score
     */
    public Double getNiceScore() {
        return niceScore;
    }
    /**
     * Method that increments the age of the child by 1
     */
    public void incrementAge() {
        this.age++;
    }
    /**
     * Method that applies the updates for the child
     */
    public void update(final ChildUpdate childUpdate) {
        // add niceScore to history if it's not null
        if (childUpdate.getNiceScore() != null) {
            this.scores.add(childUpdate.getNiceScore());
            this.niceScore = childUpdate.getNiceScore();
        }
        // add new preferences
        int length = childUpdate.getGiftsPreferences().size() - 1;
        for (int i = length; i >= 0; i--) {
            Category category = childUpdate.getGiftsPreferences().get(i);
            if (!(this.giftsPreferences.contains(category))) {
                this.giftsPreferences.add(0, category);
            } else {
                this.giftsPreferences.remove(category);
                this.giftsPreferences.add(0, category);
            }
        }
    }
    /**
     * Method that assigns a gift to a child
     */
    public void allocateGiftFromSanta(final SantaClaus santaClaus) {
        this.receivedGifts = new ArrayList<>();
        Double theBudget = this.budgetAllocated;
            for (Category category : this.giftsPreferences) {
                Gift gift = santaClaus.searchGiftByPreference(category);
                if (gift != null) {
                    if (!(receivedGifts.contains(gift)) && (theBudget - gift.getPrice()) > 0.0) {
                        receivedGifts.add(gift);
                        theBudget -= gift.getPrice();
                    }
                }
            }
    }
    /**
     * Getter for the list of gifts preferences
     */
    public List<Category> getGifts() {
        return giftsPreferences;
    }
    /**
     * Getter for the list of scores
     */
    public List<Double> getScores() {
        return scores;
    }
}
