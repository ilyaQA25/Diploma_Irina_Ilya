package tests.api;

import baseEntities.BaseApiTest;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import models.Project;
import models.TestCase;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class ApiTest extends BaseApiTest {
    private Project expectedProject;
    private Project actualProject;
    private TestCase expectedTestCase;
    private TestCase actualAddedCase;
    private Gson gson;
    private String jsonProjectDoc;
    private String jsonCaseDoc;

    @BeforeClass
    public void dataSetup() {
        gson = new Gson();
        try {
             jsonProjectDoc = FileUtils.readFileToString(new File(ApiTest.class.getClassLoader()
                    .getResource("dataApiTest/data.json").getPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        expectedProject  = gson.fromJson(jsonProjectDoc, Project.class);

        try {
            jsonCaseDoc = FileUtils.readFileToString(new File(ApiTest.class.getClassLoader()
                    .getResource("dataApiTest/dataCase.json").getPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        expectedTestCase = gson.fromJson(jsonCaseDoc, TestCase.class);

    }

    @Test(testName = "Add project", description = "normal flow")
    public void createProjectTest() {
        actualProject = projectService.addProject(expectedProject);

        Assert.assertEquals(actualProject, expectedProject);
    }

    @Test(testName = "Add case to project", description = "normal flow", dependsOnMethods = "createProjectTest")
    public void addCaseTest() {
        expectedTestCase.setProjectID(actualProject.getId());
//        expectedTestCase = gson.fromJson(jsonCaseDoc, TestCase.class);
        actualAddedCase = testCaseService.addCase(expectedTestCase);

        Assert.assertEquals(actualAddedCase, expectedTestCase);
    }


    @Test(testName = "Get case by its ID", description = "normal flow", dependsOnMethods = "addCaseTest")
    public void getCaseByIdTest() {
        TestCase addedCase = actualAddedCase;
        TestCase actualTestCase = testCaseService.getSingleCase(addedCase.getId());

        Assert.assertEquals(actualTestCase, addedCase);
    }

    @Test(testName = "Get case by invalid ID", description = "alternative flow")
    public void getCaseWithInvalidIdTest() {
        int responseStatusCode = testCaseService.getCaseByInvalidId(new Faker().number().numberBetween(2000, 17000));
        Assert.assertEquals(responseStatusCode, HttpStatus.SC_NOT_FOUND);
    }

    @Test(testName = "Get project by invalid ID", description = "alternative flow")
    public void getProjectWithInvalidIdTest() {
        int responseStatusCode = projectService.getProjectByInvalidId(new Faker().number().numberBetween(2000, 17000));
        Assert.assertEquals(responseStatusCode, HttpStatus.SC_NOT_FOUND);
    }

}
