package pages.casePages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;
import wrappers.Input;
import wrappers.UiElement;

public class EditCasePage extends BasePage {
    private final By inputCaseTitleLocator = By.className("inputbox-basecomp");
    private final By buttonAttachmentTabLocator = By.xpath("//span[@data-testid='item-attachments']");
    private final By documentAttachmentLocator = By.xpath("//*[@target='_blank']");
    private final By expandCaseButtonLocator = By.xpath("//button[@title='Expand']");
    private final By crossButtonLocator = By.xpath("//button[@title='Close']");
    private final By addAttachmentElementLocator = By.xpath("//*[@type='file']");

    public EditCasePage(WebDriver driver) {
        super(driver);
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


    public Button getCrossButton() {
        return new Button(driver, crossButtonLocator);
    }

    public UiElement getAddAttachmentElement() {
        return new UiElement(driver, addAttachmentElementLocator);
    }

    public UiElement getDocAttachmentElement() {
        return new UiElement(driver, documentAttachmentLocator);
    }

    public void switchToAttachmentTab() { //void ot this.EditCasePage????
        getButtonAttachmentTab().click();
    }

    public void closeEditCasePageByCross() {
        getCrossButton().click();
    }

    public void chooseFileForAttachment(String filePath) {
        getAddAttachmentElement().sendKeys(filePath);
    }

    public boolean isDocumentAttached() {
        return getDocAttachmentElement().isDisplayed();
    }

}
