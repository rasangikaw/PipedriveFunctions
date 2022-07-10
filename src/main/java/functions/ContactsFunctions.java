package functions;

import functionbases.BaseFunctionObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.ActivitiesPage;
import pageobjects.ContactsPage;

import java.util.logging.Level;

public class ContactsFunctions extends BaseFunctionObject {

    private ContactsPage contactsPage;
    private ActivitiesPage activitiesPage;

    public ContactsFunctions(WebDriver driver) {
        super(driver);
        activitiesPage = new ActivitiesPage(driver);
        contactsPage = new ContactsPage(driver);
    }

    public ContactsPage getContactsPageMethods() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getContactsPageMethods()");
            return contactsPage;
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getContactsPageMethods()");
            throw e;
        }
    }

    public boolean isSubjectDisplayedInActivitiesPage(String subjectName , String scheduledMonth , String sheduledDate , String sheduledTime) throws Exception {
        try {
            logger.log(Level.INFO, "Start | isSubjectDisplayedInActivitiesPage()");
            String scheduledDate = scheduledMonth +" " + sheduledDate + " " + sheduledTime;
            return activitiesPage.isSheduleActivityTimeDisplayed(subjectName , scheduledDate);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isSubjectDisplayedInActivitiesPage()");
            throw e;
        }
    }
    
    public void deleteAllContacts() throws Exception {
        try {
            logger.log(Level.INFO, "Start | deleteAllContacts()");
            contactsPage.clickOnPeopleButton();
            if(!contactsPage.isContactsAreEmpty()) {
            selectALLEntriesCheckBox();
            contactsPage.clickDeleteIcon();
            contactsPage.clickConfirmationDeleteButton();
            contactsPage.waitForDeleteConfirmationToDissapear();
            }
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | deleteAllContacts()");
            throw e;
        }
    }
    
    public void deleteAllOrganizations() throws Exception {
        try {
            logger.log(Level.INFO, "Start | deleteAllOrganizations()");
            contactsPage.clickOnOrganizationsButton();
            if(!contactsPage.isOrganizationsAreEmpty()) {
            	selectALLEntriesCheckBox();
            	contactsPage.clickDeleteIcon();
            	contactsPage.clickConfirmationDeleteButton();
            	contactsPage.waitForDeleteConfirmationToDissapear();
            }
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | deleteAllOrganizations()");
            throw e;
        }
    }
        
    private void selectALLEntriesCheckBox() throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectALLEntriesCheckBox()");
            	while(!contactsPage.isDeleteIconDisplayed()) {
            		for(By element : contactsPage.getAllSelectCheckBoxElementList()) {
            			if(contactsPage.isElementDisplayedAfterWaiting(element , 3000)) {
            				contactsPage.clickOnAnyElement(element);
                			break;
            			}
            		}
            	}
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectALLEntriesCheckBox()");
            throw e;
        }
    }
}
