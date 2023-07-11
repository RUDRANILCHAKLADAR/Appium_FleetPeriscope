package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class VehicleDetailsPage extends BasePage{

    public VehicleDetailsPage(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Details")
    @AndroidFindBy(accessibility = "Details")
    public WebElement detailsTab;



}
