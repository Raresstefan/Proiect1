package main;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties({ "giftsPreferences"})
public class ChildUpdate {
    private int id;
    private Double niceScore;
    private List<Gift> giftsPreferences;

    public void setId(int id) {
        this.id = id;
    }

    public void setNiceScore(Double niceScore) {
        this.niceScore = niceScore;
    }

    public void setGiftsPreferences(List<Gift> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public int getId() {
        return id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public List<Gift> getGiftsPreferences() {
        return giftsPreferences;
    }
}
