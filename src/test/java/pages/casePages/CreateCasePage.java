package pages.casePages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;
import wrappers.Input;

public class CreateCasePage extends BasePage {  // move TO AllCasePage ???????

    private By modalCreateCaseLocator = By.xpath("//div[@class = 'modal-content']");
    private By testCaseTitleLocator = By.xpath("//input[@data-testid='textbox-prop-title']");
    private By createCaseButtonLocator = By.xpath("//button[@data-testid='button-save-entity']");
    public CreateCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return modalCreateCaseLocator;
    }

    public Input getCaseTitleInput() {
        return new Input(driver, testCaseTitleLocator);
    }

    public Button getCreateCaseButton() {
        return new Button(driver, createCaseButtonLocator);
    }

    public void enterCaseTitle(String caseName) { // void or this.CreateCasePage??????
        getCaseTitleInput().sendKeys(caseName);
    }

    public void clickCreateButton() {
        getCreateCaseButton().click();
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isCreateButtonEnabled() {
        return getCreateCaseButton().isEnabled();
    }
}
