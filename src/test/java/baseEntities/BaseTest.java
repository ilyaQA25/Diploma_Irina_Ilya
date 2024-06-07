package baseEntities;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Project;
import models.TestCase;
import models.User;
import org.apache.commons.io.FileUtils;
import org.apache.http.protocol.HTTP;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.DashboardPage;
import pages.LoginPage;
import pages.casePages.AllCasePage;
import services.BrowserServices;
import services.ProjectService;
import services.TestCaseService;
import services.WaitServices;
import tests.api.ApiCaseTest;
import utils.InvokedListner;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

@Listeners(InvokedListner.class)
public class BaseTest {
    protected User setupUser;
    protected Project setupProject;
    protected TestCase setupCase;
    protected ProjectService projectService;
    protected TestCaseService testCaseService;
    protected WebDriver driver;
    protected WaitServices waitsService;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected Faker faker;
    private String jsonProjectDoc;
    private Gson gson;

    @BeforeClass
    public void createData() {
        RestAssured.baseURI = ReadProperties.getBaseApiUrl();
        RestAssured.requestSpecification = given()
                .header("X-Api-Key", ReadProperties.getApiKey())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
        projectService = new ProjectService();
        testCaseService = new TestCaseService();
        faker = new Faker();
        gson = new Gson();

        setupUser =  User.builder().email(ReadProperties.getUsername())
                .password(ReadProperties.getPassword()).build();

        try {
            jsonProjectDoc = FileUtils.readFileToString(new File(ApiCaseTest.class.getClassLoader()
                    .getResource("dataApiTest/setupProject.json").getPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setupProject = gson.fromJson(jsonProjectDoc, Project.class);
        setupProject.setName(faker.pokemon().name());

//        setupProject =  projectService.addSetupProject();
        setupProject =  projectService.addProject(setupProject);

//        setupCase = TestCase.builder().title(faker.rockBand().name()).projectID(setupProject.getId()).build();
        setupCase =  testCaseService.addCase(TestCase.builder().title(faker.rockBand().name()).projectID(setupProject.getId()).build());
        System.out.println("project : "+setupProject.toString());
        System.out.println("case : "+setupCase.toString());
    }

    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        driver = new BrowserServices().getDriver();
        this.setDriverToContext(iTestContext, driver);
        waitsService = new WaitServices(driver);

        driver.get(ReadProperties.getUrl());
        loginPage = new LoginPage(driver);
        loginPage.successfulLogIn(setupUser);
        dashboardPage = new DashboardPage(driver);
        dashboardPage.selectProjectByText(setupProject.getName());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterTest
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