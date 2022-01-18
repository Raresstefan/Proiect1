package main;

import enums.Category;
import java.util.List;
public class ChildUpdate {
    private int id;
    private Double niceScore;
    private List<Category> giftsPreferences;
    /**
     * Getter for the id
     */
    public int getId() {
        return id;
    }
    /**
     * Getter for the nice score
     */
    public Double getNiceScore() {
        return niceScore;
    }
    /**
     * Getter for the list of gift preferences
     */
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }
}
