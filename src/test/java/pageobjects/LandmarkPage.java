package pageobjects;

import core.testrail.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LandmarkPage extends BasePage {

    public LandmarkPage(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Landmarks\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_landmarks")
    public WebElement landmarkBottomBarIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Landmarks\"`]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Landmarks']")
    public WebElement landmarkTitle;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/landmark_show_count")
    public WebElement landmarkTotalCnt;

    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTable\"")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/rcl_landmark_list")
    public WebElement landmarkList;




    @iOSXCUITFindBy(accessibility = "Search")
    @AndroidFindBy(accessibility = "Search")
    public WebElement searchIcon;

    @iOSXCUITFindBy(accessibility = "Filter")
    @AndroidFindBy(accessibility = "Filters")
    public WebElement filterLandmarks;

    public WebElement getFilterLandmarks()
    {
        return filterLandmarks;
    }


    public WebElement getSearchIcon()
    {
        return searchIcon;
    }

    public WebElement getLandmarkList()
    {
        return landmarkList;
    }


    public WebElement getlandmarkTotalCnt()
    {
        return landmarkTotalCnt;
    }

    public WebElement getLandmarkTitle()
    {
        return landmarkTitle;
    }
  public String landmarkText="Landmarks";

}
