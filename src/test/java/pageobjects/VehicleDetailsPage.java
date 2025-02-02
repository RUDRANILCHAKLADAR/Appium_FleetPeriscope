package pageobjects;

import core.testrail.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class VehicleDetailsPage extends BasePage {

    public VehicleDetailsPage(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Details")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Details\"]/android.widget.TextView")
    public WebElement detailsTab;

}
