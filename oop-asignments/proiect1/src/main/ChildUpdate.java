package main;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import enums.Category;

import java.util.List;
//@JsonIgnoreProperties({ "giftsPreferences"})
public class ChildUpdate {
    private int id;
    private Double niceScore;
    private List<Category> giftsPreferences;

//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setNiceScore(Double niceScore) {
//        this.niceScore = niceScore;
//    }
//
//    public void setGiftsPreferences(List<Gift> giftsPreferences) {
//        this.giftsPreferences = giftsPreferences;
//    }

    public int getId() {
        return id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }
}
