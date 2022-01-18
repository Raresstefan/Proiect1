package main;

import enums.Category;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SantaClaus {
    private static SantaClaus instance;
    private List<ChildInput> children;
    private int budget;
    private List<Gift> gifts;
    private SantaClaus() { }
    /**
     * Method that initalise the parameters of class
     * with default values
     */
    public void initialiseParameters() {
        this.children = new ArrayList<>();
        this.budget = 0;
        this.gifts = new ArrayList<>();
    }
    /**
     * Setter for the list of gifts
     */
    public void setGifts(final List<Gift> gifts) {
        this.gifts = gifts;
    }
    /**
     * Setter for the budget
     */
    public void setBudget(final int budget) {
        this.budget = budget;
    }
    /**
     * Getter for the budget
     */
    public int getBudget() {
        return budget;
    }
    /**
     * Getter for the list of gifts
     */
    public List<Gift> getGifts() {
        return gifts;
    }
    /**
     * Method that returns the first gift of a specific category,
     * found in the list of gifts
     * If it's not found it returns null
     */
    public Gift searchGiftByPreference(final Category category) {
        for (Gift gift : this.gifts) {
            if (gift.getCategory().equals(category)) {
                return gift;
            }
        }
        return null;
    }
    /**
     * Creates an instance of santa Claus -> Singleton
     */
    public static SantaClaus getInstance() {
        if (instance == null) {
            instance = new SantaClaus();
        }
        return instance;
    }
    /**
     * Method that tells if a child of a specified id
     * exists in the list or not
     * If not, it returns null
     */
    public ChildInput childExistsById(final int id) {
        for (ChildInput childInput : this.children) {
            if (childInput.getId() == id) {
                return childInput;
            }
        }
        return null;
    }
    /**
     * Method that adds new gifts to the list
     */
    public void addNewGifts(final List<Gift> newGifts) {
        for (Gift gift : newGifts) {
            this.gifts.add(gift);
        }
    }
    /**
     * Method that applies the necessary updates
     */
    public void updateChanges(final List<ChildUpdate> updates, final AnnualChanges annualChange) {
        // set the new budget
        setBudget(annualChange.getNewSantaBudget());
        for (ChildUpdate update : updates) {
            // verific daca exista in lista copilul cu id-ul dat
            ChildInput childExists = childExistsById(update.getId());
            if (childExists != null) {
                childExists.update(update);
            }
            // add new gifts
            addNewGifts(annualChange.getNewGifts());
        }
    }
    /**
     * Method that sorts the gifts from the list
     * by their price
     */
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
    /**
     * Method that adds a child to the list
     */
    public void addChildToList(final ChildInput childInput) {
        this.children.add(childInput);
    }
    /**
     * Method that assign gifts for children
     */
    public void allocateGiftsForChildren() {
        sortGiftsByPrice();
        for (ChildInput childInput : this.children) {
            childInput.allocateGiftFromSanta(this);
        }
    }
    /**
     * Getter for the list of children
     */
    public List<ChildInput> getChildren() {
        return children;
    }
}
