package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlertsPage {

    AppiumDriver driver;

    public AlertsPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
     private WebElement Alert_Title_text;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Filter\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_filter_alerts")
    private WebElement Filter_icon;


    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_details")
    private WebElement Total_itemsCount;


    @AndroidFindBy(id = "com.spireon.fleet.staging:id/rv_alerts_list")
    public WebElement Alert_List;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Alerts\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_alerts")
    private WebElement Alerts_icon;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Alerts - 7 Day History\"`]")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement Back;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.TextView")
    private WebElement Filters_Text;


    @AndroidFindBy(id = "com.spireon.fleet.staging:id/snackbar_text")
    private WebElement Network_Error_Msg;


    @AndroidFindBy(id = "com.spireon.fleet.staging:id/snackbar_action")
    private WebElement Retry;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Home\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/bb_bottom_bar_icon")
    private WebElement HomeScreen_icon;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"No Alerts Found\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_no_alerts")
    private WebElement No_Alerts_Found;


    @AndroidFindBy(id = "com.spireon.fleet.staging:id/progress")
    private WebElement Progress_bar;



    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tvAlertAddress")
    private WebElement AddressName;

    @AndroidFindBy(id = "android:id/button2")
    private WebElement RatingPopup;


   public void  ClickRatingPopup()
   {
       RatingPopup.click();
   }


    public String safety="Safety (5)";
    public String prod="Productivity (4)";
    public String monitor="Monitoring (2)";
    public String asset="Asset Health (5)";






    @AndroidFindBy(id = "com.spireon.fleet.staging:id/material_drawer_name")
    private List<WebElement> Productivity_List;



    @AndroidFindBy(id = "com.spireon.fleet.staging:id/rv_alerts_list")
    public List<WebElement> AlertListFull;



    @AndroidFindBy(id = "com.spireon.fleet.staging:id/alertValue")
    public List<WebElement> IdlingTime;



    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_asset_name")
    public List<WebElement> IdleVehicleName;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/ll_item")
    public List<WebElement> AlertList;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_filter_type")
    public List<WebElement> FilterCategoriesList;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/material_drawer_name")
    public List<WebElement> FilterList;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_alert_name")
    public List<WebElement> AlertName;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/alertSubValue")
    public List<WebElement> SubValue;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_time")
    public List<WebElement> AlertTime;

    public List<WebElement> getSubValue(){
        return SubValue;
    }
    public List<WebElement> getAlertTime(){
        return AlertTime;
    }



    public WebElement getAddressName()
    {
        return AddressName;
    }
    public WebElement getProgress_bar()
    {
        return Progress_bar;
    }

    public WebElement getNo_Alerts_Found()
     {
         return No_Alerts_Found;
     }

    public String getNo_Alerts_Found_Msg()
    {
        return No_Alerts_Found.getText();
    }
    public String Alert_Msg="No Alerts found";




    public List<WebElement> getFilterList(){
        return FilterList;
    }


    public List<WebElement> getAlertName(){
        return AlertName;
    }
    public List<WebElement> getFilterCategoriesList(){
        return FilterCategoriesList;
    }
    public List<WebElement> getAlertList(){
        return AlertList;
    }
    public List<WebElement> getAlertVehicleTime(){
        return IdlingTime;
    }
    public List<WebElement> getAlertVehicleName(){
        return IdleVehicleName;
    }

    public List<WebElement> getProductivity_List(){
        return Productivity_List;
    }

    public List<WebElement> getAlertListFull(){
        return AlertListFull;
    }

    public void Click_HomeScreen_icon()
    {
         HomeScreen_icon.click();
    }

    public String safety1="Hard Braking and Hard Acceleration";
    public String safety2="Odd Hours";
    public String safety3="Posted Speed Limit";
    public String safety4="Speed Threshold";
    public String safety5="Unauthorized Movement";

    public String productivity1="Idle";
    public String productivity2="Stop";
    public String productivity3="Input";
    public String productivity4="Landmark Arrival and Departure";

    public String monitor1="Fuel Tank";
    public String monitor2="Temperature";

    public String asset1="Low Battery";
    public String asset2="Maintenance";
    public String asset3="Tire Pressure";
    public String asset4="Engine Oil Life";
    public String asset5="DTC Alert";


    public WebElement getNetwork_Error()
    {
        return  Network_Error_Msg;
    }


    public String getNetwork_Error_Msg()
    {
       return  Network_Error_Msg.getText();
    }

    public String network_msg="Please check your network connection and try again.";

    public void ClickRetry()
    {
         Retry.click();
    }
    public String getFilter_text()
    {
        return Filters_Text.getText();
    }

    public String filter_text="Filters";

    public void ClickBack()
    {
        Back.click();
    }
    public WebElement Back()
    {
        return Back;
    }

    public void ClickAlerts_icon()
    {
        Alerts_icon.click();
    }



    public String  getAlert_Title_text()
    {
        return Alert_Title_text.getText();
    }
    public String  Alert_Title="Alerts - 7 Day History";

    public WebElement getFilter_icon()
    {
        return Filter_icon;
    }

    public void Click_filter()
    {
        Filter_icon.click();
    }

    public WebElement getAlert_List()
    {
        return Alert_List;
    }

    public WebElement getTotal_itemsCount()
    {
        return Total_itemsCount;
    }

    public void DismissAppRatingPopup()
    {
        ClickRatingPopup();
        ClickRatingPopup();
    }


}
