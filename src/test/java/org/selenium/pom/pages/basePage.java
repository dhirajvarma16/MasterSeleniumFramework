package org.selenium.pom.pages;

import org.openqa.selenium.WebDriver;

public class basePage {

    protected WebDriver driver;

    public basePage(WebDriver driver){
        this.driver=driver;
    }
    public void load(String endPoint){
        driver.get("https://askomdch.com"+endPoint);
    }
}
