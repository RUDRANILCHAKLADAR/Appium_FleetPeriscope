package pageobjects;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreenPage  extends BasePage {
    public HomeScreenPage(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Home")
   @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_home")
    public WebElement homeIcon;

    @iOSXCUITFindBy(accessibility = "AnnotationContainer")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/f_map")
    public WebElement map;

    @iOSXCUITFindBy(accessibility = "detail")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/fabStack")
     public WebElement settingButton;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/fab_map")
    public WebElement fabMap;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/fab_current_location")
    public WebElement fabCurrentLocation;


    @AndroidFindBy(accessibility = "Refresh")
    public WebElement refreshButton;

    @iOSXCUITFindBy(accessibility = "Search")
    @AndroidFindBy(accessibility = "Search")
    public WebElement searchIcon;



    @iOSXCUITFindBy(accessibility = "Tracking")
    public WebElement trackingIcon;

    @iOSXCUITFindBy(accessibility = "assetsIcon")
    public WebElement assetsIcon;

    @iOSXCUITFindBy(accessibility = "landmarksIcon")
    public WebElement landmarkIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Periscope']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Periscope\"")
    public WebElement homeTitleText;

    public String getHomeTitleText()
    {
        return homeTitleText.getText();
    }
    public WebElement getLandmarkIcon()
    {
        return landmarkIcon;
    }

    public WebElement getAssetsIcon()
    {
        return assetsIcon;
    }

    public WebElement getTrackingIcon()
    {
        return trackingIcon;
    }




    public WebElement getRefreshButton()
    {
        return refreshButton;
    }
    public WebElement getSearchIcon()
    {
        return searchIcon;
    }

    public WebElement getFabMap()
    {
        return fabMap;
    }

    public WebElement getFabCurrentLocation()
    {
        return fabCurrentLocation;
    }


    public WebElement getSettingButton()
    {
        return settingButton;
    }
    public WebElement getMap()
    {
        return map;
    }

    public String homeTitle="Periscope";


}
