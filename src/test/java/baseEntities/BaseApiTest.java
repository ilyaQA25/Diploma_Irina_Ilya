package baseEntities;

import com.google.gson.Gson;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeClass;
import services.ProjectService;
import services.TestCaseService;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected TestCaseService testCaseService;
    protected ProjectService projectService;
    protected Gson gson;

    @BeforeClass
    public void setupApi() {
        gson = new Gson();
        testCaseService = new TestCaseService();
        projectService = new ProjectService();

        RestAssured.baseURI = ReadProperties.getBaseApiUrl();
        RestAssured.requestSpecification = given()
                .header("X-Api-Key", ReadProperties.getApiKey())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }

}
