package tests.api;

import baseEntities.BaseApiTest;
import com.github.javafaker.Faker;
import models.Project;
import models.TestCase;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class ApiCrudTest extends BaseApiTest {
    private Project createdProject;
    private TestCase expectedTestCase;
    private TestCase actualAddedCase;
    private String jsonProjectDoc;
    private String jsonCaseDoc;
    private Project expectedProject;
    private Project actualProject;
    private String jsonProjectUnderTestDoc;

    @BeforeClass
    public void dataSetup() {

        try {
             jsonProjectDoc = FileUtils.readFileToString(new File(ApiCrudTest.class.getClassLoader()
                    .getResource("dataApiTest/projectForCaseApiTest.json").getPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        createdProject  = gson.fromJson(jsonProjectDoc, Project.class);
        createdProject = projectService.addProject(createdProject);

        try {
            jsonCaseDoc = FileUtils.readFileToString(new File(ApiCrudTest.class.getClassLoader()
                    .getResource("dataApiTest/dataCase.json").getPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        expectedTestCase = gson.fromJson(jsonCaseDoc, TestCase.class);


        try {
            jsonProjectUnderTestDoc = FileUtils.readFileToString(new File(ApiCrudTest.class.getClassLoader()
                    .getResource("dataApiTest/projectAPI.json").getPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        expectedProject  = gson.fromJson(jsonProjectUnderTestDoc, Project.class);

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

    @Test(testName = "Add project", description = "Add project")
    public void createProjectTest() {
        actualProject = projectService.addProject(expectedProject);

        Assert.assertEquals(actualProject, expectedProject);
    }

    @Test(testName = "Get project by invalid ID", description = "Get project by invalid ID - alt flow")
    public void getProjectWithInvalidIdTest() {
        int responseStatusCode = projectService.getProjectByInvalidId(new Faker().number()
                .numberBetween(2000, 17000));

        Assert.assertEquals(responseStatusCode, HttpStatus.SC_NOT_FOUND);
    }

    @Test (testName = "Delete project", description = "Delete project existent project", dependsOnMethods = "createProjectTest")
    public void deleteProjectUnderTest() {
        Project existentProject = actualProject;
        projectService.deleteProject(existentProject.getId());
        int responseStatusCode = projectService.getProjectByInvalidId(existentProject.getId());

        Assert.assertEquals(responseStatusCode, HttpStatus.SC_NOT_FOUND);
    }

    @AfterClass
    public void deleteProject() {
        projectService.deleteProject(createdProject.getId());
    }
}
