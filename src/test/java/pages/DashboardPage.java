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
    private By leftSideBarTC = By.cssSelector("[data-testid='item-testcases']");
    private By leftSideBarTR = By.cssSelector("[data-testid='item-testruns']");

    private By greetingMessageLocator = By.xpath("//h1[@data-testid='text-dashboard-header-content']");

    public DashboardPage(WebDriver driver) {
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

    public Button getLeftSideBarTCButton() {
        return new Button(driver, leftSideBarTC);
    }

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
