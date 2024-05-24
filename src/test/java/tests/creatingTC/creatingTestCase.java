package tests.creatingTC;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import services.BrowserServices;

public class creatingTestCase extends BaseTest {

    @Test
    public void creatingTC(){
        BrowserServices browserServices = new BrowserServices();
        WebDriver driver = browserServices.getDriver();
        driver.get(ReadProperties.getBaseUrl());
        User user = new User();
        user.setEmail(ReadProperties.getUsername());
        user.setPassword(ReadProperties.getPassword());
    }
}
