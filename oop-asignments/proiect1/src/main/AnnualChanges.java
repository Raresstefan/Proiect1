package main;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
//@JsonIgnoreProperties({ "newChildren"})
public class AnnualChanges {
    private int newSantaBudget;
    private List<Gift> newGifts;
    private List<ChildInput> newChildren;
    private List<ChildUpdate> childrenUpdates;

    public int getNewSantaBudget() {
        return newSantaBudget;
    }

    public List<Gift> getNewGifts() {
        return newGifts;
    }

    public List<ChildInput> getNewChildren() {
        return newChildren;
    }

    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }
}
