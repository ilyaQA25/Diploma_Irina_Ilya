package tests.gui;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.casePages.AllCasePage;
import pages.casePages.CreateCasePage;
import wrappers.table.Table;
import wrappers.table.TableCell;

public class CreatingTestCase extends BaseTest {

    @Test
    public void creatingTC() {
        dashboardPage.startTestCaseCreating();
        AllCasePage allCasePage = new AllCasePage(driver);
        allCasePage.startFirstTestCreating(); // very first Create TC modal
//        allCasePage.createNewCase(); // second and further case
        CreateCasePage createCasePage = new CreateCasePage(driver);
        createCasePage.enterCaseTitle(setupCase.getTitle());
        createCasePage.clickCreateButton();
    }


    @Test
    public void openCaseTest() {
        dashboardPage.getLeftSideBarTCButton().click();
        Table table = new Table(driver, By.tagName("table"));
//        table.getRow(3).getCell(4).getCellAsUiElement().click(); // ok
//        System.out.println(table.getRow(3).getCell(4).getCellAsUiElement().getText());
//        TableCell cell = table.getCell("TITLE", 2); // ok
        TableCell cell = table.getCell("TITLE", "AQA 111", 4); // NOT ok
        System.out.println(cell.getCellAsUiElement().getText());
//        cell.getCellAsUiElement().click();
    }
}
