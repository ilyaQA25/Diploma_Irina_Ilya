package pages.casePages;

import baseEntities.BasePage;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrappers.Button;
import wrappers.Checkbox;
import wrappers.UiElement;
import wrappers.modalWindow.TwoOptionsModal;

import java.util.ArrayList;
import java.util.List;

public class AllCasePage extends BasePage {
    private final By createFirstTestLocator = By.xpath("//button[@data-testid='button-add_TC']");
    private final By allCasesTitleLocator = By.xpath("//h2[@data-testid='text-title']");
    private final By createNewTestLocator = By.xpath("//button[@data-testid='button-add']");
    private final By caseTitleLocator = By.xpath("//div[@data-testid='cell-title']");
    private final By allCasesButtonLocator = By.xpath("//a[@title='All test cases']");
    private final By caseCheckBoxesLocator = By.xpath("//div[@data-testid='cell-select']");
    private final By deleteCaseButtonLocator = By.xpath("//button[@data-testid='button-delete']");
    private final By deleteModalWindowLocator = By.xpath("//div[@data-testid='section-modal-messagebox']");
    private final By confirmButtonModalLocator = By.xpath("//button[@data-testid='button-affirm']");
    private final By cancelButtonModalLocator = By.xpath("//button[@data-testid='button-cancel']");


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

    public Button getAllCasesButton() {
        return new Button(driver, allCasesButtonLocator);
    }

    private List<UiElement> getCaseTitleList() {
        List <WebElement> webElementsList = waitsService.waitForVisibilityAllElements(caseTitleLocator);
        List <UiElement> uiElementList = new ArrayList<>();
        for (WebElement webElement: webElementsList) {
            uiElementList.add(new UiElement(driver, webElement));
        }
        return uiElementList;
    }

    private List<Checkbox> getCaseCheckboxesList() {
        List <WebElement> webElementsList = waitsService.waitForVisibilityAllElements(caseCheckBoxesLocator);
        List <Checkbox> checkboxesList = new ArrayList<>();
        for (WebElement webElement: webElementsList) {
            checkboxesList.add(new Checkbox(driver, webElement));
        }
        return checkboxesList;
    }

    public Checkbox getCaseCheckbox(TestCase testCase) {
        List <Checkbox> checkboxesList = getCaseCheckboxesList();
        List <UiElement> uiElementList = getCaseTitleList();
        for (UiElement uiElement: uiElementList) {
            if (uiElement.getText().trim().equals(testCase.getTitle())) {
                return checkboxesList.get(uiElementList.indexOf(uiElement));
            }
        }
        return null;
    }

    public Button getDeleteCaseButton() {
        return new Button(driver, deleteCaseButtonLocator);
    }

    public TwoOptionsModal getDeleteModalWindow() {
        return new TwoOptionsModal(driver, deleteModalWindowLocator,
                confirmButtonModalLocator, cancelButtonModalLocator);
    }

    public void clickDeleteCaseButton() {
        getDeleteCaseButton().click();
    }

    public void selectCaseCheckbox(TestCase testCase) {
        getCaseCheckbox(testCase).select();
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

    public void confirmCaseDeletion() {
        getDeleteModalWindow().confirmAction();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void cancelCaseDeletion() {
        getDeleteModalWindow().cancelAction();
    }


}
