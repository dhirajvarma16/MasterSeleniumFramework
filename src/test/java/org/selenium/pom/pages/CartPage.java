package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends basePage {

    private final By productName = By.cssSelector("td[class='product-name']");
    private final By checkoutBtn = By.cssSelector(".checkout-button.button.alt.wc-forward");
    private final By userLogin= By.cssSelector(".showlogin");
    private final By carHeading = By.cssSelector(".has-text-align-center");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isLoaded(){
       return waitLong.until(ExpectedConditions.textToBe(carHeading,"Cart"));
    }

    public String productName(){
        return
                waitLong.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
//                driver.findElement(productName).getText();
    }

    public CheckOutPage checkOut(){
        waitLong.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
//        driver.findElement(checkoutBtn).click();
        return new CheckOutPage(driver);
    }

    public CheckOutPage clickUserLogin(){
        driver.findElement(userLogin).click();
        return new CheckOutPage(driver);
    }
}
