package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.casePages.AllCasePage;
import pages.casePages.CreateCasePage;

public class CreatingTestCase extends BaseTest {

    @Test
    public void creatingTC() { // create very first testcase
        dashboardPage.startTestCaseCreating(); // работает не трогаем
        AllCasePage allCasePage = new AllCasePage(driver);
        allCasePage.startFirstTestCreating(); // opening Create TC modal window
        CreateCasePage createCasePage = new CreateCasePage(driver);
        createCasePage.enterCaseTitle(setupCase.getTitle());
        createCasePage.clickCreateButton();
//
        Assert.assertTrue(allCasePage.isCaseInGrid(setupCase));

    }
}
