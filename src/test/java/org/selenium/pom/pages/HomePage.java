package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends basePage{

    private  final By storeManuLink=By.cssSelector("#menu-item-1227 > a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public StorePage navigateToStoreUsingMenu(){
        driver.findElement(storeManuLink).click();
        return new StorePage(driver);
    }

    public HomePage load() {
        load("/");
        return this;
    }
}
