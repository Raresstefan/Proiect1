package main;

import checker.Checker;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import common.Constants;
import enums.AgeCategory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }

    public static ChildOutput setChildOutputValues(final ChildInput childInput) {
        ChildOutput childOutput = new ChildOutput();
        childOutput.setAge(childInput.getAge());
        childOutput.setAverageScore(childInput.getAverageScore());
        childOutput.setCity(childInput.getCity());
        childOutput.setAssignedBudget(childInput.getBudgetAllocated());
        childOutput.setFirstName(childInput.getFirstName());
        childOutput.setLastName(childInput.getLastName());
        childOutput.setGiftsPreferences(childInput.getGiftsPreferences());
        childOutput.setId(childInput.getId());
        childOutput.setReceivedGifts(childInput.getReceivedGifts());
        childOutput.setNiceScoreHistory(childInput.getScores());
        return childOutput;
    }

    public static void sortChildrenById(final List<ChildInput> children) {
        int i, j;
        for (i = 0; i < children.size() - 1; i++) {
            for (j = i + 1; j < children.size(); j++) {
                if (children.get(i).getId() > children.get(j).getId()) {
                    Collections.swap(children, i, j);
                }
            }
        }
    }
    public static AgeCategory establishAgeCategory (ChildInput child) {
        if (child.getAge() < 5) {
            return AgeCategory.BABY;
        }
        if (child.getAge() >= 5 && child.getAge() < 12) {
            return AgeCategory.KID;
        }
        if (child.getAge() >= 12 && child.getAge() <= 18) {
            return AgeCategory.TEEN;
        }
        if (child.getAge() > 18) {
            return AgeCategory.YOUNGADULT;
        }
        return null;
    }
    public static void addChildrenOnList(final List<ChildInput> children, final SantaClaus santaClaus) {
        for (ChildInput child : children) {
            if (child.getAge() <= 18) {
                santaClaus.addChildToList(child);
                child.getScores().add(child.getNiceScore());
            }
        }
    }
    public static void writeOutput(final SantaClaus santaClaus, final AnnualChildren annualChildren, final int i) throws IOException {
        ObjectMapper objectMapperOutput = new ObjectMapper();
        String extension = Integer.toString(i);
        String dirName = new String("output");
        File dir = new File(dirName);
        if (!(dir.exists())) {
            dir.mkdir();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.OUTPUT_PATH + extension
                + Constants.FILE_EXTENSION));
        String json = objectMapperOutput.writerWithDefaultPrettyPrinter().writeValueAsString(annualChildren);
        writer.write(json);
        writer.close();
    }
    public static InputData readInput(final int i) throws IOException {
        String extension = Integer.toString(i);
        extension = extension + ".json";
        String testString = new String("test");
        testString = testString + extension;
        String prefix = new String("tests/");
        prefix = prefix + testString;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        File file = new File(prefix);
        InputData inputData = objectMapper.readValue(file, InputData.class);
        return inputData;
    }
    public static void calculateBudget(final List<ChildInput> children, final SantaClaus santaClaus) {
        Double sumAverageScores = 0.0;
        for (ChildInput childInput : children) {
            Double averageScore = ChildFactory.createChild(establishAgeCategory(childInput), childInput.getScores()).getAverageScore();
                childInput.setAverageScore(averageScore);
                if (averageScore != null) {
                    sumAverageScores += averageScore;
                }
        }
        Double budgetUnit = (Double) (santaClaus.getBudget() / sumAverageScores);
        for (ChildInput childInput : children) {
            Double budgetAllocated;
            if (childInput.getAverageScore() == null) {
                budgetAllocated = 0.0;
            }
            else {
                budgetAllocated = childInput.getAverageScore() * budgetUnit;
            }
            childInput.setBudgetAllocated(budgetAllocated);

        }
    }
    public static void addChildrenToOutput(final List<ChildInput> children, final AnnualChildren annualChildren) {
        CompleteOutput completeOutput = new CompleteOutput();
        for (ChildInput childInput : children) {
            ChildOutput childOutput = setChildOutputValues(childInput);
            completeOutput.addChildOutput(childOutput);
        }
//        annualChildren.addChildToList(completeOutput);
        annualChildren.getAnnualChildren().add(completeOutput);
    }
    public static void incrementAges(final List<ChildInput> children) {
        for (ChildInput childInput : children) {
            childInput.incrementAge();
        }
    }
    public static void removeYoungAdults(final List<ChildInput> children) {
        List <ChildInput> childrenToRemove = new ArrayList<>();
        for (ChildInput childInput : children) {
            if (childInput.getAge() > 18) {
                childrenToRemove.add(childInput);
            }
        }
        for (ChildInput childInput : childrenToRemove) {
            children.remove(childInput);
        }
    }
    public static void changesForEachRound(final List<AnnualChanges> annualChanges, final SantaClaus santaClaus, final AnnualChildren annualChildren, final int numberOfYears) {
        int cnt = 1;
        for (AnnualChanges currAnualChange : annualChanges) {
            if (cnt > numberOfYears) {
                break;
            }
            cnt++;
            // creste varsta copiilor
            incrementAges(santaClaus.getChildren());
            // elimina Young Adults din lista
            removeYoungAdults(santaClaus.getChildren());
            // adauga noii copii in lista de copii
            if (currAnualChange.getNewChildren() != null) {
                addChildrenOnList(currAnualChange.getNewChildren(), santaClaus);
            }

            // realizeaza modificarile cerute

            santaClaus.updateChanges(currAnualChange.getChildrenUpdates(), currAnualChange);
//            if (i == 7) {
//                for (CompleteOutput completeOutput : annualChildren.getAnnualChildren()) {
//                    System.out.println(completeOutput.getChildren().get(0).getNiceScoreHistory());
//                }
//            }
            // resorteaza copiii in functie de id
            sortChildrenById(santaClaus.getChildren());
            // recalculeaza averageScoreurile
            calculateBudget(santaClaus.getChildren(), santaClaus);
            // realoca cadourile pentru copii
            santaClaus.allocateGiftsForChildren();

            addChildrenToOutput(santaClaus.getChildren(), annualChildren);

        }
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        Checker.calculateScore();
        // iterate through each inputTest
        int i;
        for (i = 1; i <= 25; i++) {
            // citire
            InputData inputData = readInput(i);
            AnnualChildren annualChildren = new AnnualChildren();
            // setari initiale
            SantaClaus santaClaus = SantaClaus.getInstance();
            santaClaus.initialiseParameters();
            santaClaus.setBudget(inputData.getSantaBudget());
            santaClaus.setGifts(inputData.getInitialData().getGifts());
            addChildrenOnList(inputData.getInitialData().getChildren(), santaClaus);
            sortChildrenById(santaClaus.getChildren());
            calculateBudget(santaClaus.getChildren(), santaClaus);
            santaClaus.allocateGiftsForChildren();
            if (i == 8) {
                System.out.println(santaClaus.getChildren().get(0).getReceivedGifts());
            }
            addChildrenToOutput(santaClaus.getChildren(), annualChildren);
//            if (i == 7) {
//                for (CompleteOutput completeOutput : annualChildren.getAnnualChildren()) {
//                    for (ChildOutput childOutput : completeOutput.getChildren()) {
//                        System.out.println(childOutput.getNiceScoreHistory());
//                    }
//                }
//            }
            changesForEachRound(inputData.getAnnualChanges(), santaClaus, annualChildren, inputData.getNumberOfYears());
//            if (i == 7) {
//                System.out.println("After:");
//                for (CompleteOutput completeOutput : annualChildren.getAnnualChildren()) {
//                    for (ChildOutput childOutput : completeOutput.getChildren()) {
//                        System.out.println(childOutput.getNiceScoreHistory());
//                    }
//                }
//            }
            writeOutput(santaClaus, annualChildren, i);
        }
    }
}
