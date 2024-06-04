package tests.gui;

import baseEntities.BaseTest;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.casePages.AllCasePage;
import services.TestCaseService;

public class DeleteTest extends BaseTest {

    protected AllCasePage allCasePage;
    private TestCaseService testCaseService;
    private TestCase createdCase;
    private TestCase caseForDeletion;

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
        allCasePage = new AllCasePage(driver);
    }

    @Test
    public void deleteCaseModalWindowTest() {
        allCasePage.selectCaseCheckbox(createdCase);
        allCasePage.clickDeleteCaseButton();

        Assert.assertTrue(allCasePage.getDeleteModalWindow().isWindowDisplayed());
    }

    @Test
    public void deleteCaseTest() {
        allCasePage.selectCaseCheckbox(caseForDeletion);
        allCasePage.clickDeleteCaseButton();
        allCasePage.confirmCaseDeletion();

        Assert.assertFalse(allCasePage.isCaseInGrid(setupCase));
    }
}
