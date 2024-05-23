package tests.api;

import baseEntities.BaseApiTest;
import com.github.javafaker.Faker;
import models.Project;
import models.TestCase;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ApiTest extends BaseApiTest {
    private Project expectedProject;
    private Project actualProject;
    private TestCase expectedTestCase;
    private TestCase actualAddedCase;

    @BeforeClass
    public void dataSetup() {
        expectedProject = Project.builder().name("Project By API").build();
    }

    @Test(testName = "Add project", description = "normal flow")
    public void createProjectTest() {
        actualProject = projectService.addProject(expectedProject);

        Assert.assertEquals(actualProject, expectedProject);
    }

    @Test(testName = "Add case to project", description = "normal flow", dependsOnMethods = "createProjectTest")
    public void addCaseTest() {
//        Project createdProject = actualProject;
        expectedTestCase = TestCase.builder().title("Added via api call").projectID(actualProject.getId()).build();
        actualAddedCase = testCaseService.addCase(expectedTestCase);
//        System.out.println("by api call "+ actualAddedCase.getId());
//        System.out.println("init "+ expectedCase.getId());

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
