package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.casePages.AllCasePage;
import wrappers.Button;
import wrappers.Dropdown;

public class DashboardPage extends BasePage {
    private By openDropdownButtonLocator = By.xpath("//button[@data-testid='button-projects']");
    private By coreDropdownLocator = By.id("portal-root");
    private By creatingTestCase = By.xpath("//h4[contains(text(),'Create test cases')]");
    private By creatingTestRun = By.xpath("//h4[contains(text(),'Create a test run')]");
//    private By creatingTestPlan = By.xpath("//h4[contains(text(),'Create a test plan')]");
//    private By creatingCustomFields = By.xpath("//h4[contains(text(),'Create custom fields')]");
//    private By setUpIntegrations = By.xpath("//h4[contains(text(),'Set up integrations')]");
//    private By inviteColleagues = By.xpath("//h4[contains(text(),'Invite colleagues')]");
    private By leftSideBarTC = By.cssSelector("[data-testid='item-testcases']");
//    private By leftSideBarTP = By.cssSelector("[data-testid='item-testplans']");
    private By leftSideBarTR = By.cssSelector("[data-testid='item-testruns']");

    private By greetingMessageLocator = By.xpath("//h1[@data-testid='text-dashboard-header-content']");

    public DashboardPage(WebDriver driver, boolean b) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return greetingMessageLocator;
    }

    public Button getCreateTestCaseButton() {
        return new Button(driver, creatingTestCase);
    }

    public Button getCreateTestRunButton() {
        return new Button(driver, creatingTestRun);
    }
//    public Button getCreateTestPlanButton() {
//        return new Button(driver, creatingTestPlan);
//    }

//    public Button getCreateCustomFieldsButton() {
//        return new Button(driver, creatingCustomFields);
//    }

//    public Button getSetUpIntegrationsButton() {
//        return new Button(driver, setUpIntegrations);
//    }
//
//    public Button getInviteColleaguesButton() {
//        return new Button(driver, inviteColleagues);
//    }

    public Button getLeftSideBarTCButton() {
        return new Button(driver, leftSideBarTC);
    }

//    public Button getLeftSideBarTPButton() {
//        return new Button(driver, leftSideBarTP);
//    }

    public Button getLeftSideBarTRButton() {
        return new Button(driver, leftSideBarTR);
    }

    public void navigateToCasesPage() {
        getLeftSideBarTCButton().click();
    }

    public void clickCreateTestCaseButton() {
        getCreateTestCaseButton().click();
    }

    public AllCasePage startTestCaseCreating() {
        clickCreateTestCaseButton();
        return new AllCasePage(driver);
    }

    public Button getProjectDropDownButton() {
        return new Button(driver, openDropdownButtonLocator);
    }

    private boolean isProjectSelected(String projectName) {
        return getProjectDropDownButton().getText().equals(projectName);
    }

    public Dropdown getProjectDropdown() {
        getProjectDropDownButton().click();
        return new Dropdown(driver, coreDropdownLocator);
    }

    public void selectProjectByText(String text) {
        if (!isProjectSelected(text)) {
            getProjectDropdown().setByText(text);
        }
    }

}
