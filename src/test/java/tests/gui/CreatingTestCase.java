package tests.gui;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.casePages.AllCasePage;
import pages.casePages.CreateCasePage;

public class CreatingTestCase extends BaseTest {

    @Test
    public void creatingTC() {
        dashboardPage.startTestCaseCreating();
        AllCasePage allCasePage = new AllCasePage(driver);
        allCasePage.startFirstTestCreating(); // opening Create TC modal
        CreateCasePage createCasePage = new CreateCasePage(driver);
        createCasePage.enterCaseTitle(setupProject.getName());
        createCasePage.clickCreateButton();

    }
}
