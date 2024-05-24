package services;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitServices {
    private WebDriver driver;
    private Duration timeout;
    private WebDriverWait driverWait;

    public WaitServices(WebDriver driver, Duration duration) {
        this.driver = driver;
        this.timeout = Duration.ofSeconds(ReadProperties.getTimeout());
        this.driverWait = new WebDriverWait(this.driver, this.timeout);
    }

    public WebElement waitForVisibility(By locator) {
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForExistInDom(By locator) {
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
