package tests;

import org.junit.jupiter.api.Test;
import steps.BaseSteps;

public class StepsTests extends BaseSteps {

    private static final String REPOSITORY = "Dmitriy9210/Lesson5_Allure";
    private static final String ISSUE_NUMBER = "#1";

    @Test
    void testSteps() {
        openLink();
        searchRepo(REPOSITORY);
        goInRepo(REPOSITORY);
        goInIssue();
        checkIssue(ISSUE_NUMBER);
    }

}
