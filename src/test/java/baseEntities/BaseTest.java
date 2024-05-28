package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import services.BrowserServices;
import services.WaitServices;
import utils.InvokedListner;

@Listeners(InvokedListner.class)
public class BaseTest {
    protected WebDriver driver;
    protected WaitServices waitsService;

    protected LoginPage loginPage;

    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        driver = new BrowserServices().getDriver();
        this.setDriverToContext(iTestContext, driver);
        waitsService = new WaitServices(driver);
        driver.get(ReadProperties.getUrl());
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(ReadProperties.getUsername());
        loginPage.enterPassword(ReadProperties.getPassword());
        loginPage.clickLoginButton();
        // loginPage.successfulLogIn();
    }

    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }

    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver){
        iTestContext.setAttribute("WebDriver", driver);
    }

    public static WebDriver getDriverFromContext(ITestContext iTestContext){
        return (WebDriver) iTestContext.getAttribute("WebDriver") ;
    }
}