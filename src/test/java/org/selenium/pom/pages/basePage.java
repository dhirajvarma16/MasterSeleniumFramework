package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class basePage {

    protected WebDriver driver;
    protected WebDriverWait waitLong;
    protected WebDriverWait waitShort;

    public basePage(WebDriver driver){
        this.driver=driver;
        waitLong=new WebDriverWait(driver,Duration.ofSeconds(15));
        waitShort=new WebDriverWait(driver,Duration.ofSeconds(3));
    }
    public void load(String endPoint){
        driver.get("https://askomdch.com"+endPoint);
    }

    public void waitForOverlaysToDisapper(By overlay){
        List<WebElement> overlays= driver.findElements(overlay);
        System.out.println("OVERLAY SIZE: "+overlays.size());
        if (overlays.size() >0){
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(
                    ExpectedConditions.invisibilityOfAllElements(overlays)
            );
            System.out.println("OVERLAYS ARE INVISIBLE:");
        }
        else{
            System.out.println("OVERLAY NOT FOUND:");
        }
    }

    public WebElement waitForElementToBeVisible(By Element){
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(Element));
    }
}
