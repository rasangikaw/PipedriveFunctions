package functions;

import functionbases.BaseFunctionObject;
import org.openqa.selenium.WebDriver;
import pageobjects.LeadsPage;

import java.util.logging.Level;

public class LeadsFunctions extends BaseFunctionObject {

    private LeadsPage leadsPage;

    public LeadsFunctions(WebDriver driver) {
        super(driver);
        leadsPage = new LeadsPage(driver);
    }

    public LeadsPage getLeadsPage() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getLeadsPage()");
            return new LeadsPage(driver);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getLeadsPage()");
            throw e;
        }
    }

    public boolean isLeadDisplayed(String leadName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | isLeadDisplayed()");
            return leadsPage.isLeadDisplayed(leadName);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isLeadDisplayed()");
            throw e;
        }
    }

    public void deleteAllLeads() throws Exception {
        try {
            logger.log(Level.INFO, "Start | deleteAllContacts()");
            if (!leadsPage.isLeadsAreEmpty()) {
                leadsPage.clickOnSelectAllCheckBox();
                leadsPage.clickDeleteIcon();
                leadsPage.clickConfirmationDeleteButton();
                leadsPage.waitForDeleteConfirmationToDissapear();
            }
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | deleteAllContacts()");
            throw e;
        }
    }
}
