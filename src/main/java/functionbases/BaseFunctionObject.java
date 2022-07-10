package functionbases;

import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class BaseFunctionObject {

    public Logger logger = Logger.getLogger(BaseFunctionObject.class.getName());

    protected WebDriver driver;

    public BaseFunctionObject(WebDriver driver) {
        this.driver = driver;
    }
}
