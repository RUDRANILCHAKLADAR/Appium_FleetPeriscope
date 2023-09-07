package pageobjects;

import core.testrail.BasePage;
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

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Periscope\"")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Periscope']")
    public WebElement homeScreenTitle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Account\"`]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Account']")
    public WebElement accountsText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Vehicles\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_vehicles")
    public WebElement vehicleBottomBar;

    @iOSXCUITFindBy(accessibility = "Filter")
    @AndroidFindBy(accessibility = "Filters")
    public WebElement filterOption;

    @iOSXCUITFindBy(accessibility = "Search")
    @AndroidFindBy(accessibility = "Search")
    public WebElement searchIcon;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/search_src_text")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Search\"")
    public WebElement searchField;



    @iOSXCUITFindBy(accessibility = "Filter-Moving")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Moving']")
    public WebElement movingIcon;

    @iOSXCUITFindBy(accessibility = "Filter-Stopped")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stopped']")
    public WebElement stopIcon;

    @iOSXCUITFindBy(accessibility = "Filter-Idle")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Idle']")
    public WebElement idleIcon;

    @iOSXCUITFindBy(accessibility = "Filter-In LM")
    @AndroidFindBy(xpath = "//*[contains(@text,'In LM')]")//android.widget.TextView[@text='In LM']
    public WebElement LMIcon;

    @iOSXCUITFindBy(accessibility = "Filter-Not in LM")
    @AndroidFindBy(xpath = "//*[contains(@text,'Not In LM')]")//android.widget.TextView[@text='Not In LM']
    public WebElement notLMIcon;

    @iOSXCUITFindBy(accessibility = "Filter-Non-Reporting")
    @AndroidFindBy(xpath = "//*[contains(@text,'Non Reporting')]")//android.widget.TextView[@text='Non Reporting']
    public WebElement notReportingIcon;




    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Total ('")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_details")
    public WebElement totalCount;



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

    @iOSXCUITFindBy(accessibility = "mapFilled")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/icon_right")
    public List<WebElement> icon;

    @iOSXCUITFindBy(accessibility = "mapFilled")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/icon_right")
    public WebElement mapIcon;

    @iOSXCUITFindBy(accessibility = "Home")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/bb_bottom_bar_icon")
    private WebElement homeScreenIcon;

    @iOSXCUITFindBy(accessibility = "Account")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_account")
    private WebElement accountIcon;

    @iOSXCUITFindBy(accessibility = "Details")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Details\"]/android.widget.TextView")
    private WebElement detailsTab;

    @iOSXCUITFindBy(accessibility = "Done")
    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement Back;

    @iOSXCUITFindBy(accessibility = "Back")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
    private WebElement detailsBack;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Filters\"")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Filters']")
    private WebElement filtersText;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Alerts - 7 Day History\"`]")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement Back2;

    @iOSXCUITFindBy(accessibility = "drawerCloseButton")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/iv_close")
    private WebElement popupClose;

    public WebElement getDetailsBack()
    {
        return detailsBack;
    }

    public void clickPopupClose() {
        popupClose.click();
    }
    public void ClickBack2() {
        Back2.click();
    }
    public void clickHomeScreenIcon()
    {
        homeScreenIcon.click();
    }
    public void clickAccountIcon()
    {
        accountIcon.click();
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

    public void getSearchIcon()
    {
        searchIcon.click();
    }


    public void clickFilter()
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
    public WebElement getMovingIcon()
    {
        return movingIcon;
    }

    public WebElement getStopIcon()
    {
        return stopIcon;
    }
    public WebElement getIdleIcon()
    {
        return idleIcon;
    }

    public WebElement getLMIcon()
    {
        return LMIcon;
    }
    public WebElement getNotReportingIcon()
    {
        return notReportingIcon;
    }
    public String getDetailsTabText() {
        return detailsTab.getText();
    }
    public void ClickBack() {
        Back.click();
    }
    public String getAccountsText() {
        return accountsText.getText();
    }


    public String getFilterText() {
        return filtersText.getText();
    }
    public WebElement getFilterTitle()
    {
        return filtersText;
    }
    public String filterText = "Filters";
    public String accountText = "Account";

    public String details = "DETAILS";

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
