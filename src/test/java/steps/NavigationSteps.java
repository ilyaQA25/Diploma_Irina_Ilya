package steps;

import baseEntities.BaseSteps;
import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;


public class NavigationSteps extends BaseSteps {
    private LoginPage loginPage;
    public NavigationSteps(WebDriver driver) {
        super(driver);
    }
    @Step("correct Login")
    public LoginPage successLogin(User user) {
        LoginPage loginPage = new LoginPage(driver, false);
        return loginPage.successfulLogIn(user);
    }

    @Step("incorrect Login")
    public LoginPage incorrectLogin(User user) {
        loginPage = new LoginPage(driver,false);
        return loginPage.incorrectLogin(user);
    }
}