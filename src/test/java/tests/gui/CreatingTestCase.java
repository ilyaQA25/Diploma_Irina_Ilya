package tests.gui;

import baseEntities.BaseTest;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.casePages.AllCasePage;
import pages.casePages.CreateCasePage;
import services.TestCaseService;
import steps.CreatingTcSteps;
import steps.NavigationSteps;

public class CreatingTestCase extends BaseTest {

//    private TestCaseService testCaseService;
    private TestCase createdCase;
    private NavigationSteps navigationSteps;
    private CreatingTcSteps creatingTcSteps;


//    @BeforeClass
//    public void addTestCasesToProject() {
//        testCaseService = new TestCaseService();
//        testCaseService.addCase(setupCase);
//    }

    @Test
    public void creatingTC() {
        createdCase = TestCase.builder().title(faker.rockBand().name()).projectID(setupProject.getId()).build();

        navigationSteps = new NavigationSteps(driver);
        navigationSteps.navigateAllCasesPage();
        creatingTcSteps = new CreatingTcSteps(driver);
        creatingTcSteps.startTestCreating();
        creatingTcSteps.enterCaseTitle(createdCase.getTitle());
        creatingTcSteps.clickCreateButton();
        Assert.assertTrue(creatingTcSteps.isCaseInGrid(createdCase.getTitle()));
    }
}
