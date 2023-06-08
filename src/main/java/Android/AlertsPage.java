package Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

    AndroidDriver driver;

    public AlertsPage(AndroidDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/bt_sign_in")
    private WebElement SignIn;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/ed_username")
    private WebElement Username;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/ed_password")
    private WebElement Password;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
     private WebElement Alert_Title_text;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_filter_alerts")
    private WebElement Filter_icon;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/rv_filters")
    private WebElement Total_itemsCount;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]")
    private WebElement Alert_List;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement permission_access;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_alerts")
    private WebElement Alerts_icon;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"MARKER_GEOZONE.\"])[17]")
    private WebElement Alert1;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement Back;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.TextView")
    private WebElement Filters_Text;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/snackbar_text")
    private WebElement Network_Error_Msg;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/snackbar_action")
    private WebElement Retry;
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/bb_bottom_bar_icon")
    private WebElement HomeScreen_icon;

    public String safety="Safety (5)";
    public String prod="Productivity (4)";
    public String monitor="Monitoring (2)";
    public String asset="Asset Health (5)";




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
    public void ClickAlert1()
    {
        Alert1.click();
    }

    public void ClickAlerts_icon()
    {
        Alerts_icon.click();
    }


    public WebElement getSignIn()
    {
        return SignIn;
    }
    public WebElement getUsername()
    {
        return Username;
    }
    public WebElement getPassword()
    {
        return Password;
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

    public void Click_Permission()
    {
        permission_access.click();
    }


}
