package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends basePage {

    private final By productName = By.cssSelector("td[class='product-name']");
    private final By checkoutBtn = By.cssSelector(".checkout-button.button.alt.wc-forward");
    private final By userLogin= By.cssSelector(".showlogin");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String productName(){
        return driver.findElement(productName).getText();
    }

    public CheckOutPage checkOut(){
        driver.findElement(checkoutBtn).click();
        return new CheckOutPage(driver);
    }

    public CheckOutPage clickUserLogin(){
        driver.findElement(userLogin).click();
        return new CheckOutPage(driver);
    }
}
