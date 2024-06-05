package pages.casePages;

import baseEntities.BasePage;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;
import wrappers.Dropdown;
import wrappers.Input;
import wrappers.UiElement;
import wrappers.modalWindow.TwoOptionsModal;

public class EditCasePage extends BasePage {
    private final By inputCaseTitleLocator = By.className("inputbox-basecomp");
    private final By buttonAttachmentTabLocator = By.xpath("//span[@data-testid='item-attachments']");
    private final By imageAttachmentLocator = By.tagName("img");
//    private final By buttonOpenMoreDropdown = By.xpath("//button[@data-testid='button-more']");
    private final By coreDropdownLocator = By.id("portal-root");
    private final By expandCaseButtonLocator = By.xpath("//button[@title='Expand']");
//    private final By deleteModalWindowLocator = By.xpath("//div[@data-testid='section-modal-messagebox']");
//    private final By confirmButtonModalLocator = By.xpath("//button[@data-testid='button-affirm']");
//    private final By cancelButtonModalLocator = By.xpath("//button[@data-testid='button-cancel']");
    private final By crossButtonLocator = By.xpath("//button[@title='Close']");
    private final By addAttachmentButtonLocator = By.xpath("//button[@data-testid='button-add-attachment']");

    public EditCasePage(WebDriver driver) {
        super(driver);
        expandCase();
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public Button getExpandButton() {
        return new Button(driver, expandCaseButtonLocator);
    }

    public Input getInputCaseTitle() {
        return new Input(driver, inputCaseTitleLocator);
    }

    public Button getButtonAttachmentTab() {
        return new Button(driver, buttonAttachmentTabLocator);
    }
//
//    public Button getButtonOpenMoreDropdown() {
//        return new Button(driver, buttonOpenMoreDropdown);
//    }
//
//    public TwoOptionsModal getDeleteModalWindow() {
//        return new TwoOptionsModal(driver, deleteModalWindowLocator,
//                confirmButtonModalLocator, cancelButtonModalLocator);
//    }

    public Button getCrossButton() {
        return new Button(driver, crossButtonLocator);
    }
    public Button getAddAttachmentButton() {
        return new Button(driver, addAttachmentButtonLocator);
    }
    public UiElement getImageAttachmentElement() {
        return new UiElement(driver, imageAttachmentLocator);
    }

    public void expandCase() {
        getExpandButton().click();
    }

    public void switchToAttachmentTab() { //void ot this.EditCasePage????
        getButtonAttachmentTab().click();
    }

    public void closeEditCasePageByCross() {
        getCrossButton().click();
    }

    public void clickAddAttachmentButton() {
        getAddAttachmentButton().click();
    }

    public boolean isImageAttached() {
        return getImageAttachmentElement().isDisplayed();
    }


//    public Dropdown getMoreDropdown() {
//        getButtonOpenMoreDropdown().click();
//        return new Dropdown(driver, coreDropdownLocator);
//    }
}
