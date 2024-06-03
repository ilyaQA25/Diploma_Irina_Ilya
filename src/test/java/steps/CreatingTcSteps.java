package steps;

import baseEntities.BaseSteps;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.casePages.CreateCasePage;

public class CreatingTcSteps extends BaseSteps {
    private DashboardPage dashboardPage;
    private CreateCasePage createCasePage;
    public CreatingTcSteps(WebDriver driver) {
        super(driver);
    }

    public void clickCreateFirstCaseButton() {
        dashboardPage.getCreateTestCaseButton().click();
    }
    }

