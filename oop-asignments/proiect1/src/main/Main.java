package main;

import checker.Checker;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import enums.AgeCategory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
        childOutput.setGiftsPreference(childInput.getGiftsPreferences());
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
        if (child.getAge() >= 12 && child.getAge() < 18) {
            return AgeCategory.TEEN;
        }
        if (child.getAge() >= 18) {
            return AgeCategory.YOUNGADULT;
        }
        return null;
    }
    public static void addChildrenOnList(final List<ChildInput> children, final SantaClaus santaClaus) {
        for (ChildInput child : children) {
            santaClaus.addChildToList(child);
            child.getScores().add(child.getNiceScore());
        }
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
            String extension = Integer.toString(i);
            extension = extension + ".json";
            String testString = new String("test");
            testString = testString + extension;
            String prefix = new String("tests/");
            prefix = prefix + testString;
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            objectMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            File file = new File(prefix);
//            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            InputData inputData = objectMapper.readValue(file, InputData.class);
            SantaClaus santaClaus = SantaClaus.getInstance();
            santaClaus.initialiseParameters();
            santaClaus.setBudget(inputData.getSantaBudget());
            santaClaus.setGifts(inputData.getInitialData().getGifts());
            addChildrenOnList(inputData.getInitialData().getChildren(), santaClaus);
            sortChildrenById(santaClaus.getChildren());
            calculateBudget(santaClaus.getChildren(), santaClaus);
//            for (Gift gift : santaClaus.getGifts()) {
//                System.out.println(gift);
//            }
//            for (ChildInput childInput : santaClaus.getChildren()) {
//                System.out.println(childInput.getGifts());
//            }
            santaClaus.allocateGiftsForChildren();
//            allocateGiftsForChildren
            // calculez averageScore
//            for (ChildInput childInput : santaClaus.getChildren()) {
//
//            }
            for (ChildInput childInput : santaClaus.getChildren()) {
                ObjectMapper objectMapperOutput = new ObjectMapper();
                ChildOutput childOutput = setChildOutputValues(childInput);
                extension = Integer.toString(i);
                extension = extension + ".json";
                testString = new String("test");
                testString = testString + extension;
                prefix = new String("out/");
                prefix = prefix + testString;
                objectMapper.writeValue(
                        new FileOutputStream(prefix), childOutput);
            }
        }
    }
}
