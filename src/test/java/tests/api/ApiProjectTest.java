package tests.api;

import baseEntities.BaseApiTest;
import com.github.javafaker.Faker;
import models.Project;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ApiProjectTest extends BaseApiTest {

    private Project expectedProject;
    private Project actualProject;
    private String jsonProjectDoc;

    @BeforeClass
    public void dataSetup() {
        try {
            jsonProjectDoc = FileUtils.readFileToString(new File(ApiCaseTest.class.getClassLoader()
                    .getResource("dataApiTest/projectAPI.json").getPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        expectedProject  = gson.fromJson(jsonProjectDoc, Project.class);

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

    @Test (testName = "Delete project", description = "Delete project existent project")
    public void deleteProject() {
        Project existentProject = actualProject;
        projectService.deleteProject(existentProject.getId());
        int responseStatusCode = projectService.getProjectByInvalidId(existentProject.getId());

        Assert.assertEquals(responseStatusCode, HttpStatus.SC_NOT_FOUND);
    }
}
