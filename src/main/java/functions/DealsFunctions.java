package functions;

import enums.CurrencyEnum;
import functionbases.BaseFunctionObject;
import org.openqa.selenium.WebDriver;
import pageobjects.AddDealsPage;
import pageobjects.AddProductsToDealPage;
import pageobjects.DealDetailsPage;
import pageobjects.DealsPage;
import pageobjects.ScheduleAnActivityPage;

import java.util.logging.Level;

public class DealsFunctions extends BaseFunctionObject {

    private DealsPage dealsPage;
    private AddDealsPage addDealsPage;
    private ScheduleAnActivityPage scheduleAnActivityPage;
    private DealDetailsPage dealDetails;
    private AddProductsToDealPage addProductsToDealPage;

    public DealsFunctions(WebDriver driver) {
        super(driver);
        dealsPage = new DealsPage(driver);
        addDealsPage = new AddDealsPage(driver);
        scheduleAnActivityPage = new ScheduleAnActivityPage(driver);
        dealDetails = new DealDetailsPage(driver);
        addProductsToDealPage = new AddProductsToDealPage(driver);
    }

    public AddDealsPage getAddDealsPage() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getAddDealsPage()");
            return new AddDealsPage(driver);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getAddDealsPage()");
            throw e;
        }
    }

    public DealsPage getDealsPage() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getDealsPage()");
            return new DealsPage(driver);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getDealsPage()");
            throw e;
        }
    }

    public void fillDealDetails(String personName, String organizationName, String value, CurrencyEnum currency, String pipelineId, String phone, String email) throws Exception {
        try {
            logger.log(Level.INFO, "Start | fillDealDetails()");
            addDealsPage.waitForAddDealPage();
            addDealsPage.enterContactPersonName(personName);
            addDealsPage.enterOrganizationName(organizationName);
            addDealsPage.enterValue(value);
            addDealsPage.selectCurrency(currency);
            addDealsPage.clickOnCurrencyValue();
            addDealsPage.clickOnPipelineStage(pipelineId);
            addDealsPage.enterPhone(phone);
            addDealsPage.enterEmail(email);
            addDealsPage.clickOnExpectedCloseDate();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | fillDealDetails()");
            throw e;
        }
    }

    public void navigateToSheduleAnActivity(String dealName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | navigateToSheduleAnActivity()");
            dealsPage.waitForTriangleButton(dealName);
            dealsPage.clickOnTriangleButton(dealName);
            dealsPage.clickOnScheduleAnActivity();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | navigateToSheduleAnActivity()");
            throw e;
        }
    }

    public void fillSheduleActivityData(String activitySubject, String dueTime, String endTime, String note) throws Exception {
        try {
            logger.log(Level.INFO, "Start | fillSheduleActivityData()");
            scheduleAnActivityPage.enterActivitySubject(activitySubject);
            scheduleAnActivityPage.clickOnMeetingButton();
            scheduleAnActivityPage.enterNote(note);
            scheduleAnActivityPage.enterDueTime(dueTime);
            scheduleAnActivityPage.enterEndTime(endTime);
            scheduleAnActivityPage.clickOnEndDateField();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | fillSheduleActivityData()");
            throw e;
        }
    }

    public ScheduleAnActivityPage getScheduleAnActivityPage() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getScheduleAnActivityPage()");
            return new ScheduleAnActivityPage(driver);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getScheduleAnActivityPage()");
            throw e;
        }
    }

    public void deleteDeal() throws Exception {
        try {
            logger.log(Level.INFO, "Start | deleteDeal()");
            dealDetails.clickOnDealOptionButton();
            dealDetails.clickOnOptioninDealOptionsDropDown("delete");
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | deleteDeal()");
            throw e;
        }
    }

    public void deleteAllDeals() throws Exception {
        try {
            logger.log(Level.INFO, "Start | deleteAllDeals()");
            if (dealsPage.isDealsAvailable()) {
                int dealCount = dealsPage.getDealCountInPage();
                for (int i = 1; i <= dealCount; i++) {
                    dealsPage.clickOnLeftNavigationItem("Deals");
                    dealsPage.clickOnFirstDeal();
                    dealDetails.clickOnDealOptionButton();
                    dealDetails.clickOnOptioninDealOptionsDropDown("Delete");
                    driver.switchTo().alert().accept();
                }
            }
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | deleteAllDeals()");
            throw e;
        }
    }

    public void deleteAllDealsByDragAndDrop() throws Exception {
        try {
            logger.log(Level.INFO, "Start | deleteAllDealsByDragAndDrop()");
            if (dealsPage.isDealsCardsDisplayed()) {
                int dealCount = dealsPage.getDealCountInPage();
                for (int i = 1; i <= dealCount; i++) {
                    dealsPage.dragAndDropFirstDealDelete();
                }
            }
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | deleteAllDealsByDragAndDrop()");
            throw e;
        }
    }

    public boolean isDuplicateContactSuggestionDisplayed(String duplicateContact) throws Exception {
        try {
            logger.log(Level.INFO, "Start | isDuplicateContactSuggestionDisplayed()");
            addDealsPage.enterContactPersonName(duplicateContact);
            boolean isSuggestionDisplayed = addDealsPage.isDuplicateContactDropDownDisplayed();
            addDealsPage.clickOnDuplicateItemSuggestion();
            return isSuggestionDisplayed;
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isDuplicateContactSuggestionDisplayed()");
            throw e;
        }
    }

    public boolean isSuggestedDetailsFilledCorrectly(String organization, String phone, String email) throws Exception {
        try {
            logger.log(Level.INFO, "Start | isSuggestedDetailsFilledCorrectly()");
            addDealsPage.waitTillOrganizationFilled(organization);
            return addDealsPage.getFilledPhoneNumber().equalsIgnoreCase(phone) &&
                addDealsPage.getFilledOrganizationName().equalsIgnoreCase(organization) &&
                addDealsPage.getFilledEmail().equalsIgnoreCase(email);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isSuggestedDetailsFilledCorrectly()");
            throw e;
        }
    }

    public boolean isDealCardHasCorrectDetails(String dealName, String organization, String value) throws Exception {
        try {
            logger.log(Level.INFO, "Start | isDealCardHasCorrectDetails()");
            return dealsPage.getDealValueInCardView(dealName).equalsIgnoreCase(value) &&
                dealsPage.getDealOrganizationInCardView(dealName).equalsIgnoreCase(organization);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isDealCardHasCorrectDetails()");
            throw e;
        }
    }

    public boolean addProductToDeal(String dealName, String productName, String productCode, CurrencyEnum currency, String addedproductCount) throws Exception {
        try {
            logger.log(Level.INFO, "Start | addProductToDeal()");
            dealsPage.clickOnDeal(dealName);
            dealDetails.clickAddProductLink();
            addProductsToDealPage.waitForAddProductsToDealPage();
            addProductsToDealPage.clickOnCurrencyDropDown();
            addProductsToDealPage.selectCurrency(currency);
            addProductsToDealPage.clickOnProductSearchTextBox();
            addProductsToDealPage.selectProductFromDropDown(productCode, productName);
            addProductsToDealPage.clickSaveButton();
            driver.navigate().refresh();
            return dealDetails.getAddedProductCount().contains(addedproductCount + " product");
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | addProductToDeal()");
            throw e;
        }
    }

    public boolean isDealConfirmationMessageDisplayedCorrectly(String dealName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | isDealCardHasCorrectDetails()");
            dealsPage.waitForDealCreationMessageToDisplay();
            return dealsPage.getDealConfirmationMessage().equals("New deal " + "\"" + dealName + "\"" + " created");
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isDealCardHasCorrectDetails()");
            throw e;
        }
    }

    public boolean dragDealToLostAndCompletePopup(String dealName, String reason) throws Exception {
        try {
            logger.log(Level.INFO, "Start | dragDealToLostAndVerifyFilter()");
            dealsPage.dragAndDropDealToLost(dealName);
            dealsPage.waitForDealLostPopup();
            dealsPage.enterLostReason(reason);
            dealsPage.clickMarkAsLostInLostConfirmPopup();
            dealsPage.clickOnDealFilterDropDown();
            dealsPage.clickOnFiltersLink();
            dealsPage.selectFilterOption("All lost deals");
            boolean isDisplayed = dealsPage.isDealDisplayed(dealName);
            dealsPage.clickOnDealFilterDropDown();
            dealsPage.clickOnFiltersLink();
            dealsPage.selectFilterOption("All open deals");
            return isDisplayed;
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | dragDealToLostAndVerifyFilter()");
            throw e;
        }
    }

    public boolean dragDealToWonAndVerifyFilter(String dealName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | dragDealToWonAndVerifyFilter()");
            dealsPage.dragAndDropDealToWon(dealName);
            dealsPage.clickOnDealFilterDropDown();
            dealsPage.clickOnFiltersLink();
            dealsPage.selectFilterOption("All won deals");
            boolean isDisplayed = dealsPage.isDealDisplayed(dealName);
            dealsPage.clickOnDealFilterDropDown();
            dealsPage.clickOnFiltersLink();
            dealsPage.selectFilterOption("All open deals");
            return isDisplayed;
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | dragDealToWonAndVerifyFilter()");
            throw e;
        }
    }

    public void convertDealToLead(String dealName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | dragDealToLostAndVerifyFilter()");
            dealsPage.dragAndDropDealToMoveOrconvert(dealName);
            dealsPage.clickOnDealToLeadConvertDropDown();
            dealsPage.selectConvertDealToLead();
            dealsPage.selectSaveForConvertDealToLead();
            dealsPage.clickConvertDealConfirmationButton();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | dragDealToLostAndVerifyFilter()");
            throw e;
        }
    }

    public void deleteExistingPipeline(String pipelineName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | deleteExistingPipeline()");
            dealsPage.clickOnEditPipeLine();
            if (dealsPage.istPipeLineNameDisplayed(pipelineName)) {
                dealsPage.clickOnDeletePipeline();
                if (dealsPage.isDeleteDealsRadioButtonDisplayed())
                    dealsPage.selectDeleteDealsRadioButton();
                dealsPage.clickOnPipelineDeleteConfirmationButton();
                dealsPage.waitForDeleteConfirmationToDissapear();
            } else
                dealsPage.clickOnCancelButton();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | deleteExistingPipeline()");
            throw e;
        }
    }

    public void addNewPipeline(String pipelineName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | dragDealToLostAndVerifyFilter()");
            dealsPage.clickOnPipelineDropDown();
            dealsPage.clickCreateNewPipelineFromDropDown();
            dealsPage.enterNewPipeLineName(pipelineName);
            dealsPage.clickOnSavePipeline();
            dealsPage.waitForLoadingIconToAppearAndDissapear();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | dragDealToLostAndVerifyFilter()");
            throw e;
        }
    }

    public void switchToPipeline(String pipelineName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | dragDealToLostAndVerifyFilter()");
            if (dealsPage.isCloseButtonDisplayed()) {
                dealsPage.clickOnCloseButton();
            }
            dealsPage.clickOnPipelineDropDown();
            if (dealsPage.isPipelineDisplayed(pipelineName)) {
                dealsPage.selectPipelineFromDropDown(pipelineName);
                dealsPage.waitForLoadingIconToAppearAndDissapear();
            }
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | dragDealToLostAndVerifyFilter()");
            throw e;
        }
    }
}
