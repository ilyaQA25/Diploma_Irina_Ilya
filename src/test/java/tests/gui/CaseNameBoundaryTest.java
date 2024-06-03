package tests.gui;

import baseEntities.BaseTest;
import data.PositiveCaseDataProvider;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.casePages.AllCasePage;
import pages.casePages.CreateCasePage;

public class CaseNameBoundaryTest extends BaseTest {

    @Test (dataProvider = "correctDataForTestCaseName", dataProviderClass = PositiveCaseDataProvider.class)
    public void boundaryTest(String caseName) {
        TestCase expectedCase = TestCase.builder().title(caseName).build();
        driver.get("https://app.testiny.io/p/2/testcases");
        AllCasePage allCasePage = new AllCasePage(driver);
        allCasePage.createNewCase();
        CreateCasePage createCasePage = new CreateCasePage(driver);
        createCasePage.enterCaseTitle(caseName);
        createCasePage.clickCreateButton();
        Assert.assertTrue(allCasePage.isCaseInGrid(expectedCase));
//        Assert.assertTrue(allCasePage.isPageOpened());
    }
}
