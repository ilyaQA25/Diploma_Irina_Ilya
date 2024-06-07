package tests.gui;

import baseEntities.BaseTest;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.CreatingTcSteps;
import steps.DeleteTcSteps;
import steps.NavigationSteps;

public class DeleteTest extends BaseTest {
    private TestCase caseForDeletion;
    private DeleteTcSteps deleteTcSteps;
    private CreatingTcSteps creatingTcSteps;
    private NavigationSteps navigationSteps;

    @BeforeClass
    public void addTestCasesToProject() {
        caseForDeletion = TestCase.builder().title("dummy case for Delete test").projectID(setupProject.getId()).build();
        testCaseService.addCase(caseForDeletion);
    }
//
    @BeforeMethod
    public void navigateToCaseGrid() {
        deleteTcSteps = new DeleteTcSteps(driver);
        creatingTcSteps = new CreatingTcSteps(driver);
        navigationSteps = new NavigationSteps(driver);
        navigationSteps.navigateAllCasesPage();
    }

    @Test
    public void deleteCaseModalWindowTest() {
        deleteTcSteps.selectCaseCheckbox(setupCase);
        deleteTcSteps.clickDeleteCaseButton();

        Assert.assertTrue(deleteTcSteps.isModalWindowDisplayed());
    }

    @Test
    public void deleteCaseTest() {
        deleteTcSteps.selectCaseCheckbox(caseForDeletion);
        deleteTcSteps.clickDeleteCaseButton();
        deleteTcSteps.confirmCaseDeletion();

        Assert.assertFalse(creatingTcSteps.isCaseInGrid(caseForDeletion.getTitle()));
    }
}
