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
    @AndroidFindBy(xpath = "//*[contains(@text,'In LM')]" )//android.widget.TextView[@text='In LM']
    public WebElement LMIcon;

    @iOSXCUITFindBy(accessibility = "Filter-Not in LM")
    @AndroidFindBy(xpath = "//*[contains(@text,'Not In LM')]")//android.widget.TextView[@text='Not In LM']
    public WebElement notLMIcon ;

    @iOSXCUITFindBy(accessibility = "Filter-Non-Reporting")
    @AndroidFindBy(xpath = "//*[contains(@text,'Non Reporting')]")//android.widget.TextView[@text='Non Reporting']
    public WebElement notReportingIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='nextArrowVehilceList']")
    public WebElement arrowIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='truck1']")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/iv_vehicle_icon')]")
    public WebElement vehicleIcon;

    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Total ('")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_details")
    public WebElement totalCount;

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

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Filter_text'")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_filter_title")
    public List<WebElement> filterTitleList;

    @iOSXCUITFindBy(accessibility = "Refresh")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/refresh")
    public WebElement refreshBtn;


    @iOSXCUITFindBy(accessibility = "No vehicles found")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_no_assets")
    private WebElement noAssetsFound;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'vehicle_name'")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_vehicle_name")
    public List<WebElement> vehicleName;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'vehicle_status'")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_vehicle_status")
    public List<WebElement> vehicleStatus;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/title")
    public List<WebElement> vehicleStatusDetails;


    @iOSXCUITFindBy(iOSNsPredicate = "name == 'vehicle_address'")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_vehicle_address")
    public List<WebElement> vehicleAddress;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_bottom_tertiary")
    private WebElement vehicleStatusMap;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/icon_right")
    public List<WebElement> icon;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/icon_right")
    public WebElement mapIcon;

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





    public WebElement getMapIcon()
    {
        return mapIcon;
    }

    public List<WebElement> getVehicleName() {
        return vehicleName;
    }

    public WebElement getVehicleStatusMap()
    {
        return vehicleStatusMap;
    }
    public List<WebElement> getIcon() {
        return icon;
    }

    public List<WebElement> getVehicleAddress() {
        return vehicleAddress;
    }
    public List<WebElement> getVehicleStatusDetails() {
        return vehicleStatusDetails;
    }

    public List<WebElement> getVehicleStatus() {
        return vehicleStatus;
    }
    public WebElement getNoAssetsFound(){
        return noAssetsFound;
    }

    public void getSearch_icon()
    {
        searchIcon.click();
    }


    public void Click_filter()
    {
        filterOption.click();
    }

    public WebElement getRefreshBtn(){
        return refreshBtn;
    }

    public List<WebElement> getFilterTitleList() {
        return filterTitleList;
    }


    public WebElement getVehicleTitle(){
        return vehicleTitle;
    }



    public WebElement getVehicleLists()
    {
        return vehicleLists;

    }

    public WebElement searchFld() {
        return searchField;
    }


    public WebElement getTotalCount()
    {
        return totalCount;
    }
    public WebElement getNotLMIcon()
    {
        return notLMIcon;
    }


    public WebElement getLMIcon()
    {
        return LMIcon;
    }
    public WebElement getNotReportingIcon()
    {
        return notReportingIcon;
    }


    public String moving="Moving";
    public String stopped="Stopped";
    public String inLandmark ="In LM";
    public String outofLandmark ="Not In LM";

    public String idle ="Idle";
    public String noAssets ="No vehicles found";
    public String nonReporting ="Non Reporting";
    public String neverReported ="never reported";
    public String Null="--";
}
