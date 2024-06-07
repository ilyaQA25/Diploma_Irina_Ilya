package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.CreatingTcSteps;
import steps.NavigationSteps;

public class HintNegativeTests extends BaseTest {
    private NavigationSteps navigationSteps;
    private CreatingTcSteps creatingTcSteps;

    @BeforeMethod
    public void initSteps() {
        navigationSteps = new NavigationSteps(driver);
        creatingTcSteps = new CreatingTcSteps(driver);
    }

    @Test(groups = "smoke")
    public void incorrectDataInputCaseTest() {
        navigationSteps.navigateAllCasesPage();
        creatingTcSteps.createNewCase();
        creatingTcSteps.enterCaseTitle("     ");

        Assert.assertEquals(creatingTcSteps.getHintTitleErrorText(), "Must have at least 1 characters " +
                "(leading/trailing white spaces not counted).");
    }

    @Test(groups = "smoke")
    public void failedOnPurposeTest() {
        navigationSteps.navigateAllCasesPage();
        creatingTcSteps.createNewCase();
        creatingTcSteps.enterCaseTitle("     ");

        Assert.assertEquals(creatingTcSteps.getHintTitleErrorText(), "Must have at least 1 characters");
    }
}
