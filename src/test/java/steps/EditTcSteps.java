package steps;

import baseEntities.BaseSteps;
import models.TestCase;
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

    public void openCaseAttachmentTab() {
        editCasePage.switchToAttachmentTab();
    }


}
