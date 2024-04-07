package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.objects.BillingAddress;

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

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage checkOutBtn(){
        driver.findElement(checkOutBtn).click();
        return new CheckOutPage(driver);
    }
    public CheckOutPage userNameFld(String name){
        driver.findElement(userNameFld).sendKeys(name);
        return new CheckOutPage(driver);
    }

    public CheckOutPage lastNameFld(String lastname){
        driver.findElement(lastNameFld).sendKeys(lastname);
        return new CheckOutPage(driver);
    }

    public CheckOutPage billingAddress(String billAddress){
        driver.findElement(billingAddress).sendKeys(billAddress);
        return new CheckOutPage(driver);
    }
    public CheckOutPage billingCity(String billCity){
        driver.findElement(billingCity).sendKeys(billCity);
        return new CheckOutPage(driver);
    }

    public CheckOutPage billingPostCode(String PostCode){
        driver.findElement(billingPostCode).sendKeys(PostCode);
        return new CheckOutPage(driver);
    }

    public CheckOutPage billingEmail(String billEmail){
        driver.findElement(billingEmail).sendKeys(billEmail);
        return new CheckOutPage(driver);
    }

    public CheckOutPage orderPlace(){
        driver.findElement(orderPlace).click();
        return new CheckOutPage(driver);
    }

    public String getNotice(){
        return driver.findElement(noticeMsgLabel).getText();
    }

    private CheckOutPage enterUserName(String userName1){
        driver.findElement(userName).sendKeys(userName1);
        return new CheckOutPage(driver);
    }

    private CheckOutPage enterPassword(String password){
        driver.findElement(passWord).sendKeys(password);
        return new CheckOutPage(driver);
    }

    private CheckOutPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return new CheckOutPage(driver);
    }

    public CheckOutPage fillUpUserDetails(String userName,String password){
        return enterUserName(userName).enterPassword(password).clickLoginBtn();
    }

    public CheckOutPage setBillingAddressDetails(BillingAddress billingAddress){
        return userNameFld(billingAddress.getFirstName()).
                lastNameFld(billingAddress.getLastName()).
                billingAddress(billingAddress.getAddressLine()).
                billingCity(billingAddress.getCity()).
                billingPostCode(billingAddress.getPostalCode()).
                billingEmail(billingAddress.getEmail());

    }
}
