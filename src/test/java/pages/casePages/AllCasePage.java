package pages.casePages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;

public class AllCasePage extends BasePage {
    private By createFirstTestLocator = By.xpath("//button[@data-testid='button-add_TC']");
    private By allCasesTitleLocator = By.xpath("//h2[@data-testid='text-title']");

    private By createNewTestLocator = By.xpath("//button[@data-testid='button-add']");
    public AllCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return allCasesTitleLocator;
    }

    public Button getCreateFirstCaseButton() {
        return new Button(driver, createFirstTestLocator);
    }

    public Button getCreateNewCaseButton() {
        return new Button(driver, createNewTestLocator);
    }

    public void clickCreateFirstCaseButton() {
        getCreateFirstCaseButton().click();
    }

    public void clickCreateNewTestButton() {
        getCreateNewCaseButton().click();
    }

    public void startFirstTestCreating() { // void????
        clickCreateFirstCaseButton();
    }

    public void createNewCase() { // void????
        clickCreateNewTestButton();
    }
}
