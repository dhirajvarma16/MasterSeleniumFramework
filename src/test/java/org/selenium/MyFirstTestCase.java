package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class MyFirstTestCase extends BaseTest {

    @Test
    public void getCheckOutUsingDirectBankTransfer() throws InterruptedException, IOException {
        BillingAddress billingAddress=new BillingAddress();
        InputStream is=getClass().getClassLoader().getResourceAsStream("myBillingAddress.json");
        JacksonUtils.deserializeJson(is,billingAddress);
        driver.get("https://askomdch.com/");
        BillingAddress billingAddressDetails= new BillingAddress("Demo","Test","San Francisco","San Francisco","98121","test@gs1.com");
                /*new BillingAddress();
        billingAddressDetails.setFirstName("Demo")
                .setLastName("Test").setAddressLine("San Francisco")
                .setCity("San Francisco").setPostalCode("98121").setEmail("test@gs.com");*/


        StorePage storePage=new HomePage(driver).load().navigateToStoreUsingMenu()
        .search("Blue");

        Assert.assertEquals(storePage.searchResult(),"Search results: “Blue”");
        storePage.clickAddToCart("Blue Shoes");
        Thread.sleep(5000);
        CartPage cartPage = storePage.ClickViewCart();
        Assert.assertEquals(cartPage.productName(),"Blue Shoes");
        Thread.sleep(5000);
        CheckOutPage checkOutPage=cartPage.checkOut().setBillingAddressDetails(billingAddressDetails)
                .orderPlace();

        Thread.sleep(5000);
        Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");

        driver.quit();
    }

    @Test
    public void loginAndgetCheckOutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com/");
        StorePage storePage=new HomePage(driver).load().navigateToStoreUsingMenu()
                .search("Blue");
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
