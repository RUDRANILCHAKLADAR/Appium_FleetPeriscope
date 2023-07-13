package utility;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class Utils {


    public static boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
