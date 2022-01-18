package main;

import java.util.ArrayList;
import java.util.List;

public class CompleteOutput {
    private List<ChildOutput> children;

    public CompleteOutput() {
        this.children = new ArrayList<>();
    }
    /**
     * Getter for the list of children from a round
     */
    public List<ChildOutput> getChildren() {
        return children;
    }
    /**
     * Method that adds a child to the list of children we have in a round
     */
    public void addChildOutput(final ChildOutput childOutput) {
        this.children.add(childOutput);
    }
}
