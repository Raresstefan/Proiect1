package main;

import java.util.ArrayList;
import java.util.List;

public class AnnualChildren {
    private List<CompleteOutput> annualChildren;

    public AnnualChildren() {
        this.annualChildren = new ArrayList<>();
    }
    public void addChildToList(CompleteOutput completeOutput) {
        this.annualChildren.add(completeOutput);
    }
    public List<CompleteOutput> getAnnualChildren() {
        return annualChildren;
    }
}
