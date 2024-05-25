package tests.creatingTC;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import services.BrowserServices;

public class CreatingTestCase extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);
    @Test
    public void creatingTC(){
        BrowserServices browserServices = new BrowserServices();
        WebDriver driver = browserServices.getDriver();
        driver.get(ReadProperties.getBaseUrl());
        loginPage.getEmailInput().sendKeys(ReadProperties.getUsername());
/*        User user = new User();
        user.setEmail(ReadProperties.getUsername());
        user.setPassword(ReadProperties.getPassword());*/
    }
}
