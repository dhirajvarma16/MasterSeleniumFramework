package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class MyFirstTestCase extends BaseTest {

    @Test
    public void getCheckOutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com/");
        HomePage homePage=new HomePage(driver);
        StorePage storePage= homePage.navigateToStoreUsingMenu();
        storePage.search("Blue");
        Assert.assertEquals(storePage.searchResult(),"Search results: “Blue”");
        storePage.clickAddToCart("Blue Shoes");
        Thread.sleep(5000);
        CartPage cartPage = storePage.ClickViewCart();
        Assert.assertEquals(cartPage.productName(),"Blue Shoes");
        Thread.sleep(5000);
        CheckOutPage checkOutPage=cartPage.checkOut()
                .userNameFld("demo").lastNameFld("test")
                .billingAddress("LTL").billingCity("Test Automation").
                billingPostCode("12345").billingEmail("drvarma@gs.com")
                .orderPlace();

        Thread.sleep(5000);
        Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");

        driver.quit();
    }

    @Test
    public void loginAndgetCheckOutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com/");
        HomePage homePage=new HomePage(driver).load();
        StorePage storePage= homePage.navigateToStoreUsingMenu();
        storePage.search("Blue");
        Assert.assertEquals(storePage.searchResult(),"Search results: “Blue”");
        storePage.clickAddToCart("Blue Shoes");
        Thread.sleep(5000);
        CartPage cartPage = storePage.ClickViewCart();
        Assert.assertEquals(cartPage.productName(),"Blue Shoes");
        Thread.sleep(5000);
        cartPage.checkOut();
        CheckOutPage checkOutPage=cartPage.clickUserLogin();
        Thread.sleep(5000);
        checkOutPage.fillUpUserDetails("demo2","test").userNameFld("demo2").lastNameFld("test")
                .billingAddress("LTL").billingCity("Test Automation").
                billingPostCode("12345").billingEmail("drvarma@gs.com")
                .orderPlace();

        Thread.sleep(5000);
        Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");

        driver.quit();
    }


}
