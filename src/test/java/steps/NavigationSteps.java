package steps;

import baseEntities.BaseSteps;
import models.TestCase;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.casePages.AllCasePage;

public class NavigationSteps extends BaseSteps {

    private DashboardPage dashboardPage;
    private AllCasePage allCasePage;
    public NavigationSteps(WebDriver driver) {
        super(driver);
    }

    public void navigateAllCasesPage() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToCasesPage();
    }

    public void openSelectedCase(TestCase testCase) {
        allCasePage = new AllCasePage(driver);
        allCasePage.openCase(testCase);
    }

}