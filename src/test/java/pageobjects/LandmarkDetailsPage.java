package pageobjects;

import core.testrail.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LandmarkDetailsPage extends BasePage {

    public LandmarkDetailsPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_bottom_title")
    public WebElement landmarkName;
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_bottom_secondary")
    public WebElement landmarkAddress;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_bottom_tertiary")
    public WebElement landmarkItenary;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_bottom_speed")
    public WebElement landmarkSpeed;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/layoutDirections")
    public WebElement directionBtn;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/layoutLMCheck")
    public WebElement lmCheckBtn;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/layoutCall")
    public WebElement callBtn;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/iv_close")
    public WebElement closeBtn;

    @AndroidFindBy(xpath = "//[content-desc='MARKER_GEOZONE.']")
    public WebElement marker_Zone;


}
