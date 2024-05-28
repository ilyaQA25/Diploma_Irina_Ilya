package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.WaitServices;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitServices waitsService;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitsService = new WaitServices(driver, Duration.ofSeconds(ReadProperties.getTimeout()));
    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        return waitsService.waitForVisibility(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUrl() + pagePath);
    }
}

