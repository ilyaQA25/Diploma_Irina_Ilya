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
import steps.CreatingTcSteps;
import steps.DeleteTcSteps;
import steps.NavigationSteps;

public class CaseNameBoundaryTest extends BaseTest {
    private TestCaseService testCaseService;
    private TestCase createdCase;
    private DeleteTcSteps deleteTcSteps;
    private CreatingTcSteps creatingTcSteps;
    private NavigationSteps navigationSteps;

    @BeforeMethod
    public void intializeDrivers() {
        navigationSteps = new NavigationSteps(driver);
        deleteTcSteps = new DeleteTcSteps(driver);
        creatingTcSteps = new CreatingTcSteps(driver);
    }

    @Test (dataProvider = "correctDataForTestCaseName", dataProviderClass = CaseTitleDataProvider.class)
    public void boundaryValidCaseTitleTest(String caseName) {
        TestCase expectedCase = TestCase.builder().title(caseName).build();
        navigationSteps.navigateAllCasesPage();
        creatingTcSteps.createNewCase();
        creatingTcSteps.enterCaseTitle(caseName);
        creatingTcSteps.clickCreateButton();
        Assert.assertTrue(creatingTcSteps.isCaseInGrid(caseName));
    }

    @Test (dataProvider = "incorrectDataForTestCaseName", dataProviderClass = CaseTitleDataProvider.class)
    public void boundaryInvalidCaseTitleTest(String caseName) {
        navigationSteps.navigateAllCasesPage();
        creatingTcSteps.createNewCase();
        creatingTcSteps.enterCaseTitle(caseName);
        Assert.assertFalse(creatingTcSteps.isCreateButtonEnabled());
    }
}
