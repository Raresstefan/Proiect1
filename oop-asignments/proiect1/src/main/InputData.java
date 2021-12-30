package main;

import java.util.List;

public class InputData {
    private int numberOfYears;
    private int santaBudget;
    private InitialData initialData;
    private List<AnnualChanges> annualChanges;

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public int getSantaBudget() {
        return santaBudget;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public List<AnnualChanges> getAnnualChanges() {
        return annualChanges;
    }
}
