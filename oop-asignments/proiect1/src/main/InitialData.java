package main;


import java.util.List;
public class InitialData {
    private List<ChildInput> children;
    private List<Gift> santaGiftsList;
    private List<String> cities;

    public void setChildren(List<ChildInput> children) {
        this.children = children;
    }

    public void setGifts(List<Gift> gifts) {
        this.santaGiftsList = gifts;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<ChildInput> getChildren() {
        return children;
    }

    public List<Gift> getGifts() {
        return santaGiftsList;
    }

    public List<String> getCities() {
        return cities;
    }
}
