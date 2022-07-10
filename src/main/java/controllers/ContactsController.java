package controllers;

import functionbases.BaseFunctionObject;
import functions.ContactsFunctions;

import org.openqa.selenium.WebDriver;

import java.util.logging.Level;

public class ContactsController extends BaseFunctionObject {

    ContactsFunctions contactsFunctions;

    public ContactsController(WebDriver driver) {
        super(driver);
        contactsFunctions = new ContactsFunctions(driver);
    }
    
    public ContactsFunctions getContactsFunctions() throws Exception {
		try {
			logger.log(Level.INFO, "Start | getContactsFunctions()");
			return new ContactsFunctions(driver);
		} catch (Exception e) {
			logger.log(Level.INFO, "Fail | getContactsFunctions()");
			throw e;
		}
	}
}
