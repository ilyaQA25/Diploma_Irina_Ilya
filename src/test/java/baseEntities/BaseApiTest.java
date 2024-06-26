package baseEntities;

import com.google.gson.Gson;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import services.ProjectService;
import services.TestCaseService;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected TestCaseService testCaseService;
    protected ProjectService projectService;
    protected Gson gson;

    @BeforeTest
    public void setupApi() {
        RestAssured.baseURI = ReadProperties.getBaseApiUrl();
        RestAssured.requestSpecification = given()
                .header("X-Api-Key", ReadProperties.getApiKey())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
        System.out.println("Before test setupApi");
    }

}
