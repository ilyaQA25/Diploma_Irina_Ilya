package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowserServices;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowserServices().getDriver();
        driver.get(ReadProperties.getBaseUrl());
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}