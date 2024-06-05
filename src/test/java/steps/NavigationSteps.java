package steps;

import baseEntities.BaseSteps;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;

public class NavigationSteps extends BaseSteps {

    private DashboardPage dashboardPage;
    public NavigationSteps(WebDriver driver) {
        super(driver);
    }

    public void navigateAllCasesPage() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToCasesPage();
    }

}
