package org.selenium.pom.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.UserLogin;
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
        BillingAddress billingAddress=JacksonUtils.deserializeJson("myBillingAddress.json",BillingAddress.class);
        Product product= new Product(1251);

        StorePage storePage=new HomePage(getDriver()).load().navigateToStoreUsingMenu();
        storePage.isLoaded();
        storePage.search("Blue");

        Assert.assertEquals(storePage.searchResult(),"Search results: “Blue”");

        storePage.clickAddToCart(product.getProductName());
        CartPage cartPage = storePage.ClickViewCart();
        Assert.assertEquals(cartPage.productName(),product.getProductName());
        CheckOutPage checkOutPage=cartPage.checkOut().setBillingAddressDetails(billingAddress)
                .orderPlace();
        Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");

        getDriver().quit();
    }

    @Test
    public void loginAndgetCheckOutUsingDirectBankTransfer() throws InterruptedException, IOException {
        BillingAddress billingAddress=JacksonUtils.deserializeJson("myBillingAddress.json",BillingAddress.class);
        Product product= new Product(1251);

        StorePage storePage=new HomePage(getDriver()).load().navigateToStoreUsingMenu()
                .search("Blue");
        Assert.assertEquals(storePage.searchResult(),"Search results: “Blue”");
        storePage.clickAddToCart(product.getProductName());

        CartPage cartPage = storePage.ClickViewCart();
        cartPage.isLoaded();
        Assert.assertEquals(cartPage.productName(),product.getProductName());

        cartPage.checkOut();
        CheckOutPage checkOutPage=cartPage.clickUserLogin();

        UserLogin userLogin=JacksonUtils.deserializeJson("userLoginDetails.json",UserLogin.class);
        userLogin.setUsername("demo2").setPassword("test");

        checkOutPage.fillUpUserDetails(userLogin)
                .setBillingAddressDetails(billingAddress)
                .orderPlace();

        Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");

        getDriver().quit();
    }


}
