package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    private ThreadLocal<WebDriver>   driver= new ThreadLocal<>();

    protected WebDriver getDriver() {

        return this.driver.get();

    }

    private void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }


    @Parameters("browser")
    @BeforeMethod
    public void startDriver(@Optional String browser){
        if (browser==null) browser= "chrome";
        setDriver(new DriverManager().intializeDriver(browser));
    }

    @AfterMethod
    public void quitDriver(){
        getDriver().quit();
    }
}
