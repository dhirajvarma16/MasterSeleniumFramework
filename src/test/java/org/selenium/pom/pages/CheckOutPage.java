package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.UserLogin;

import java.time.Duration;
import java.util.List;

public class CheckOutPage extends basePage{
    private final By checkOutBtn= By.cssSelector(".checkout-button.button.alt.wc-forward");
    private final By userNameFld= By.cssSelector("#billing_first_name");
    private final By lastNameFld= By.cssSelector("#billing_last_name");
    private final By billingAddress= By.cssSelector("#billing_address_1");
    private final By billingCity= By.cssSelector("#billing_city");
    private final By billingPostCode= By.cssSelector("#billing_postcode");
    private final By billingEmail= By.cssSelector("#billing_email");
    private final By orderPlace= By.cssSelector("#place_order");
    private final By noticeMsgLabel=By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received");

    private final By userName=By.cssSelector("#username");
    private final By passWord=By.cssSelector("#password");

    private final By loginBtn=By.cssSelector("button[value='Login']");

    private final By orverlays=By.cssSelector(".blockUI.blockOverlay");

    private final By countryDropDown=By.cssSelector("#billing_country");
    private final By stateElement=By.id("billing_state");
    private final By paymentMode = By.xpath("");
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage checkOutBtn(){
        driver.findElement(checkOutBtn).click();
        return this;
    }
    public CheckOutPage userNameFld(String name){
        WebElement e= waitForElementToBeVisible(userNameFld);
        e.sendKeys(name);
        /*
        driver.findElement(userNameFld).sendKeys(name);
       */
        return this;
    }

    public CheckOutPage lastNameFld(String lastname){
        waitForElementToBeVisible(lastNameFld).sendKeys(lastname);
        return this;
    }

    public CheckOutPage billingAddress(String billAddress){
        waitForElementToBeVisible(billingAddress).sendKeys(billAddress);
        return this;
    }
    public CheckOutPage billingCity(String billCity){
        waitForElementToBeVisible(billingCity).sendKeys(billCity);
        return this;
    }

    public CheckOutPage billingPostCode(String PostCode){
        waitForElementToBeVisible(billingPostCode).sendKeys(PostCode);
        return this;
    }

    public CheckOutPage billingEmail(String billEmail){
        waitForElementToBeVisible(billingEmail).sendKeys(billEmail);
        return this;
    }

    public CheckOutPage orderPlace(){
        waitForOverlaysToDisapper(orverlays);
        waitForElementToBeVisible(orderPlace).click();
        return this;
    }

    public String getNotice(){
        return waitForElementToBeVisible(noticeMsgLabel).getText();
    }

    private CheckOutPage enterUserName(String userName1){
        waitForElementToBeVisible(userName).sendKeys(userName1);
        return this;
    }

    private CheckOutPage enterPassword(String password){
        waitForElementToBeVisible(passWord).sendKeys(password);
        return this;
    }

    private CheckOutPage clickLoginBtn(){
        waitForElementToBeVisible(loginBtn).click();
        return this;
    }

    public CheckOutPage fillUpUserDetails(UserLogin userLogin){
        return enterUserName(userLogin.getUsername()).enterPassword(userLogin.getPassword()).clickLoginBtn();
    }

    public CheckOutPage selectCountryValueFromDropDown(String countryName){
        Select select= new Select(driver.findElement(countryDropDown));
        select.selectByVisibleText(countryName);
        return this;
    }
    public CheckOutPage selectStateValueFromDropDown(String stateName){
        Select select= new Select(driver.findElement(stateElement));
        select.selectByVisibleText(stateName);
        return this;
    }

    public CheckOutPage selectPaymentmode(String billingMode){
        By paymentMode=By.xpath("//label[contains(text(),'"+billingMode+"')]/preceding-sibling::input[@class='input-radio']");
        waitForElementToBeVisible(paymentMode).click();
        return this;
    }

    public CheckOutPage setBillingAddressDetails(BillingAddress billingAddress){
        return userNameFld(billingAddress.getFirstName()).
                lastNameFld(billingAddress.getLastName()).
                selectCountryValueFromDropDown(billingAddress.getCountry()).
                selectStateValueFromDropDown(billingAddress.getState()).
                billingAddress(billingAddress.getAddressLine()).
                billingCity(billingAddress.getCity()).
                billingPostCode(billingAddress.getPostalCode()).
                selectPaymentmode(billingAddress.getBilling()).
                billingEmail(billingAddress.getEmail());

    }
}
