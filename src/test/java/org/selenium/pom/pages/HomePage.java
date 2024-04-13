package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends basePage{

    private  final By storeManuLink=By.cssSelector("#menu-item-1227 > a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load(){
        load("/");
        waitLong.until(ExpectedConditions.titleContains("AskOmDch"));
        return this;
    }

    public StorePage navigateToStoreUsingMenu(){
        driver.findElement(storeManuLink).click();
        return new StorePage(driver);
    }

}
