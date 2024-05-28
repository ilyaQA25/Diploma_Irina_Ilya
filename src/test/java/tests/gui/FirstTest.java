package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.casePages.AllCasePage;
import pages.casePages.CreateCasePage;
import services.BrowserServices;

public class FirstTest extends BaseTest {

    @Test
    public void test() {
        DashboardPage dashboardPage = new DashboardPage(driver, false);
        CreateCasePage createCasePage = new CreateCasePage(driver);
        dashboardPage.startTestCaseCreating()
                .createNewCase();
        createCasePage.enterCaseTitle("AQA 565656 new");
        createCasePage.clickCreateButton();

    }
}
