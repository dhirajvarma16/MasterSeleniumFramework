package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends basePage {
    private final By searchFld = By.cssSelector("#woocommerce-product-search-field-0");
    private final By searchBtn =By.cssSelector("button[value='Search']");
    private final By searchRslTxt=By.cssSelector("#main > div > header > h1");
//    private final By addToCrt=By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
    private final By viewCart=By.xpath("//a[@title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public StorePage searchValue(String searchVal){
        driver.findElement(searchFld).sendKeys(searchVal);
        return this;
    }

    public StorePage search(String searchVals){
        driver.findElement(searchFld).sendKeys(searchVals);
        driver.findElement(searchBtn).click();
        return new StorePage(driver);
    }

    public StorePage clickSearchBtn(){
        driver.findElement(searchBtn).click();
        return new StorePage(driver);
    }

    public String searchResult(){
    return driver.findElement(searchRslTxt).getText();
    }

    private By getAddToCartBtnElement(String productName){
        By addToCrt;
        addToCrt = By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
        return addToCrt;
    }

    public StorePage clickAddToCart(String itemVal){
        driver.findElement(getAddToCartBtnElement(itemVal)).click();
        return new StorePage(driver);
    }

    public CartPage ClickViewCart() {
        driver.findElement(viewCart).click();
        return new CartPage(driver);
    }
}

