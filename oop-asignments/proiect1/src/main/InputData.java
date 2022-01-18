package main;

import java.util.List;

public class InputData {
    private int numberOfYears;
    private int santaBudget;
    private InitialData initialData;
    private List<AnnualChanges> annualChanges;
    /**
     * Getter for the number of years we run the simulation
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }
    /**
     * Getter for santa's budget
     */
    public int getSantaBudget() {
        return santaBudget;
    }
    /**
     * Getter for the initial data
     */
    public InitialData getInitialData() {
        return initialData;
    }
    /**
     * Getter for the list of annual changes
     */
    public List<AnnualChanges> getAnnualChanges() {
        return annualChanges;
    }
}
