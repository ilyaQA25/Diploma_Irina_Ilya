package baseEntities;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Project;
import models.User;
import org.apache.http.protocol.HTTP;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.LoginPage;
import services.BrowserServices;
import services.ProjectService;
import services.WaitServices;
import utils.InvokedListner;

import static io.restassured.RestAssured.given;

@Listeners(InvokedListner.class)
public class BaseTest {
    protected Project setupProject;
    protected User setupUser;
    protected ProjectService projectService;

    protected WebDriver driver;
    protected WaitServices waitsService;
    protected LoginPage loginPage;

    @BeforeSuite // beforeSuite???
    public void createData() {
        setupUser =  User.builder().email(ReadProperties.getUsername())
                .password(ReadProperties.getPassword()).build();
        projectService = new ProjectService();
        RestAssured.baseURI = ReadProperties.getBaseApiUrl();
        RestAssured.requestSpecification = given()
                .header("X-Api-Key", ReadProperties.getApiKey())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
        setupProject =  projectService.addSetupProject();
    }

    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        driver = new BrowserServices().getDriver();
        this.setDriverToContext(iTestContext, driver);
        waitsService = new WaitServices(driver);
        driver.get(ReadProperties.getUrl());
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(setupUser.getEmail());
        loginPage.enterPassword(setupUser.getPassword());
        loginPage.clickLoginButton();
        // loginPage.successfulLogIn();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void purge() {
        projectService.deleteProject(setupProject.getId());
    }

    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver){
        iTestContext.setAttribute("WebDriver", driver);
    }

    public static WebDriver getDriverFromContext(ITestContext iTestContext){
        return (WebDriver) iTestContext.getAttribute("WebDriver") ;
    }
}