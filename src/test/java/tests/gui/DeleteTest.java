package tests.gui;

import baseEntities.BaseTest;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.casePages.AllCasePage;
import services.TestCaseService;
import steps.CreatingTcSteps;
import steps.DeleteTcSteps;

public class DeleteTest extends BaseTest {
    // тесты на удаление -- делать отдельно пока
    // решим как исправить позже

    private TestCaseService testCaseService;
    private TestCase createdCase;
    private TestCase caseForDeletion;
    private DeleteTcSteps deleteTcSteps;
    private CreatingTcSteps creatingTcSteps;

    @BeforeClass
    public void addTestCasesToProject() {
        testCaseService = new TestCaseService();
        createdCase = TestCase.builder().title(faker.rockBand().name()).projectID(setupProject.getId()).build();
        caseForDeletion = TestCase.builder().title("dummy case for Del").projectID(setupProject.getId()).build();
        testCaseService.addCase(createdCase);
        testCaseService.addCase(caseForDeletion);
    }

    @BeforeMethod
    public void navigateToCaseGrid() {
        dashboardPage.navigateToCasesPage();
        deleteTcSteps = new DeleteTcSteps(driver);
        creatingTcSteps = new CreatingTcSteps(driver);
    }

    @Test
    public void deleteCaseModalWindowTest() {
        deleteTcSteps.selectCaseCheckbox(createdCase);
        deleteTcSteps.clickDeleteCaseButton();

        Assert.assertTrue(deleteTcSteps.isModalWindowDisplayed());
    }

    @Test
    public void deleteCaseTest() {
        deleteTcSteps.selectCaseCheckbox(caseForDeletion);
        deleteTcSteps.clickDeleteCaseButton();
        deleteTcSteps.confirmCaseDeletion();

        Assert.assertFalse(creatingTcSteps.isCaseInGrid(setupCase.getTitle()));
    }
}
