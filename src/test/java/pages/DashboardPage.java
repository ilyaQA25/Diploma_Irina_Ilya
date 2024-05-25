package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrappers.UiElement;

public class DashboardPage extends BasePage {

    private By creatingTestCase = By.xpath("//h4[contains(text(),'Create test cases')]");
    private By creatingTestRun = By.xpath("//h4[contains(text(),'Create a test run')]");
    private By creatingTestPlan = By.xpath("//h4[contains(text(),'Create a test plan')]");
    private By creatingCustomFields = By.xpath("//h4[contains(text(),'Create custom fields')]");
    private By setUpIntegrations = By.xpath("//h4[contains(text(),'Set up integrations')]");
    private By inviteColleagues = By.xpath("//h4[contains(text(),'Invite colleagues')]");
    private By leftSideBarTC = By.cssSelector("[data-testid='item-testcases']");
    private By leftSideBarTP = By.cssSelector("[data-testid='item-testplans']");
    private By leftSideBarTR = By.cssSelector("[data-testid='item-testruns']");

    public DashboardPage(WebDriver driver, boolean b) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public UiElement getTestCase() {
        return new UiElement(driver, creatingTestCase);
    }

    public WebElement getTestRun() {
        return waitsService.waitForVisibility(creatingTestRun);
    }
    public WebElement getTestPlan() {
        return waitsService.waitForVisibility(creatingTestPlan);
    }

    public WebElement getCustomFields() {
        return waitsService.waitForVisibility(creatingCustomFields);
    }

    public WebElement getSetUpIntegrations() {
        return waitsService.waitForVisibility(setUpIntegrations);
    }

    public WebElement getInviteColleagues() {
        return waitsService.waitForVisibility(inviteColleagues);
    }

    public UiElement getLeftSideBarTC() {
        return new UiElement(driver,leftSideBarTC);
    }

    public UiElement getLeftSideBarTP() {
        return new UiElement(driver, leftSideBarTP);
    }

    public UiElement getLeftSideBarTR() {
        return new UiElement(driver,leftSideBarTR);
    }
}
