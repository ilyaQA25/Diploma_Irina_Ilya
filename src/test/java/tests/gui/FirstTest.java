package tests.gui;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.casePages.CreateCasePage;
import wrappers.Dropdown;

public class FirstTest extends BaseTest {

    @Test
    public void test() {
        DashboardPage dashboardPage = new DashboardPage(driver, false);
        CreateCasePage createCasePage = new CreateCasePage(driver);
        dashboardPage.selectProjectByText("Project By API");
        Assert.assertTrue(dashboardPage.getProjectDropDownButton().getText().equals("Project By API"));

    }
}
