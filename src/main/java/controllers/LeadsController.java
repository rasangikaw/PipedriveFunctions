package controllers;

import functionbases.BaseFunctionObject;
import functions.DealsFunctions;
import functions.LeadsFunctions;

import org.openqa.selenium.WebDriver;

import java.util.logging.Level;

public class LeadsController extends BaseFunctionObject {

    DealsFunctions dealsFunctions;
    LeadsFunctions leadsFunctions;

    public LeadsController(WebDriver driver) {
        super(driver);
        dealsFunctions = new DealsFunctions(driver);
        leadsFunctions = new LeadsFunctions(driver);
    }

    public LeadsFunctions getLeadsFunctions() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getLeadsFunctions()");
            return leadsFunctions;
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getLeadsFunctions()");
            throw e;
        }
    }
}
