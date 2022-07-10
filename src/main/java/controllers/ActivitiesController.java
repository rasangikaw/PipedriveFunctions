package controllers;

import functionbases.BaseFunctionObject;
import functions.ActivitiesFunctions;

import org.openqa.selenium.WebDriver;

import java.util.logging.Level;

public class ActivitiesController extends BaseFunctionObject {

    ActivitiesFunctions activitiesFunctions;

    public ActivitiesController(WebDriver driver) {
        super(driver);
        activitiesFunctions = new ActivitiesFunctions(driver);
    }

    public ActivitiesFunctions getActivitiesFunctions() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getActivitiesFunctions()");
            return new ActivitiesFunctions(driver);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getActivitiesFunctions()");
            throw e;
        }
    }
}
