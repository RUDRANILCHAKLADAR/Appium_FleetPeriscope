package Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MapScreenPage
{
    AndroidDriver driver;

    public MapScreenPage (AndroidDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]")
    private WebElement Map;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"MARKER_ASSET.\"])[6]")
    private WebElement Asset1;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"MARKER_GEOZONE.\"])[9]")
    private WebElement Landmark1;

//    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"MARKER_GEOZONE.\"])[20]")
//    private WebElement Landmark2;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"MARKER_GEOZONE.\"])[2]")
    private WebElement Landmark2_tag;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_bottom_title")
    private WebElement Landmark2_Popup_Title;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/iv_close")
    private WebElement Landmark2_Popup_Close;


    @AndroidFindBy(id = "com.spireon.fleet.staging:id/bt_sign_in")
    private WebElement SIGNIN;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/ed_username")
    private WebElement Username;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/ed_password")
    private WebElement Password;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView")
    private WebElement HomeScreen_icon;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_vehicles")
    private WebElement Vehicles_icon;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.ImageView")
    private WebElement landmarks_icon;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ImageView")
    private WebElement alerts_icon;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView")
    private WebElement account_icon;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement permission_access;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"MARKER_ASSET.\"])[1]")
    private WebElement Vehicle1;
    //(//android.view.View[@content-desc="MARKER_ASSET."])[1]

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_bottom_secondary")
    private WebElement Vehicle1_PopupTitle;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/iv_close")
    private WebElement Vehicle1_Close;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_search_map")
    private WebElement Search_icon;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/search_src_text")
    private WebElement Search_bar;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Details\"]/android.widget.TextView")
    private WebElement Details_tab;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_filter_title")
    private WebElement Moving_tab;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_filter_title")
    private WebElement Stopped_tab;

    @AndroidFindBy(xpath = "com.spireon.fleet.staging:id/tv_filter_title")
    private WebElement Idle_tab;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")
    private WebElement Back;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")
    private WebElement Back2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView[1]")
    private WebElement MovingVehicle1;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"MARKER_GEOZONE.\"])[4]")
    private WebElement StoppedVehicle1;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/title_suffix")
    private WebElement  VehicleSpeed;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/title_suffix")
    private WebElement  StoppedVehicleSpeed;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    private WebElement StoppedVehicleDuration;


    @AndroidFindBy(id = "com.spireon.fleet.staging:id/fabStack")
    private WebElement  Settings_button;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout")
    private WebElement Popup1;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    private WebElement FL_text;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_refresh")
    private WebElement  Refresh_btn;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/fab_map")
    private WebElement fab_map ;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/fab_current_location")
    private WebElement fabcurrent_location;


    public WebElement getIdle_tab() {
        return Idle_tab;
    }

    public WebElement getFabcurrent_location() {
        return fabcurrent_location;
    }

    public WebElement getFab_map() {
        return fab_map;
    }

    public WebElement getRefresh_btn()
    {
        return Refresh_btn;
    }
    public String  getFL_text()
    {
        return FL_text.getText();
    }
    public String fl_text="FL Periscope";
    public WebElement getPopup1()
    {
        return Popup1;
    }

    public WebElement getSettings_button() {
        return Settings_button;
    }

    public void Clicksettings_button()
    {
        Settings_button.click();
    }

    public String VehicleDurationText()
    {
       return  StoppedVehicleDuration.getText();
    }
    public String vehicledurationtext="Stopped for 6h 12m";


    public WebElement getMoving_tab() {
        return Moving_tab;
    }

    public WebElement getStopped_tab() {
        return Stopped_tab;
    }

    public void  ClickStopped_tab()
    {
        Stopped_tab.click();
    }
    public void getBack2()
    {
        Back2.click();
    }

    public String getVehicleSpeed()
    {
         return VehicleSpeed.getText();
    }

    public String getStoppedVehicleSpeed()
    {
        return StoppedVehicleSpeed.getText();
    }
    public String stoppedvehiclespeed="(0 mph) SW";

    public String vehiclespeed="(43 mph) W";
    public void  ClickMovingVehicle1()
    {
        MovingVehicle1.click();
    }

    public void  ClickStoppedVehicle1()

    {
        StoppedVehicle1.click();
    }


    public void  ClickMoving_tab()
    {
         Moving_tab.click();
    }
    public WebElement  getDetails_tab()
    {
        return Details_tab;
    }

    public WebElement  getBack()
    {
        return Back;
    }

    public void ClickBack(){
        Back.click();
    }

    public String  getDetails_tabText()
    {
        return Details_tab.getText();
    }
    public String details="DETAILS";
    public WebElement  getSearch_icon()
    {
        return Search_icon;
    }

    public void ClickSearchIcon()
    {
        Search_icon.click();
    }

    public WebElement getSearch_bar()
    {
       return Search_bar;
    }

    public String  getSearchBar_Text()
    {
        return Search_bar.getText();
    }
public String  searchbartext="   Search vehicles";
    public WebElement  Vehile1PopupText()
    {
        return Vehicle1_PopupTitle;
    }

    public String getVehicle1PopupTitle()
    {
         return Vehicle1_PopupTitle.getText();
    }
      public String  Vehicle1Pop_up="International Dr, Tysons, VA, 22102";
    public void ClickVehicle1_Close()
    {
        Vehicle1_Close.click();
    }
    public WebElement getVehicle1item()
    {
        return Vehicle1;
    }
          public void getVehicle1()
          {
             Vehicle1.click();
         }
//    public WebElement getLandmark2()
//    {
//        return  Landmark2;
//    }
//
//    public void ClickLandmark2()
//    {
//        Landmark2.click();
//    }
    public  WebElement getLandmark2_tag()
    {
        return Landmark2_tag;
    }
    public void ClickLandmark2_tag()
    {
        Landmark2_tag.click();
    }

    public String getLandmark2_Popup_Title()
    {
        return  Landmark2_Popup_Title.getText();
    }
    public String Pop_upTitle="mapLMADD";

    public WebElement getLandmark2_Popup_Close()
    {
        return  Landmark2_Popup_Close;
    }
    public  void ClickLandmark2_Popup_Close()
    {
        Landmark2_Popup_Close.click();
    }
    public WebElement getMap()
    {
        return Map;
    }

    public WebElement getAsset1()
    {
        return Asset1;
    }

    public WebElement getLandmark1()
    {
        return Landmark1;
    }
    public WebElement getSignIn()
    {
        return SIGNIN;
    }
    public WebElement getUsername()
    {
        return Username;
    }
    public WebElement getPassword()
    {
        return Password;
    }
    public WebElement getPermission_access()
    {
        return permission_access;
    }

    public void Click_Permission()
    {
        permission_access.click();
    }
    public WebElement getHomeScreen_icon()
    {
        return HomeScreen_icon;
    }

    public WebElement getAccount_icon()
    {
        return account_icon;
    }

    public WebElement getVehicles_icon()
    {
        return Vehicles_icon;
    }
    public void ClickVehicleicon()
    {
        Vehicles_icon.click();
    }

    public WebElement getLandmarks_icon()
    {
        return landmarks_icon;
    }

    public WebElement getAlerts_icon()
    {
        return alerts_icon;
    }
}
