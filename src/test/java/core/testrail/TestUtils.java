package core.testrail;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
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

import java.time.Duration;
import java.util.List;
//import java.util.NoSuchElementException;
import org.openqa.selenium.NoSuchElementException;

public class TestUtils {

    public static final Logger log = LoggerFactory.getLogger(TestUtils.class);

    public static void waitForVisibility(WebElement element, AppiumDriver driver) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("Element is not visible: " + element);
            throw e;
        }
    }

    public static boolean waitForInvisibility(WebElement element, AppiumDriver driver) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            System.out.println("Element is visible: " + element);
            throw e;
        }
        return true;
    }


    public static boolean alertIsPresent(AppiumDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            System.out.println("Element is not visible: ");
            throw e;
        }
        return true;
    }


    public static boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void clickElement(WebElement element, AppiumDriver driver) {
        waitForVisibility(element, driver);
        element.click();

    }

    public static void sendKeys(WebElement element, String txt) {
        element.sendKeys(txt);
    }

    public List<WebElement> listOfElements(List<WebElement> element) {
        try {
            return element;
        } catch (NoSuchElementException e) {
            throw e;
        }
    }


    private static boolean existsElement(String id, AppiumDriver driver) {
        try {
            driver.findElement(By.id(id));
        } catch (Exception e) {
            System.out.println("id is not present ");
            return false;
        }

        return true;
    }

    public static void internetOff(AppiumDriver driver) {
        ((AndroidDriver) driver).setConnection(new ConnectionStateBuilder().
                withWiFiDisabled().withDataDisabled().build());
    }


    public static void internetOn(AppiumDriver driver) {
        ((AndroidDriver) driver).setConnection(new ConnectionStateBuilder().
                withWiFiEnabled().withDataEnabled().build());
    }


    public static void pullToRefresh(AppiumDriver driver) {
        int deviceWidth = driver.manage().window().getSize().getWidth();
        int deviceHeight = driver.manage().window().getSize().getHeight();
        int midX = deviceWidth / 2;
        int midY = deviceHeight / 2;
        int bottomEdge = (int) ((float) deviceHeight * 0.85F);
        (new TouchAction((PerformsTouchActions) driver)).
                press(PointOption.point(midX, midY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10L))).moveTo(PointOption.point(midX, bottomEdge)).release().perform();
    }

    public static void scrollToEnd(AppiumDriver driver) {
        // Get the size of the device screen
        Dimension size = driver.manage().window().getSize();

        // Define the start and end coordinates for the scroll gesture
        int startX = (int) (size.width * 0.5);
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        // Perform the scroll gesture from start to end coordinates
        new TouchAction((PerformsTouchActions) (AppiumDriver) driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, endY))
                .release().perform();

        // Wait for the content to load if necessary
        // ...
    }

    public static void logInUser(BasePage basePage, AppiumDriver driver, String userName, String passWord,BaseTest baseTest) {
        TestUtils.waitForVisibility(basePage.signIn, driver);
        basePage.signIn.click();
        TestUtils.waitForVisibility(basePage.userName, driver);
        TestUtils.sendKeys(basePage.userName, userName);
        TestUtils.sendKeys(basePage.password, passWord);
        basePage.signIn.click();

        if (baseTest.isAndroidPlatform()) {
            TestUtils.waitForVisibility(basePage.permission_access, driver);
            basePage.permission_access.isDisplayed();
            basePage.permission_access.click();
        }
        TestUtils.waitForVisibility(basePage.homeBottomBar, driver);
    }

    public static void logOutUser(BasePage basePage,AppiumDriver driver) {
        TestUtils.waitForVisibility(basePage.Account_icon, driver);
        basePage.Account_icon.click();
        basePage.Logout.click();
        TestUtils.waitForVisibility(basePage.Confirm_btn, driver);
        basePage.Confirm_btn.click();
    }
