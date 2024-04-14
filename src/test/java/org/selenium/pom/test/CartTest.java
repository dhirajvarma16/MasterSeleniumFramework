package org.selenium.pom.test;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.Product;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CartTest extends BaseTest {

    StorePage storePage;
    @Test
     public void AddToCartTest() throws IOException {
        Product product= new Product(1251);

        CartPage cartPage = new StorePage(getDriver()).load().
                ClickViewCart();
        Assert.assertEquals(cartPage.productName(),product.getProductName());
     }

}
