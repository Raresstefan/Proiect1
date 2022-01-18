package main;


import java.util.List;
public class InitialData {
    private List<ChildInput> children;
    private List<Gift> santaGiftsList;
    private List<String> cities;
    /**
     * Setter for the list of children
     */
    public void setChildren(final List<ChildInput> children) {
        this.children = children;
    }
    /**
     * Setter for the list of gifts
     */
    public void setGifts(final List<Gift> gifts) {
        this.santaGiftsList = gifts;
    }
    /**
     * Setter for the list of cities
     */
    public void setCities(final List<String> cities) {
        this.cities = cities;
    }
    /**
     * Getter for the list of children
     */
    public List<ChildInput> getChildren() {
        return children;
    }
    /**
     * Getter for the list of gifts
     */
    public List<Gift> getGifts() {
        return santaGiftsList;
    }
    /**
     * Getter for the list of cities
     */
    public List<String> getCities() {
        return cities;
    }
}
