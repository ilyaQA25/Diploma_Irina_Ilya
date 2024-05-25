package pages;

import baseEntities.BasePage;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrappers.Button;
import wrappers.Input;

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

    public Input getEmailInput() {
        return new Input(driver, emailInputLocator);
    }

    public Input getPasswordInput() {
        return new Input(driver, pswInputLocator);
    }

    public Button getLoginButton() {
        return new Button(driver, logInButtonLocator);
    }

    public WebElement getErrorMessage(){
        return waitsService.waitForVisibility(errorMessageLocator);
    }

    public LoginPage enterEmail(String email) {
        getEmailInput().sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        getPasswordInput().sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public DashboardPage successfulLogIn(User user) {
        this.enterEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .clickLoginButton();
        return new DashboardPage(driver, true);
    }
}
