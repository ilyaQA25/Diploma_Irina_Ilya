package tests.gui;

import baseEntities.BaseTest;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.casePages.EditCasePage;
import steps.CreatingTcSteps;
import steps.EditTcSteps;
import steps.NavigationSteps;

public class UploadFileTest extends BaseTest {
    private NavigationSteps navigationSteps;
    private EditTcSteps editTcSteps;

    @Test
    public void uploadImageTest() {
        String fileForUpload = UploadFileTest.class.getClassLoader().getResource("TestTXTaqa.txt").getPath();

        navigationSteps = new NavigationSteps(driver);
        editTcSteps = new EditTcSteps(driver);
        navigationSteps.navigateAllCasesPage();
        navigationSteps.openSelectedCase(setupCase);
        editTcSteps.uploadFileAttachment(fileForUpload);
//
        Assert.assertTrue(editTcSteps.isDocumentAttached());
    }
}
