package steps;

import baseEntities.BaseSteps;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.casePages.AllCasePage;
import pages.casePages.EditCasePage;

public class EditTcSteps extends BaseSteps {

    private DashboardPage dashboardPage;
    private AllCasePage allCasePage;
    private EditCasePage editCasePage;

    public EditTcSteps(WebDriver driver) {
        super(driver);
        editCasePage = new EditCasePage(driver);
    }

    public void uploadFileAttachment(String filePath) {
        editCasePage.switchToAttachmentTab();
        editCasePage.chooseFileForAttachment(filePath);
    }

    public void switchToAttachmentTab() {
        editCasePage.switchToAttachmentTab();
    }
//
//    public void chooseFileForUpload(String filePath) {
//        editCasePage.chooseFileForAttachment(filePath);
//    }

    public boolean isDocumentAttached() {
        return editCasePage.getDocAttachmentElement().isDisplayed();
    }


}
