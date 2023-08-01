package pageobjects;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;


public class VehiclePage extends BasePage {
    public VehiclePage(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Vehicles\"`]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Vehicles']")
    public WebElement vehicleTitle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Vehicles\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_vehicles")
    public WebElement vehicleBottomBar;

    @iOSXCUITFindBy(accessibility = "Filter")
    @AndroidFindBy(accessibility = "Filters")
    public WebElement filterOption;

    @iOSXCUITFindBy(accessibility = "Search")
    @AndroidFindBy(accessibility = "Search")
    public WebElement searchIcon;

    @AndroidFindBy(accessibility = "com.spireon.fleet.staging:id/search_edit_frame")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Search\"")
    public WebElement searchField;

    @iOSXCUITFindBy(accessibility = "Horizontal scroll bar, 2 pages")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/rv_filters')]")
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
    public WebElement notLMIcon;

    @iOSXCUITFindBy(accessibility = "Filter-Non-Reporting")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/ll_parent'][5]")
    public WebElement notReportingIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='nextArrowVehilceList']")
    public WebElement arrowIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='truck1']")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/iv_vehicle_icon')]")
    public WebElement vehicleIcon;


    @AndroidFindBy(id = "@+id/tv_details")
    public WebElement totalCntText;

    @AndroidFindBy(id = "@+id/direction")
    public WebElement direction;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/" +
            "XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    public WebElement firstVehicle;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/rcl_vehicle_list")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTable\"")
    public WebElement vehicleLists;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/card_vehicle_list")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTable\"")
    public WebElement listOfVehicles;
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/rl_list_item_base")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTable\"")
    public List<WebElement> vehicleList;

    public WebElement getVehicleTitle() {
        return vehicleTitle;
    }

    public WebElement vehicleLists() {
        return vehicleLists;
    }

    public WebElement searchField() {
        return searchIcon;
    }

    public WebElement filterOption() {
        return filterOption;
    }

    public List<WebElement> getVehicleList() {
        return vehicleList;
    }
}
