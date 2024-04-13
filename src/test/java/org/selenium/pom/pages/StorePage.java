package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends basePage {
//    private final By searchFld = By.cssSelector("#woocommerce-product-search-field-0");
//    private final By searchBtn =By.cssSelector("button[value='Search']");
//    private final By searchRslTxt=By.cssSelector("#main > div > header > h1");
////    private final By addToCrt=By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
//    private final By viewCart=By.xpath("//a[@title='View cart']");

    @FindBy (css="#woocommerce-product-search-field-0")
    WebElement searchFld;
    @FindBy(css="button[value='Search']")
    WebElement searchBtn;
    @FindBy(css="#main > div > header > h1")
    WebElement searchRslTxt;
    @FindBy(xpath= "//a[@title='View cart']") @CacheLookup
    WebElement viewCart;


    public StorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public StorePage searchValue(String searchVal){
        searchFld.sendKeys(searchVal);
        return this;
    }

    public Boolean isLoaded(){
        return waitLong.until(ExpectedConditions.urlContains("/store"));
    }

    public StorePage search(String searchVals){
        searchFld.sendKeys(searchVals);
        searchBtn.click();
        return new StorePage(driver);
    }

    public StorePage clickSearchBtn(){
        searchBtn.click();
        return new StorePage(driver);
    }

    public String searchResult(){
    return searchRslTxt.getText();
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
        viewCart.click();
        return new CartPage(driver);
    }

    public StorePage load(){
        load("/store");
        return this;
    }

    public StorePage getSearchedURL(){
        driver.getCurrentUrl();
        return this;
    }
}

