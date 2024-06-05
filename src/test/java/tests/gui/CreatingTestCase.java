package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.casePages.AllCasePage;
import pages.casePages.CreateCasePage;
import steps.CreatingTcSteps;

public class CreatingTestCase extends BaseTest {

    @Test
    public void creatingTC() { // create very first case
        CreatingTcSteps creatingTcSteps = new CreatingTcSteps(driver);
        creatingTcSteps.startTestCaseCreating();
        creatingTcSteps.startFirstTestCreating();
        creatingTcSteps.enterCaseTitle(setupCase.getTitle());
        creatingTcSteps.clickCreateButton();
        Assert.assertTrue(creatingTcSteps.isCaseInGrid(setupCase.getTitle()));
    }
}
