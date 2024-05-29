package pages.casePages;

import baseEntities.BasePage;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrappers.Button;
import wrappers.UiElement;

import java.util.ArrayList;
import java.util.List;

public class AllCasePage extends BasePage {
    private By createFirstTestLocator = By.xpath("//button[@data-testid='button-add_TC']");
    private By allCasesTitleLocator = By.xpath("//h2[@data-testid='text-title']");
    private By createNewTestLocator = By.xpath("//button[@data-testid='button-add']");
    private By caseTitleLocator = By.xpath("//div[@data-testid='cell-title']");

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

    private List<UiElement> getCaseTitleList() {
        List <WebElement> webElementsList = waitsService.waitForVisibilityAllElements(caseTitleLocator);
        List <UiElement> uiElementList = new ArrayList<>();
        for (WebElement webElement: webElementsList) {
            uiElementList.add(new UiElement(driver, webElement));
        }
        return uiElementList;
    }

    public boolean isCaseInGrid(TestCase testCase) {
        for (UiElement uiElement: getCaseTitleList()) {
            if (uiElement.getText().trim().equals(testCase.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public void openCase(TestCase testCase) {
        for (UiElement uiElement: getCaseTitleList()) {
            if (uiElement.getText().trim().equals(testCase.getTitle())) {
                uiElement.click();
            }
        }
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
