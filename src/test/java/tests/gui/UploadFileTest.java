package tests.gui;

import baseEntities.BaseTest;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.casePages.EditCasePage;
import steps.CreatingTcSteps;
import steps.NavigationSteps;

public class UploadFileTest extends BaseTest {
    private TestCase createdCase;
    private NavigationSteps navigationSteps;
    private CreatingTcSteps creatingTcSteps;


    @Test
    public void uploadFileTest() {
        createdCase = TestCase.builder().title(faker.rockBand().name()).projectID(setupProject.getId()).build();

        navigationSteps = new NavigationSteps(driver);
        navigationSteps.navigateAllCasesPage();
        navigationSteps.openSelectedCase(setupCase);

        EditCasePage editCasePage = new EditCasePage(driver);
        editCasePage.switchToAttachmentTab();
//        editCasePage.clickAddAttachmentButton();

        String uploading = UploadFileTest.class.getClassLoader()
                .getResource("leopard.jpeg").getPath();
        String uploading111 = UploadFileTest.class.getClassLoader()
                .getResource("leopard.jpeg").getFile();
//        WebElement fileInput = driver.findElement(By.xpath("//*[@type='file']"));
//        fileInput.sendKeys(uploading); //работает

        System.out.println("get path = "+ uploading);
        System.out.println("get file = "+ uploading111);



//        creatingTcSteps = new CreatingTcSteps(driver);
//        creatingTcSteps.startTestCreating();
//        creatingTcSteps.enterCaseTitle(createdCase.getTitle());
//        creatingTcSteps.clickCreateButton();
//        Assert.assertTrue(creatingTcSteps.isCaseInGrid(createdCase.getTitle()));
    }

    @Test
    public void test() {
        driver.get("https://app.testiny.io/p/493/testcases/tc/678/edit");
        EditCasePage editCasePage = new EditCasePage(driver);
        editCasePage.switchToAttachmentTab();

    }
}
