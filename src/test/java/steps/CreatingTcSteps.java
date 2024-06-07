package steps;

import baseEntities.BaseSteps;
import models.TestCase;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.casePages.AllCasePage;
import pages.casePages.CreateCasePage;
import wrappers.UiElement;

public class CreatingTcSteps extends BaseSteps {

    private DashboardPage dashboardPage = new DashboardPage(driver);
    private AllCasePage allCasePage = new AllCasePage(driver);

    private CreateCasePage createCasePage = new CreateCasePage(driver);

    public CreatingTcSteps(WebDriver driver) {
        super(driver);
    }

    public void clickCreateTestCaseButton() {
        dashboardPage.getCreateTestCaseButton().click();
    }

    public AllCasePage startTestCaseCreating() {
        clickCreateTestCaseButton();
        return new AllCasePage(driver);
    }

    public void clickCreateFirstCaseButton() {
        allCasePage.getCreateFirstCaseButton().click();
    }

    public void clickCreateNewCaseButton() {
        allCasePage.getCreateNewCaseButton().click();
    }

    public void startFirstTestCreating() { // void????
        clickCreateFirstCaseButton();
    }

    public void createNewCase() {
        clickCreateNewCaseButton();
    }

    public void enterCaseTitle(String caseName) { // void or this.CreateCasePage??????
        createCasePage.getCaseTitleInput().sendKeys(caseName);
    }

    public void clickCreateButton() {
        createCasePage.clickCreateButton();
    }

    public boolean isCaseInGrid(String title) {
        for (UiElement uiElement : allCasePage.getCaseTitleList()) {
            if (uiElement.getText().trim().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCreateButtonEnabled() {
        return createCasePage.getCreateCaseButton().isEnabled();
    }

    public String getHintTitleErrorText() {
        return createCasePage.getHintTitleErrorText().trim();
    }

    public boolean isHintTitleErrorDisplayed() {
        return createCasePage.isHintTitleErrorDisplayed();
    }

}