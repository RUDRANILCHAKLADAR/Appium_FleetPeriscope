package utility;

import AppiumAutomation.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public List<WebElement> listOfElements(List<WebElement> element) {
        try {
            return listOfElements(element);
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
        try {
            element.sendKeys(txt);
        } catch (NoSuchElementException e) {
            throw e;
        }

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



    public boolean element(WebElement element) {
        return element(element);
    }


    public void networkOn(){
        ( (AndroidDriver)driver).setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());
    }


    public void pullToRefresh() {
        int deviceWidth = BaseClass.driver.manage().window().getSize().getWidth();
        int deviceHeight = BaseClass.driver.manage().window().getSize().getHeight();
        int midX = deviceWidth / 2;
        int midY = deviceHeight / 2;
        int bottomEdge = (int)((float)deviceHeight * 0.85F);
        (new TouchAction((AndroidDriver)(driver))).
                press(PointOption.point(midX, midY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10L))).moveTo(PointOption.point(midX, bottomEdge)).release().perform();
    }

}