package tests.gui;

import baseEntities.BaseTest;
import data.PositiveCaseDataProvider;
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

    @Test (dataProvider = "correctDataForTestCaseName", dataProviderClass = PositiveCaseDataProvider.class)
    public void boundaryCaseTitleTest(String caseName, boolean isCaseCreated) {
        TestCase expectedCase = TestCase.builder().title(caseName).build();
        dashboardPage.navigateToCasesPage();
        AllCasePage allCasePage = new AllCasePage(driver);
        allCasePage.createNewCase();
        CreateCasePage createCasePage = new CreateCasePage(driver);
        createCasePage.enterCaseTitle(caseName);
        createCasePage.clickCreateButton();

        Assert.assertEquals(allCasePage.isCaseInGrid(expectedCase), isCaseCreated);
    }
}
