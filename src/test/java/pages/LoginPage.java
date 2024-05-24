package pages;

import baseEntities.BasePage;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By emailInputLocator = By.cssSelector("[data-testid='textbox-login']");
    private By pswInputLocator = By.name("password");
    private By logInButtonLocator = By.xpath("//div[text() = 'Log in']");
    private By errorMessageLocator = By.xpath("//span[contains(text(), 'Either')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return emailInputLocator;
    }

    public WebElement getEmailInput() {
        return waitsService.waitForVisibility(emailInputLocator);
    }

    public WebElement getPswInput() {
        return waitsService.waitForVisibility(pswInputLocator);
    }

    public WebElement getLogInButton() {
        return waitsService.waitForVisibility(logInButtonLocator);
    }

    public WebElement getErrorMessage(){
        return waitsService.waitForVisibility(errorMessageLocator);
    }

    public void setEmail(String value) {
        getEmailInput().sendKeys(value);
    }

    public void login(User user) {
        setEmail(user.getEmail());
        getPswInput().sendKeys(user.getPassword());
        getLogInButton().click();
    }
}
