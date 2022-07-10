package functions;

import functionbases.BaseFunctionObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.ActivitiesPage;

import java.util.logging.Level;

public class ActivitiesFunctions extends BaseFunctionObject {

    private ActivitiesPage activitiesPage;

    public ActivitiesFunctions(WebDriver driver) {
        super(driver);
        activitiesPage = new ActivitiesPage(driver);
    }

    public ActivitiesPage getActivitiesPageMethods() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getActivitiesPageMethods()");
            return activitiesPage;
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getActivitiesPageMethods()");
            throw e;
        }
    }

    public boolean isActivityDisplayedInActivitiesPage(String subjectName, String scheduledMonth, String sheduledDate, String sheduledTime) throws Exception {
        try {
            logger.log(Level.INFO, "Start | isActivityDisplayedInActivitiesPage()");
            String scheduledDate = scheduledMonth + " " + sheduledDate + " " + sheduledTime;
            return activitiesPage.isSheduleActivityTimeDisplayed(subjectName, scheduledDate);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isActivityDisplayedInActivitiesPage()");
            throw e;
        }
    }

    public void deleteAllSubjects() throws Exception {
        try {
            logger.log(Level.INFO, "Start | deleteAllSubjects()");
            if (!activitiesPage.isActivitiesAreEmpty()) {
                selectALLEntriesCheckBox();
                activitiesPage.clickDeleteIcon();
                activitiesPage.clickConfirmationDeleteButton();
                activitiesPage.waitForDeleteConfirmationToDisappear();
            }
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | deleteAllSubjects()");
            throw e;
        }
    }

    private void selectALLEntriesCheckBox() throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectALLEntriesCheckBox()");
            while (!activitiesPage.isDeleteIconDisplayed()) {
                for (By element : activitiesPage.getAllSelectCheckBoxElementList()) {
                    if (activitiesPage.isElementDisplayed(element)) {
                        activitiesPage.clickOnAnyElement(element);
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
