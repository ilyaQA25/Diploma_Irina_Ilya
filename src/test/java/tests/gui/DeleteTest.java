package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.casePages.AllCasePage;
import pages.casePages.CreateCasePage;

public class DeleteTest extends BaseTest {
// тесты на удаление -- делать отдельно пока
    // решим как исправить позже
    protected AllCasePage allCasePage;

    @Test
    public void deleteCaseModalWindowTest() { // работает, не трогаем
        dashboardPage.startTestCaseCreating();
        allCasePage = new AllCasePage(driver);
        allCasePage.startFirstTestCreating(); // opening Create TC modal window
        CreateCasePage createCasePage = new CreateCasePage(driver);
        createCasePage.enterCaseTitle(setupCase.getTitle());
        createCasePage.clickCreateButton();
        allCasePage.selectCaseCheckbox(setupCase);
        allCasePage.clickDeleteCaseButton();

        Assert.assertTrue(allCasePage.getDeleteModalWindow().isWindowDisplayed());
    }

    @Test // необходимо создать два кейса
    public void deleteCaseTest() { // работает, не трогаем
        dashboardPage.startTestCaseCreating();
        allCasePage = new AllCasePage(driver);
        allCasePage.startFirstTestCreating(); // opening Create TC modal window
        CreateCasePage createCasePage = new CreateCasePage(driver);
        createCasePage.enterCaseTitle(setupCase.getTitle());
        createCasePage.clickCreateButton();
        allCasePage.createNewCase();
        createCasePage.enterCaseTitle("For Deleting");
        createCasePage.clickCreateButton();

        allCasePage.selectCaseCheckbox(setupCase);
        allCasePage.clickDeleteCaseButton();
        allCasePage.confirmCaseDeletion();

        Assert.assertFalse(allCasePage.isCaseInGrid(setupCase));
    }
}
