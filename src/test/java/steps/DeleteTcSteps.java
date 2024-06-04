package steps;

import baseEntities.BaseSteps;
import models.TestCase;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.casePages.AllCasePage;
import pages.casePages.CreateCasePage;

public class DeleteTcSteps extends BaseSteps {

    private AllCasePage allCasePage = new AllCasePage(driver);

    public DeleteTcSteps(WebDriver driver) {
        super(driver);
    }

    public void clickDeleteCaseButton() {
        allCasePage.getDeleteCaseButton().click();
    }

    public void selectCaseCheckbox(TestCase testCase) {
        allCasePage.getCaseCheckbox(testCase).select();
    }

    public void confirmCaseDeletion() {
        allCasePage.getDeleteModalWindow().confirmAction();
        driver.navigate().refresh();
    }

    public boolean isModalWindowDisplayed() {
        return allCasePage.getDeleteModalWindow().isWindowDisplayed();
    }
}