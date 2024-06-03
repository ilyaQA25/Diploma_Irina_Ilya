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

    public void selectCaseCheckbox(String titleOfCase) {
        allCasePage.getCaseCheckbox(titleOfCase).select();
    }

    public void confirmCaseDeletion() {
        allCasePage.getDeleteModalWindow().confirmAction();
        driver.navigate().refresh(); // добавила для стабильной работы
    }
}
