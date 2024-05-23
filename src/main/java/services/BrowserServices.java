package services;

import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserServices {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType;

    public BrowserServices() {
        switch (ReadProperties.getBrowser()) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new ChromeDriver(getChromeOptions());
                break;
            case "firefox":
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Isn't supported: "+ReadProperties.getBrowser());
                break;
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        return chromeOptions;
    }
    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--ignore-certificate-errors");
        firefoxOptions.addArguments("--silent");
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--incognito");
        return firefoxOptions;
    }

    public WebDriver getDriver() {
        driver.manage().deleteAllCookies();
        return driver;
    }
}
