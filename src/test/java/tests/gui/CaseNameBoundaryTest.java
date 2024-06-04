package tests.gui;

import baseEntities.BaseTest;
import data.CaseTitleDataProvider;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.casePages.AllCasePage;
import pages.casePages.CreateCasePage;
import services.TestCaseService;

public class CaseNameBoundaryTest extends BaseTest {
    private TestCaseService testCaseService;
    private TestCase createdCase;

    @BeforeClass
    public void addTestCaseToProject() {
        testCaseService = new TestCaseService();
        createdCase = TestCase.builder().title("dummy case").projectID(setupProject.getId()).build();
        testCaseService.addCase(createdCase);
    }

    @Test (dataProvider = "correctDataForTestCaseName", dataProviderClass = CaseTitleDataProvider.class)
    public void boundaryValidCaseTitleTest(String caseName) {
        TestCase expectedCase = TestCase.builder().title(caseName).build();
        dashboardPage.navigateToCasesPage();
        AllCasePage allCasePage = new AllCasePage(driver);
        allCasePage.createNewCase();
        CreateCasePage createCasePage = new CreateCasePage(driver);
        createCasePage.enterCaseTitle(caseName);
        createCasePage.clickCreateButton();

        Assert.assertTrue(allCasePage.isCaseInGrid(expectedCase));
    }

    @Test (dataProvider = "incorrectDataForTestCaseName", dataProviderClass = CaseTitleDataProvider.class)
    public void boundaryInvalidCaseTitleTest(String caseName) {
        dashboardPage.navigateToCasesPage();
        AllCasePage allCasePage = new AllCasePage(driver);
        allCasePage.createNewCase();
        CreateCasePage createCasePage = new CreateCasePage(driver);
        createCasePage.enterCaseTitle(caseName);

        Assert.assertFalse(createCasePage.isCreateButtonEnabled());
    }
}
