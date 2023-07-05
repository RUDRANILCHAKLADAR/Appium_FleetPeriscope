package android;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class vehiclePage {

    public AppiumDriver driver;

    public vehiclePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Vehicles\"`]")
    @AndroidFindBy(xpath="//[@text='Vehicles']")
    public WebElement vehicleTitle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Vehicles\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_vehicles")
    public WebElement vehicleBottomBar;

    @iOSXCUITFindBy(accessibility = "Filter")
    @AndroidFindBy(accessibility = "Filters")
    public WebElement filterOption;

    @iOSXCUITFindBy(accessibility = "Search")
    @AndroidFindBy(accessibility = "Search")
    public WebElement searchFld;

    @iOSXCUITFindBy(accessibility = "Horizontal scroll bar, 2 pages")
    @AndroidFindBy(xpath="//[@resource-id='com.spireon.fleet.staging:id/rv_filters')]")
    public WebElement filterIcons;

    @iOSXCUITFindBy(accessibility = "Filter-Moving")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/ll_parent'][0]")
    public WebElement movingIcon;

    @iOSXCUITFindBy(accessibility = "Filter-Stopped")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/ll_parent'][1]")
    public WebElement stopIcon;

    @iOSXCUITFindBy(accessibility = "Filter-Idle")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/ll_parent'][2]")
    public WebElement idleIcon;

    @iOSXCUITFindBy(accessibility = "Filter-In LM")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/ll_parent'][3]")
    public WebElement LMIcon;

    @iOSXCUITFindBy(accessibility = "Filter-Not in LM")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/ll_parent'][4]")
    public WebElement notLMIcon ;

    @iOSXCUITFindBy(accessibility = "Filter-Non-Reporting")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/ll_parent'][5]")
    public WebElement notReportingIcon;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='nextArrowVehilceList']")
    public WebElement arrowIcon;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name='truck1']")
    @AndroidFindBy(xpath= "//[@resource-id='com.spireon.fleet.staging:id/iv_vehicle_icon')]")
    public WebElement vehicleIcon;

    //@iOSXCUITFindBy()
    @AndroidFindBy(id="@+id/tv_details")
    public WebElement totalCntText;

    @AndroidFindBy(id="@+id/direction")
    public WebElement direction;


    @AndroidFindBy(id="com.spireon.fleet.staging:id/card_vehicle_list")
    public WebElement vehicleLists;

   public WebElement getVehicleTitle(){
       return vehicleTitle;
   }

    public WebElement vehicleLists() {
       return vehicleLists;
    }

    public WebElement searchFld() {
       return searchFld;
    }

    public WebElement filterOption() {
       return filterOption;
    }
}
