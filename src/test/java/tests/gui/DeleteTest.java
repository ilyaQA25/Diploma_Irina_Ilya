package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.casePages.AllCasePage;
import pages.casePages.CreateCasePage;
import steps.CreatingTcSteps;
import steps.DeleteTcSteps;

public class DeleteTest extends BaseTest {

    protected AllCasePage allCasePage;

    @Test
    public void deleteCaseModalWindowTest() { // работает, не трогаем
/*        dashboardPage.startTestCaseCreating();
        allCasePage = new AllCasePage(driver);
        allCasePage.startFirstTestCreating(); // opening Create TC modal window
        CreateCasePage createCasePage = new CreateCasePage(driver);
        createCasePage.enterCaseTitle(setupCase.getTitle());
        createCasePage.clickCreateButton();
        allCasePage.selectCaseCheckbox(setupCase);
        allCasePage.clickDeleteCaseButton();
        Assert.assertTrue(allCasePage.getDeleteModalWindow().isWindowDisplayed());*/

        DeleteTcSteps deleteTcSteps = new DeleteTcSteps(driver);
        CreatingTcSteps creatingTcSteps = new CreatingTcSteps(driver);
        creatingTcSteps.startTestCaseCreating();
        creatingTcSteps.startFirstTestCreating();
        creatingTcSteps.enterCaseTitle("For Deleting");
        creatingTcSteps.clickCreateButton();

        deleteTcSteps.selectCaseCheckbox("For Deleting");
        deleteTcSteps.clickDeleteCaseButton();

    }

    @Test // необходимо создать два кейса
    public void deleteCaseTest() { // работает, не трогаем
/*        dashboardPage.startTestCaseCreating();
        allCasePage = new AllCasePage(driver);
        allCasePage.startFirstTestCreating(); // opening Create TC modal window
        CreateCasePage createCasePage = new CreateCasePage(driver);
        createCasePage.enterCaseTitle(setupCase.getTitle());
        createCasePage.clickCreateButton();
        allCasePage.createNewCase();
        createCasePage.enterCaseTitle("For Deleting");
        createCasePage.clickCreateButton();*/

        DeleteTcSteps deleteTcSteps = new DeleteTcSteps(driver);
        CreatingTcSteps creatingTcSteps = new CreatingTcSteps(driver);
        creatingTcSteps.startTestCaseCreating();
        creatingTcSteps.startFirstTestCreating();
        creatingTcSteps.enterCaseTitle("For Deleting");
        creatingTcSteps.clickCreateButton();

        creatingTcSteps.startTestCreating();
        creatingTcSteps.enterCaseTitle("For Deleting2");
        creatingTcSteps.clickCreateButton();

        deleteTcSteps.selectCaseCheckbox("For Deleting2");
        deleteTcSteps.clickDeleteCaseButton();

        deleteTcSteps.confirmCaseDeletion();
        Assert.assertFalse(creatingTcSteps.isCaseInGrid("For Deleting2"));


/*        allCasePage.selectCaseCheckbox(setupCase);
        allCasePage.clickDeleteCaseButton();
        allCasePage.confirmCaseDeletion();

        Assert.assertFalse(allCasePage.isCaseInGrid(setupCase));*/
    }
}
