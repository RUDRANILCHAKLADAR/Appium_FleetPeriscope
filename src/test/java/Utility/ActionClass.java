package Utility;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static AppiumAutomation.BaseClass.driver;

public class ActionClass {

    public static final Logger Log = LoggerFactory.getLogger(ActionClass.class);
    public void WaitTillVisibilityOf(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }

    //// Wait for an element to InVisible
    public void WaitTillInVisibilityOf(WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOf(element));
    }

    //Wait For an alert to present
    public void alertIsPresent(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.alertIsPresent());
    }

    public void clickElement(WebElement element){
        element.click();

    }

    public void sendKeys(WebElement element, String txt){
        element.sendKeys(txt);
    }

    public WebElement findElement(WebElement element){
        element=null;
        return element;
    }

    public void click(WebElement element, String msg) {
        WaitTillVisibilityOf(element);
        Log.info(msg);
        element.click();
    }
}
