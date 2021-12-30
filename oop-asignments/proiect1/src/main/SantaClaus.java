package main;

import enums.Category;
import enums.Cities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SantaClaus {
    private static SantaClaus instance;
    private List<ChildInput> children;
    private int budget;
    private List<Gift> gifts;
    private SantaClaus() {}
    public void initialiseParameters() {
        this.children = new ArrayList<>();
        this.budget = 0;
        this.gifts = new ArrayList<>();
    }

    public void setGifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public Gift searchGiftByPreference(Category category) {
        for (Gift gift : this.gifts) {
            if (gift.getCategory().equals(category))
                return gift;
        }
        return null;
    }

    public static SantaClaus getInstance() {
        if(instance == null) {
            instance = new SantaClaus();
        }
        return instance;
    }
    public void sortGiftsByPrice() {
        int i, j;
        for (i = 0; i < this.gifts.size() - 1; i++) {
            for (j = i + 1; j < this.gifts.size(); j++) {
                if (this.gifts.get(i).getCategory().equals(this.gifts.get(j).getCategory())) {
                    if (this.gifts.get(i).getPrice() > this.gifts.get(j).getPrice()) {
                        Collections.swap(this.gifts, i, j);
                    }
                }
            }
        }
    }
    public void addChildToList(final ChildInput childInput) {
        this.children.add(childInput);
    }
    public void allocateGiftsForChildren() {
        sortGiftsByPrice();
        for (ChildInput childInput : this.children) {
            childInput.allocateGiftFromSanta(this);
        }
    }
    public List<ChildInput> getChildren() {
        return children;
    }
}
