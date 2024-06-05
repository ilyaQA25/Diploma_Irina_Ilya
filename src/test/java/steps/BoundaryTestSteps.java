package steps;

import baseEntities.BaseSteps;
import models.TestCase;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.casePages.AllCasePage;
import pages.casePages.CreateCasePage;
import wrappers.UiElement;

public class BoundaryTestSteps extends BaseSteps {
    public BoundaryTestSteps(WebDriver driver) {
        super(driver);
    }

    private CreateCasePage createCasePage = new CreateCasePage(driver);
    private DashboardPage dashboardPage = new DashboardPage(driver);
    private AllCasePage allCasePage = new AllCasePage(driver);

    public void enterCaseTitle(String caseName) { // void or this.CreateCasePage??????
        createCasePage.getCaseTitleInput().sendKeys(caseName);
    }

    public void navigateToCasesPage() {
        dashboardPage.getLeftSideBarTCButton().click();
    }

    public void clickCreateButton() {
        createCasePage.getCreateCaseButton().click();
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isCreateButtonEnabled() {
        return createCasePage.getCreateCaseButton().isEnabled();
    }

    public boolean isCaseInGrid(TestCase testCase) {
        for (UiElement uiElement: allCasePage.getCaseTitleList()) {
            if (uiElement.getText().trim().equals(testCase.getTitle())) {
                return true;
            }
        }
        return false;
    }
}
