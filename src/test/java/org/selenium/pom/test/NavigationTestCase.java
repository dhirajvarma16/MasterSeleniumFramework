package org.selenium.pom.test;

import org.bouncycastle.util.Store;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTestCase extends BaseTest {

    @Test
     public void NavigateFromHomeToStoreUsingMenu(){
         StorePage storePage= new HomePage(getDriver())
                 .load().
                 navigateToStoreUsingMenu();
//         Assert.assertEquals(storePage.getTitle(),"");

     }

}
