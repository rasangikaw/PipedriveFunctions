package controllers;

import enums.CurrencyEnum;
import functionbases.BaseFunctionObject;
import functions.CalenderFunctions;
import functions.ProductFunctions;

import org.openqa.selenium.WebDriver;

import java.util.logging.Level;

public class ProductsController extends BaseFunctionObject {

    ProductFunctions productFunctions;
    CalenderFunctions calenderFunctions;

    public ProductsController(WebDriver driver) {
        super(driver);
        productFunctions = new ProductFunctions(driver);
        calenderFunctions = new CalenderFunctions(driver);
    }

    public boolean createProductAndVerify(String productName, String productCode, String categoryName, CurrencyEnum currency, String tax) throws Exception {
        try {
            logger.log(Level.INFO, "Start | createProductAndVerify()");
            productFunctions.getProductsPage().waitForAddProductButton();
            productFunctions.getProductsPage().clickOnAddProductButton();
            productFunctions.fillProductDetails(productName, productCode, categoryName, currency, tax);
            productFunctions.getAddProductsPage().clickOnSave();
            return productFunctions.getProductsPage().isProductDisplayed(productName, productCode);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | createProductAndVerify()");
            throw e;
        }
    }

    public ProductFunctions getProductFunctions() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getProductFunctions()");
            return new ProductFunctions(driver);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getProductFunctions()");
            throw e;
        }
    }
}
