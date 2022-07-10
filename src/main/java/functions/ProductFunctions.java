package functions;

import enums.CurrencyEnum;
import functionbases.BaseFunctionObject;
import org.openqa.selenium.WebDriver;
import pageobjects.AddProductsPage;
import pageobjects.ProductsPage;

import java.util.logging.Level;

public class ProductFunctions extends BaseFunctionObject {

    private AddProductsPage addProductsPage;
    private ProductsPage productsPage;

    public ProductFunctions(WebDriver driver) {
        super(driver);
        productsPage = new ProductsPage(driver);
        addProductsPage = new AddProductsPage(driver);
    }

    public AddProductsPage getAddProductsPage() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getAddProductsPage()");
            return addProductsPage;
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getAddProductsPage()");
            throw e;
        }
    }

    public ProductsPage getProductsPage() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getProductsPage()");
            return productsPage;
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getProductsPage()");
            throw e;
        }
    }

    public void fillProductDetails(String productName, String productCode, String CategoryName, CurrencyEnum currency, String tax) throws Exception {
        try {
            logger.log(Level.INFO, "Start | fillProductDetails()");
            addProductsPage.waitForAddProductPage();
            addProductsPage.enterProductName(productName);
            addProductsPage.enterProductCode(productCode);
            addProductsPage.clickOnCategoryDropDown();
            addProductsPage.clickOnCategoryNameInDropDown(CategoryName);
            addProductsPage.clickOnCurrencyDropDown();
            addProductsPage.selectCurrency(currency);
            addProductsPage.enterTax(tax);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | fillProductDetails()");
            throw e;
        }
    }

    public void deleteAllProducts() throws Exception {
        try {
            logger.log(Level.INFO, "Start | deleteAllProducts()");
            if (!productsPage.isProductsAreEmpty()) {
                productsPage.clickOnSelectAllCheckBox();
                productsPage.clickDeleteIcon();
                productsPage.clickConfirmationDeleteButton();
                productsPage.waitForDeleteConfirmationToDissapear();
            }
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | deleteAllProducts()");
            throw e;
        }
    }
}
