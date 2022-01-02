package main;

import java.util.ArrayList;
import java.util.List;

public class CompleteOutput {
    private List<ChildOutput> children;

    public CompleteOutput() {
        this.children = new ArrayList<>();
    }

    public void refreshList() {
        children = new ArrayList<>();
    }

    public List<ChildOutput> getChildren() {
        return children;
    }

    public void addChildOutput(final ChildOutput childOutput) {
        this.children.add(childOutput);
    }
}
