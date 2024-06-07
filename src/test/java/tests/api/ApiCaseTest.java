package tests.api;

import baseEntities.BaseApiTest;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import models.Project;
import models.TestCase;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.ProjectService;
import services.TestCaseService;

import java.io.File;
import java.io.IOException;


public class ApiCaseTest extends BaseApiTest {
    private Project createdProject;
    private TestCase expectedTestCase;
    private TestCase actualAddedCase;
    private String jsonProjectDoc;
    private String jsonCaseDoc;

    @BeforeClass
    public void dataSetup() {
        gson = new Gson();
        testCaseService = new TestCaseService();
        projectService = new ProjectService();

        try {
             jsonProjectDoc = FileUtils.readFileToString(new File(ApiCaseTest.class.getClassLoader()
                    .getResource("dataApiTest/projectForCaseApiTest.json").getPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        createdProject  = gson.fromJson(jsonProjectDoc, Project.class);
        createdProject = projectService.addProject(createdProject);

        try {
            jsonCaseDoc = FileUtils.readFileToString(new File(ApiCaseTest.class.getClassLoader()
                    .getResource("dataApiTest/dataCase.json").getPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        expectedTestCase = gson.fromJson(jsonCaseDoc, TestCase.class);
    }

    @Test(testName = "Add case", description = "Add case to project")
    public void addCaseTest() {
        expectedTestCase.setProjectID(createdProject.getId());
        actualAddedCase = testCaseService.addCase(expectedTestCase);

        Assert.assertEquals(actualAddedCase, expectedTestCase);
    }

    @Test(testName = "Get case by ID", description = "Get case by valid ID", dependsOnMethods = "addCaseTest")
    public void getCaseByIdTest() {
        TestCase addedCase = actualAddedCase;
        TestCase actualTestCase = testCaseService.getSingleCase(addedCase.getId());

        Assert.assertEquals(actualTestCase, addedCase);
    }

    @Test(testName = "Get case by invalid ID", description = "Get case by invalid ID - alt flow")
    public void getCaseWithInvalidIdTest() {
        int responseStatusCode = testCaseService.getCaseByInvalidId(new Faker().number()
                .numberBetween(2000, 17000));

        Assert.assertEquals(responseStatusCode, HttpStatus.SC_NOT_FOUND);
    }

    @AfterClass
    public void deleteProject() {
        projectService.deleteProject(createdProject.getId());
    }
}
