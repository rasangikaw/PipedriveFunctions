package controllers;

import enums.CurrencyEnum;
import functionbases.BaseFunctionObject;
import functions.CalenderFunctions;
import functions.DealsFunctions;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;

public class DealsController extends BaseFunctionObject {

	DealsFunctions dealsFunctions;
	CalenderFunctions calenderFunctions;

	public DealsController(WebDriver driver) {
		super(driver);
		dealsFunctions = new DealsFunctions(driver);
		calenderFunctions = new CalenderFunctions(driver);
	}

	public void addDealFunction(String pearsonName, String organizationName, String value, CurrencyEnum currency,
			String pipelineId, String phone, String email, String month, String year, String date) throws Exception {
		try {
			logger.log(Level.INFO, "Start | addDealFunction()");
			dealsFunctions.getDealsPage().waitForAddDealButton();
			dealsFunctions.getDealsPage().clickOnAddDealButton();
			dealsFunctions.fillDealDetails(pearsonName, organizationName, value, currency, pipelineId, phone, email);
			calenderFunctions.selectDateFromCalender(month, year, date);
			dealsFunctions.getAddDealsPage().clickOnSave();
		} catch (Exception e) {
			logger.log(Level.INFO, "Fail | addDealFunction()");
			throw e;
		}
	}

	public void addASchedule(String activitySubject, String dueMonth, String dueTime, String endTime, String note,
			String month, String year, String date) throws Exception {
		try {
			logger.log(Level.INFO, "Start | addASchedule()");
			dealsFunctions.fillSheduleActivityData(activitySubject, dueTime, endTime, note);
			calenderFunctions.selectDateFromCalender(month, year, date);
			calenderFunctions.selectStartDateFromCalender(dueMonth, year, date);
			dealsFunctions.getScheduleAnActivityPage().clickOnSave();
		} catch (Exception e) {
			logger.log(Level.INFO, "Fail | addASchedule()");
			throw e;
		}
	}

	public boolean verifyDuplicateContactSugestions(String duplicateContactName, String organizationName, String phone, String email) throws Exception {
		try {
			logger.log(Level.INFO, "Start | verifyDuplicateContactSugestions()");
			dealsFunctions.getDealsPage().waitForAddDealButton();
			dealsFunctions.getDealsPage().clickOnAddDealButton();
			boolean isSuggestionsWork = dealsFunctions.isDuplicateContactSuggestionDisplayed(duplicateContactName)
					&& dealsFunctions.isSuggestedDetailsFilledCorrectly(organizationName, phone, email);
			dealsFunctions.getAddDealsPage().clickCancelButton();
			return isSuggestionsWork;
		} catch (Exception e) {
			logger.log(Level.INFO, "Fail | verifyDuplicateContactSugestions()");
			throw e;
		}
	}

	public DealsFunctions getDealsFunctions() throws Exception {
		try {
			logger.log(Level.INFO, "Start | getDealsFunctions()");
			return new DealsFunctions(driver);
		} catch (Exception e) {
			logger.log(Level.INFO, "Fail | getDealsFunctions()");
			throw e;
		}
	}
}
