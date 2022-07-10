package controllers;

import functionbases.BaseFunctionObject;
import functions.LoginPageFunctions;

import org.openqa.selenium.WebDriver;

import java.util.logging.Level;

public class LoginController extends BaseFunctionObject {

    LoginPageFunctions loginPageFunctions;

    public LoginController(WebDriver driver) {
        super(driver);
        loginPageFunctions = new LoginPageFunctions(driver);
    }

    public LoginPageFunctions getLoginPageFunctions() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getLoginPageFunctions()");
            return new LoginPageFunctions(driver);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getLoginPageFunctions()");
            throw e;
        }
    }
}
