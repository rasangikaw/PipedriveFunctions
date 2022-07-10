package functions;

import functionbases.BaseFunctionObject;
import org.openqa.selenium.WebDriver;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

import java.util.logging.Level;

public class LoginPageFunctions extends BaseFunctionObject {

    private LandingPage landingPage;
    private LoginPage loginPage;

    public LoginPageFunctions(WebDriver driver) {
        super(driver);
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
    }

    public void loginToPipedrive(String email, String password) throws Exception {
        try {
            logger.log(Level.INFO, "Start | loginToPipedrive()");
            landingPage.clickOnLoginLink();
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            loginPage.clickOnLoginButton();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | loginToPipedrive()");
            throw e;
        }
    }
}
