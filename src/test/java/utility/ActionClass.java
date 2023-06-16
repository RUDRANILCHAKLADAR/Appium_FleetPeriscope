package utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.connection.HasNetworkConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;

public class ActionClass {
    private final AppiumDriver driver;

    public ActionClass(AppiumDriver driver) {
        this.driver = driver;
    }

    public final int timeOut = 40;


    public static final Logger Log = LoggerFactory.getLogger(ActionClass.class);

//    public void WaitTillVisibilityOf(WebElement element) {
//        new WebDriverWait(driver, Duration.ofSeconds(timeOut)).
//                until(ExpectedConditions.visibilityOf(element));
//    }

    public boolean waitForVisibility(WebElement element) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("Element is not visible: " + element);
            throw e;
        }
        return true;
    }

    public boolean waitForInvisibility(WebElement element) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            System.out.println("Element is visible: " + element);
            throw e;
        }
        return true;
    }


    public boolean alertIsPresent() {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            System.out.println("Element is not visible: ");
            throw e;
        }
        return true;
    }


    public WebElement findElement(WebElement element) {
        return element;
    }

    public void clickElement(WebElement element) {
        element.click();

    }

    public void sendKeys(WebElement element, String txt) {
        element.sendKeys(txt);
    }



    public void click(WebElement element, String msg) {
        waitForVisibility(element);
        Log.info(msg);
        element.click();
    }

    private boolean existsElement(String id) {
        try {
            driver.findElement(By.id(id));
        } catch (Exception e) {
            System.out.println("id is not present ");
            return false;
        }

        return true;
    }

//    public void WifiOn() {
//        ConnectionState state = driver.setConneection(new ConnectionStateBuilder().withWiFiEnabled().
//                withDataDisabled().build());
//        Assert.assertTrue(state.isWiFiEnabled(), "Wifi is not switched on");
//        Log.info("WiFi turned on");
//    }





}