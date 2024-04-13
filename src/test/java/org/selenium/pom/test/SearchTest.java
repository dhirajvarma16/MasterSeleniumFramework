package org.selenium.pom.test;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    StorePage storePage;
    @Test
     public void SearchWithPartialMatch(){
        storePage= new StorePage(getDriver()).load();
        storePage.search("Blue");
        Assert.assertEquals("","");
     }

     @Test
    public void verifySearchedURl(){
         String URLValue = storePage.getSearchedURL().toString();
         Assert.assertTrue(URLValue.contains("Bule&post_type=product"));
     }

}
