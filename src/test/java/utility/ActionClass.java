package utility;

import AppiumAutomation.BaseClass;
import AppiumAutomation.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class ActionClass {
    private final AppiumDriver driver;


    public ActionClass(AppiumDriver driver) {
        this.driver = driver;
    }


    public static final Logger log = LoggerFactory.getLogger(ActionClass.class);


    public void waitForVisibility(WebElement element) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("Element is not visible: " + element);
            throw e;
        }
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
        try {
            return element;
        } catch (NoSuchElementException e) {
            throw e;

        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickElement(WebElement element) {
        waitForVisibility(element);
        element.click();

    }

    public void sendKeys(WebElement element, String txt) {

        element.sendKeys(txt);
    }

//    public List<WebElement> is(List<WebElement> element) {
//        try {
//            return listOfElements(element);
//        } catch (NoSuchElementException e) {
//            throw e;
//        }
//    }



    private boolean existsElement(String id) {
        try {
            driver.findElement(By.id(id));
        } catch (Exception e) {
            System.out.println("id is not present ");
            return false;
        }

        return true;
    }



    public boolean element(WebElement element) {
        return element(element);
    }


    public void internetOff(){
        ( (AndroidDriver)driver).setConnection(new ConnectionStateBuilder().
                withWiFiDisabled().withDataDisabled().build());
    }

    public void internetOn(){
        ( (AndroidDriver)driver).setConnection(new ConnectionStateBuilder().
                withWiFiEnabled().withDataEnabled().build());
    }


    public void pullToRefresh() {
        int deviceWidth = BaseTest.driver.manage().window().getSize().getWidth();
        int deviceHeight = BaseTest.driver.manage().window().getSize().getHeight();
        int midX = deviceWidth / 2;
        int midY = deviceHeight / 2;
        int bottomEdge = (int)((float)deviceHeight * 0.85F);
        (new TouchAction((PerformsTouchActions) driver)).
                press(PointOption.point(midX, midY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10L))).moveTo(PointOption.point(midX, bottomEdge)).release().perform();
    }

    public void scrollToEnd() {
        // Get the size of the device screen
        Dimension size = driver.manage().window().getSize();

        // Define the start and end coordinates for the scroll gesture
        int startX = (int) (size.width * 0.5);
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        // Perform the scroll gesture from start to end coordinates
        new TouchAction((PerformsTouchActions)(AppiumDriver) driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, endY))
                .release().perform();

        // Wait for the content to load if necessary
        // ...
    }

//    public void scrollDown(int swipeTimes, int durationForSwipe) {
//        Dimension dimension = driver.manage().window().getSize();
//
//        for (int i = 0; i <= swipeTimes; i++) {
//            int start = (int) (dimension.getHeight() * 0.5);
//            int end = (int) (dimension.getHeight() * 0.3);
//            int x = (int) (dimension.getWidth() * .5);
//
//            new TouchAction((PerformsTouchActions)(AppiumDriver) driver).press(PointOption.point(x, start)).moveTo(PointOption.point(x, end))
//                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationForSwipe)))
//                    .release().perform();
//        }
//    }

}