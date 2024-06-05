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

public class CaseNameBoundaryTest extends BaseTest {

    @BeforeMethod
    public void addTestCaseToProject() {
        dashboardPage.navigateToCasesPage();

    }

    @Test (dataProvider = "correctDataForTestCaseName", dataProviderClass = CaseTitleDataProvider.class, priority = 1)
    public void boundaryValidCaseTitleTest(String caseName) {
        TestCase expectedCase = TestCase.builder().title(caseName).build();
        AllCasePage allCasePage = new AllCasePage(driver);
        allCasePage.createNewCase();
        CreateCasePage createCasePage = new CreateCasePage(driver);
        createCasePage.enterCaseTitle(caseName);
        createCasePage.clickCreateButton();

        Assert.assertTrue(allCasePage.isCaseInGrid(expectedCase));
    }

    @Test (dataProvider = "incorrectDataForTestCaseName", dataProviderClass = CaseTitleDataProvider.class)
    public void boundaryInvalidCaseTitleTest(String caseName) {
        AllCasePage allCasePage = new AllCasePage(driver);
        allCasePage.createNewCase();
        CreateCasePage createCasePage = new CreateCasePage(driver);
        createCasePage.enterCaseTitle(caseName);

        Assert.assertFalse(createCasePage.isCreateButtonEnabled());
    }
}
