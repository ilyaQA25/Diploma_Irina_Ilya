package tests.gui;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import services.BrowserServices;

public class FirstTest {
    @Test
    public void test() {
        BrowserServices browserServices = new BrowserServices();
        WebDriver driver = browserServices.getDriver();
        driver.get(ReadProperties.getBaseUrl());
    }
}
