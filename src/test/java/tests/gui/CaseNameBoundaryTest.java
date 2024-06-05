package tests.gui;

import baseEntities.BaseTest;
import data.CaseTitleDataProvider;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.casePages.AllCasePage;
import pages.casePages.CreateCasePage;
import services.TestCaseService;
import steps.BoundaryTestSteps;
import steps.CreatingTcSteps;
import steps.DeleteTcSteps;

public class CaseNameBoundaryTest extends BaseTest {
    private TestCaseService testCaseService;
    private TestCase createdCase;

    private DeleteTcSteps deleteTcSteps;
    private CreatingTcSteps creatingTcSteps;
    private BoundaryTestSteps boundaryTestSteps;


    @BeforeClass
    public void addTestCaseToProject() {
        testCaseService = new TestCaseService();
        createdCase = TestCase.builder().title("dummy case").projectID(setupProject.getId()).build();
        testCaseService.addCase(createdCase);
    }

    @BeforeMethod
    public void intializeDrivers(){
        deleteTcSteps = new DeleteTcSteps(driver);
        creatingTcSteps = new CreatingTcSteps(driver);
        boundaryTestSteps = new BoundaryTestSteps(driver);
    }

    @Test (dataProvider = "correctDataForTestCaseName", dataProviderClass = CaseTitleDataProvider.class)
    public void boundaryValidCaseTitleTest(String caseName) {
        TestCase expectedCase = TestCase.builder().title(caseName).build();
        boundaryTestSteps.navigateToCasesPage();
        creatingTcSteps.createNewCase();
        boundaryTestSteps.enterCaseTitle(caseName);
        boundaryTestSteps.clickCreateButton();
        Assert.assertTrue(boundaryTestSteps.isCaseInGrid(expectedCase));
    }

    @Test (dataProvider = "incorrectDataForTestCaseName", dataProviderClass = CaseTitleDataProvider.class)
    public void boundaryInvalidCaseTitleTest(String caseName) {
        boundaryTestSteps.navigateToCasesPage();
        creatingTcSteps.createNewCase();
        boundaryTestSteps.enterCaseTitle(caseName);
        Assert.assertFalse(boundaryTestSteps.isCreateButtonEnabled());
    }
}
