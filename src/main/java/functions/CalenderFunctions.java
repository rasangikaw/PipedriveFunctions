package functions;

import functionbases.BaseFunctionObject;
import org.openqa.selenium.WebDriver;
import utils.CalendarUtil;

import java.util.logging.Level;

public class CalenderFunctions extends BaseFunctionObject {

    private CalendarUtil calendarUtil;

    public CalenderFunctions(WebDriver driver) {
        super(driver);
        calendarUtil = new CalendarUtil(driver);
    }

    public void selectDateFromCalender(String month, String year, String date) throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectDateFromCalender()");
            calendarUtil.selectMonth(month);
            Thread.sleep(2000);
            if (!calendarUtil.isCalenderPopupDisplayed())
                calendarUtil.clickOnDateField();
            calendarUtil.selectYear(year);
            Thread.sleep(2000);
            if (!calendarUtil.isCalenderPopupDisplayed())
                calendarUtil.clickOnDateField();
            calendarUtil.clickOnDate(date);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectDateFromCalender()");
            throw e;
        }
    }

    public void selectStartDateFromCalender(String month, String year, String date) throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectStartDateFromCalender()");
            calendarUtil.clickOnStartDateField();
            calendarUtil.selectMonth(month);
            Thread.sleep(2000);
            if (!calendarUtil.isCalenderPopupDisplayed())
                calendarUtil.clickOnStartDateField();
            calendarUtil.selectYear(year);
            Thread.sleep(2000);
            if (!calendarUtil.isCalenderPopupDisplayed())
                calendarUtil.clickOnStartDateField();
            calendarUtil.clickOnDate(date);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectStartDateFromCalender()");
            throw e;
        }
    }
}
