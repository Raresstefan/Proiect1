package main;


import java.util.List;
public class AnnualChanges {
    private int newSantaBudget;
    private List<Gift> newGifts;
    private List<ChildInput> newChildren;
    private List<ChildUpdate> childrenUpdates;
    /**
     * Getter for the new budget of santa
     */
    public int getNewSantaBudget() {
        return newSantaBudget;
    }
    /**
     * Getter for the new gifts that need to be added
     */
    public List<Gift> getNewGifts() {
        return newGifts;
    }
    /**
     * Getter for the new children that need to be added in the list
     */
    public List<ChildInput> getNewChildren() {
        return newChildren;
    }
    /**
     * Getter for the updates that need to be realised for children
     */
    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }
}
