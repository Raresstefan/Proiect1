package main;

import java.util.ArrayList;
import java.util.List;

public class CompleteOutput {
    private List<ChildOutput> childrenOutput;

    public CompleteOutput() {
        childrenOutput = new ArrayList<>();
    }

    public List<ChildOutput> getChildrenOutput() {
        return childrenOutput;
    }
    public void addChildOutput(final ChildOutput childOutput) {
        this.childrenOutput.add(childOutput);
    }
}