//    public  static void swipeLeft(List<WebElement> element, AppiumDriver driver) {
//        WebElement firstElement = element.get(0);
//        WebElement fourthElement = element.get(3);
//        int midOfYCoordinate = firstElement.getLocation().y + (firstElement.getSize().height / 2);
//        int firstElementXCoordinate = firstElement.getLocation().x;
//        int fourthElementXCoordinate = fourthElement.getLocation().x;
//        TouchAction action = new TouchAction((PerformsTouchActions)  driver);
//        action.press(PointOption.point(fourthElementXCoordinate, midOfYCoordinate))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
//                .moveTo(PointOption.point(firstElementXCoordinate, midOfYCoordinate))
//                .release()
//                .perform();
//
//    }
//
//    public static void swipeRight(List<WebElement> element, AppiumDriver driver) {
//        WebElement fourthElement = element.get(element.size()-1);
//        WebElement sixthElement = element.get(element.size()-3);
//        int midOfYCoordinate = fourthElement.getLocation().y + (fourthElement.getSize().height / 2);
//        int fourthElementXCoordinate = fourthElement.getLocation().x;
//        int sixthElementXCoordinate = sixthElement.getLocation().x;
//
//        TouchAction action = new TouchAction((PerformsTouchActions) driver);
//        action.press(PointOption.point(sixthElementXCoordinate, midOfYCoordinate))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
//                .moveTo(PointOption.point(fourthElementXCoordinate, midOfYCoordinate))
//                .release()
//                .perform();
//
//    }

//    public static  void ScrollDown( AppiumDriver driver) {
//        TouchAction  action =new TouchAction((PerformsTouchActions) driver);
//        Dimension size	=driver.manage().window().getSize();
//        int width=size.width;
//        int height=size.height;
//        int middleOfX=width/2;
//        int startYCoordinate= (int)(height*.7);
//        int endYCoordinate= (int)(height*.2);
//
//        action.press(PointOption.point(middleOfX, startYCoordinate))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
//                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
//
//    }

    public static void handlelocationPopup(BaseTest baseTest,BasePage basePage,AppiumDriver driver)
    {
        if(baseTest.isIosPlatform())
        {
            if(isElementPresent(basePage.allowButton))
            {
               basePage.allowButton.click();
            }
        }
    }
    public  static void swipeLeft(List<WebElement> element, AppiumDriver driver) {
        WebElement firstElement = element.get(0);
        WebElement fourthElement = element.get(3);
        int midOfYCoordinate = firstElement.getLocation().y + (firstElement.getSize().height / 2);
        int firstElementXCoordinate = firstElement.getLocation().x;
        int fourthElementXCoordinate = fourthElement.getLocation().x;
        TouchAction action = new TouchAction((PerformsTouchActions)  driver);
        action.press(PointOption.point(fourthElementXCoordinate, midOfYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(firstElementXCoordinate, midOfYCoordinate))
                .release()
                .perform();

    }

    public static void swipeRight(List<WebElement> element, AppiumDriver driver) {
        WebElement fourthElement = element.get(element.size()-1);
        WebElement sixthElement = element.get(element.size()-3);
        int midOfYCoordinate = fourthElement.getLocation().y + (fourthElement.getSize().height / 2);
        int fourthElementXCoordinate = fourthElement.getLocation().x;
        int sixthElementXCoordinate = sixthElement.getLocation().x;

        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        action.press(PointOption.point(sixthElementXCoordinate, midOfYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(fourthElementXCoordinate, midOfYCoordinate))
                .release()
                .perform();

    }

    public static  void ScrollDown( AppiumDriver driver) {
        TouchAction  action =new TouchAction((PerformsTouchActions) driver);
        Dimension size =driver.manage().window().getSize();
        int width=size.width;
        int height=size.height;
        int middleOfX=width/2;
        int startYCoordinate= (int)(height*.7);
        int endYCoordinate= (int)(height*.2);

        action.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();

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