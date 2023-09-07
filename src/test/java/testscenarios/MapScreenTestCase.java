package testscenarios;

import org.testng.ITestContext;
import pageobjects.MapScreenPage;
//import org.checkerframework.checker.units.qual.A;
import core.testrail.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import core.testrail.TestUtils;
import core.testrail.Constants;

public class MapScreenTestCase extends BaseTest {

    private MapScreenPage mapScreenPage;

    @Override
    protected void init(ITestContext context) {
        mapScreenPage = new MapScreenPage(getDriver());
    }

    @Override
    protected void deInit() {

    }

    //    C21231 Verify user is able to tap on landmarks icon, vehicles icon, alerts icon and, accounts icon on the bottom tab bar
    //C21229 Verify by default, the Home button is selected in the bottom tab bar
    @Test(priority = 0)
    public void UIElementsValidation() throws InterruptedException {

        TestUtils.logInUser(mapScreenPage, getDriver(), "Fleet360A", "Password@1",this);

        Assert.assertTrue(mapScreenPage.getHomeScreenIcon().isSelected());

        Assert.assertTrue(mapScreenPage.getAccountIcon().isEnabled());
        mapScreenPage.getAccountIcon().click();
        Assert.assertEquals(mapScreenPage.getAccountsText(), mapScreenPage.accountText);
        mapScreenPage.getHomeScreenIcon().click();


        Assert.assertTrue(mapScreenPage.getHomeScreenIcon().isEnabled());

        Assert.assertTrue(mapScreenPage.getAlerts_icon().isEnabled());
        mapScreenPage.getAlerts_icon().click();
        Assert.assertEquals(mapScreenPage.getAlerts_text(), mapScreenPage.alert_txt);


        WebElement Landmarks_icon = getDriver().findElement(By.id("com.spireon.fleet.staging:id/action_landmarks"));
        Landmarks_icon.click();
        WebElement Landmarks_text = getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"));
        Assert.assertEquals(Landmarks_text.getText(), mapScreenPage.Land_text);

        WebElement Vehicle_icon = getDriver().findElement(By.id("com.spireon.fleet.staging:id/action_vehicles"));
        Vehicle_icon.click();
        WebElement vehicle_text = getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"));
        Assert.assertEquals(vehicle_text.getText(), mapScreenPage.Veh_txt);
        mapScreenPage.getHomeScreenIcon().click();


//       Assert.assertTrue(mapScreenPage.getLandmarks_icon().isEnabled());
//        mapScreenPage.getLandmarks_icon().click();
        //  Assert.assertEquals(mapScreenPage.getLandmarks_text(),mapScreenPage.Land_text);

//        Assert.assertTrue(mapScreenPage.getVehicle_icon().isEnabled());
//        mapScreenPage.getVehicle_icon().click();
//        Assert.assertEquals(mapScreenPage.getVehicles_text(),mapScreenPage.vehicle_text);

    }

    //C21327 Verify map screen UI with Zeplin comps
    @Test(priority = 1)
    public void UIScreenMatchingZeplinComps() throws InterruptedException {
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.getUsername().sendKeys("Fleet360A");
//        mapScreenPage.getPassword().sendKeys("Password@1");
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.Click_Permission();

        //  Thread.sleep(2000);
        WebElement fl_text = getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"));
        String FL_txt = fl_text.getText();
        Assert.assertEquals(FL_txt, Constants.ANDROID_HOME_SCREEN_TITLE);

        WebElement search_icon = getDriver().findElement(By.xpath("//android.widget.Button[@content-desc=\"Search\"]"));
        Assert.assertTrue(search_icon.isEnabled());

        WebElement Refresh_btn = getDriver().findElement(By.id("com.spireon.fleet.staging:id/action_refresh"));
        Assert.assertTrue(Refresh_btn.isEnabled());

        WebElement Moving_Tab = getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView"));
        Assert.assertTrue(Moving_Tab.isEnabled());

        WebElement Stopped_tab = getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView"));
        Assert.assertTrue(Stopped_tab.isEnabled());

        WebElement Idle_tab = getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.TextView"));
        Assert.assertTrue(Idle_tab.isEnabled());

        WebElement Settings_button = getDriver().findElement(By.id("com.spireon.fleet.staging:id/fabStack"));
        Assert.assertTrue(Settings_button.isEnabled());

        WebElement Fab_map = getDriver().findElement(By.id("com.spireon.fleet.staging:id/fab_map"));
        Assert.assertTrue(Fab_map.isEnabled());

        WebElement Fabcurrent_location = getDriver().findElement(By.id("com.spireon.fleet.staging:id/fab_current_location"));
        Assert.assertTrue(Fabcurrent_location.isEnabled());

        //with string appium is not working..need to check with developer
        // driver.findElement(By.name ("FL Periscope")).isDisplayed();
        //Assert.assertEquals(mapScreenPage.getFL_text(),mapScreenPage.fl_text);
        //  Assert.assertTrue(mapScreenPage.getSearch_icon().isEnabled());
        //    Assert.assertTrue(mapScreenPage.getRefresh_btn().isEnabled());
//        Assert.assertTrue(mapScreenPage.getMoving_tab().isEnabled());
//        Assert.assertTrue(mapScreenPage.getStopped_tab().isEnabled());
//        Assert.assertTrue(mapScreenPage.getIdle_tab().isEnabled());
//        Assert.assertTrue(mapScreenPage.getSettings_button().isEnabled());
//        Assert.assertTrue(mapScreenPage.getFab_map().isEnabled());
//        Assert.assertTrue(mapScreenPage.getFabcurrent_location().isEnabled());
    }

    //C19230 Verify that after successful login, the user is landing on the map screen, and by default, the map zoom level for users entering the mobile app shows all of the assets and landmarks on the screen.
    //C24393  Verify asset name and asset marker shows correctly
    @Test(priority = 2)
    public void EntryMapScreen() {
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.getUsername().sendKeys("Fleet360A");
//        mapScreenPage.getPassword().sendKeys("Password@1");
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.Click_Permission();

        Assert.assertTrue(mapScreenPage.getMap().isDisplayed());
        Assert.assertTrue(mapScreenPage.getAsset1().isDisplayed());
        Assert.assertTrue(mapScreenPage.getLandmark1().isDisplayed());
    }


    //C21453 Tap on Map settings
    //C83101 Verify by default landmarks is ON in the Map settings screen
    @Test(priority = 3)
    public void MapSettingsDisplayVerification() {
//         mapScreenPage.getSignIn().click();
//        mapScreenPage.getUsername().sendKeys("Fleet360A");
//        mapScreenPage.getPassword().sendKeys("Password@1");
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.Click_Permission();

        mapScreenPage.Clicksettings_button();
        Assert.assertTrue(mapScreenPage.getLandmarksMapDetails().isEnabled());
        Assert.assertTrue(mapScreenPage.getDefaultMapView().isDisplayed());
        Assert.assertTrue(mapScreenPage.getSatelliteMapView().isDisplayed());
        Assert.assertTrue(mapScreenPage.getAssetMapDetails().isDisplayed());
        Assert.assertTrue(mapScreenPage.getLandmarksMapDetails().isDisplayed());
        Assert.assertTrue(mapScreenPage.getTrafficMapDetails().isDisplayed());
        Assert.assertTrue(mapScreenPage.getMapSettingsClosebutton().isEnabled());
        mapScreenPage.getPopupClose().click();
    }

    //C83437 Tap on map settings when n/w is off
    @Test(priority = 4)
    public void ClickingMapSettingswhileNWoff() throws InterruptedException {
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.getUsername().sendKeys("Fleet360A");
//        mapScreenPage.getPassword().sendKeys("Password@1");
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.Click_Permission();

        Thread.sleep(2000);
        mapScreenPage.getFab_map().click();
        mapScreenPage.getFabLandmarks().click();
        Thread.sleep(2000);
        mapScreenPage.Clicksettings_button();
        TestUtils.internetOff(getDriver());
        Assert.assertTrue(mapScreenPage.getPopup1().isDisplayed());
        TestUtils.internetOn(getDriver());
        mapScreenPage.getPopupClose().click();
        mapScreenPage.getFab_map().click();
        mapScreenPage.getFabLandmarks().click();
    }


    // C19246 Verify user is able to tap on any landmarks
    // C21235 Verify user is able to close landmark info screen by clicking on Close(X) button
    @Test(priority = 5)
    public void LandmarksSelectionVerification() throws InterruptedException {
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.getUsername().sendKeys("Fleet360A");
//        mapScreenPage.getPassword().sendKeys("Password@1");
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.Click_Permission();

        Thread.sleep(4000);

        mapScreenPage.ClickLandmark2_tag();
        Assert.assertEquals(mapScreenPage.getLandmark2_Popup_Title(), mapScreenPage.Pop_upTitle);
        mapScreenPage.ClickLandmark2_Popup_Close();
        Assert.assertTrue(mapScreenPage.getHomeScreenIcon().isDisplayed());
        mapScreenPage.getFab_map().click();
        mapScreenPage.getFabLandmarks().click();

    }


    //  C21228 Verify tapping on any vehicle displays vehicle info at the bottom of the panel
    //C21234 Verify user is able to close vehicle info screen by clicking on Close(X) button
    // C21230 Verify the user is able to go to the vehicle details screen by tapping on vehicle info in the bottom panel.
    //C22580 Verify vehicle labels are visible over map
    @Test(priority = 6)
    public void VehicleDisplayVerification() throws InterruptedException {
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.getUsername().sendKeys("Fleet360A");
//        mapScreenPage.getPassword().sendKeys("Password@1");
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.Click_Permission();

        Thread.sleep(2000);
        Assert.assertTrue(mapScreenPage.getVehicle1item().isDisplayed());
        Assert.assertTrue(mapScreenPage.getVehicle1item().isEnabled());
        mapScreenPage.getVehicle1();
        Assert.assertTrue(mapScreenPage.Vehile1PopupText().isDisplayed());
        Assert.assertEquals(mapScreenPage.getVehicle1PopupTitle(), mapScreenPage.Vehicle1Pop_up);
        mapScreenPage.Vehile1PopupText().click();
        Assert.assertEquals(mapScreenPage.getDetailsTabText(), Constants.ANDROID_VEHICLES_DETAILS_TAB);
        mapScreenPage.ClickBack();
        mapScreenPage.ClickVehicle1_Close();
        Assert.assertTrue(mapScreenPage.getHomeScreenIcon().isDisplayed());

    }


    //    C19241 Verify user is able to tap on search button
    //C19969 Verify tapping on search icon in the map screen should take the user to Vehicles screen and cursor should focus on search text bar and by default it shows text "Search vehicles" on the search bar
    @Test(priority = 7)
    public void SearchBarFunctionalitiesVerification() throws InterruptedException {
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.getUsername().sendKeys("Fleet360A");
//        mapScreenPage.getPassword().sendKeys("Password@1");
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.Click_Permission();

        Thread.sleep(2000);
        mapScreenPage.ClickSearchIcon();
        Assert.assertTrue(mapScreenPage.getSearch_bar().isEnabled());
        Assert.assertEquals(mapScreenPage.getSearchBar_Text(), mapScreenPage.searchbartext);
        mapScreenPage.getback3();
        mapScreenPage.getHomeScreenIcon().click();
        mapScreenPage.getFab_map().click();
        mapScreenPage.getFabLandmarks().click();
    }


    //C82686 Verify that user is able to see stopped/idle/moving vehicle duration at the bottom (third row) of the vehicle info screen
    @Test(priority = 8)
    public void StoppedVehicleDurationDisplay() throws InterruptedException {
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.getUsername().sendKeys("Fleet360A");
//        mapScreenPage.getPassword().sendKeys("Password@1");
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.Click_Permission();

        Thread.sleep(3000);
        WebElement Stopped_tab = getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView"));
        Stopped_tab.click();
//         mapScreenPage.getStoop().click();
        Thread.sleep(3000);
        WebElement stoppedvehicle2 = getDriver().findElement(By.xpath("(//android.view.View[@content-desc=\"MARKER_ASSET.\"])[4]"));
        stoppedvehicle2.click();
        Thread.sleep(3000);
        WebElement stoppedvehicle2tag = getDriver().findElement(By.xpath("(//android.view.View[@content-desc=\"MARKER_ASSET.\"])[7]"));
        stoppedvehicle2tag.click();
        Thread.sleep(3000);
//        WebElement stoppedvehicle2title = driver.findElement(By.id("com.spireon.fleet.staging:id/tv_bottom_secondary"));
//        stoppedvehicle2title.click();
        Thread.sleep(3000);
        WebElement stoppedvehicle2info = getDriver().findElement(By.id("com.spireon.fleet.staging:id/tv_bottom_tertiary"));

        Assert.assertTrue(stoppedvehicle2info.isDisplayed());
        System.out.println(stoppedvehicle2info.getText());
        Thread.sleep(2000);

        mapScreenPage.ClickVehicle1_Close();
        mapScreenPage.getFab_map().click();
        mapScreenPage.getFabLandmarks().click();
    }


    //   C22587 Verify speed info is shown for moving vehicles on map page detail view
    @Test(priority = 9)
    public void SpeedInfoVerificationforMovingVehilces() throws InterruptedException {
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.getUsername().sendKeys("Fleet360A");
//        mapScreenPage.getPassword().sendKeys("Password@1");
//        mapScreenPage.getSignIn().click();
//        mapScreenPage.Click_Permission();

        Thread.sleep(3000);
//        WebElement clusteredElement = driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiSelector().xpath((//android.view.View[@content-desc=\"MARKER_ASSET.\"])[5])"));

        //       clusteredElement.click();
//        mapScreenPage.getMovingvehicle1().click();
//        mapScreenPage.getMovingvehicle1tag().click();


//        mapScreenPage.ClickBack();
//        mapScreenPage.ClickVehicle1_Close();
//        mapScreenPage.getFab_map().click();
//        mapScreenPage.getFab_landmarks().click();
//
        WebElement Stopped_tab = getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView"));
        Stopped_tab.click();
        Thread.sleep(3000);
        WebElement movingvehicle1 = getDriver().findElement(By.xpath("(//android.view.View[@content-desc=\"MARKER_ASSET.\"])[5]"));
        movingvehicle1.click();
        Thread.sleep(2000);
        WebElement movingvehicle1tag = getDriver().findElement(By.xpath("(//android.view.View[@content-desc=\"MARKER_ASSET.\"])[2]"));
        movingvehicle1tag.click();
        Thread.sleep(2000);
//        mapScreenPage.ClickMovingvehicle1_title();
//        Thread.sleep(2000);
        Assert.assertTrue(mapScreenPage.getMovingSpeedInfo().isDisplayed());
        mapScreenPage.ClickVehicle1_Close();
        mapScreenPage.getFab_map().click();
        mapScreenPage.getFabLandmarks().click();

    }


    //C21453 Tap on Map settings
    //C83101 Verify by default landmarks is ON in the Map settings screen


//     @Test
//     public void MapViewDisplayVerification() throws InterruptedException {
//         mapScreenPage.getSignIn().click();
//         mapScreenPage.getUsername().sendKeys("Fleet360A");
//         mapScreenPage.getPassword().sendKeys("Password@1");
//         mapScreenPage.getSignIn().click();
//         mapScreenPage.Click_Permission();
//
//         mapScreenPage.Clicksettings_button();
//         mapScreenPage.Click_SatelliteMapView();
//         Thread.sleep(3000);
//         mapScreenPage.Clicksettings_button();
//         Thread.sleep(3000);
//         Assert.assertTrue(mapScreenPage.getSatelliteMapView().isSelected());
//         Assert.assertEquals(mapScreenPage.getSatelliteMapView().getAttribute("elementId"),"true");
//         mapScreenPage.Click_DefaultMapView();
//         mapScreenPage.Clicksettings_button();
//         Assert.assertTrue(mapScreenPage.getDefaultMapView().isSelected());
//         mapScreenPage.ClickMapSettingsClosebutton();
//         signinpage.getAccount_icon().click();
//         signinpage.getLogout().click();
//         signinpage.getConfirm_btn().click();
//
//
//         mapScreenPage.getUsername().sendKeys("Fleet360A");
//         mapScreenPage.getPassword().sendKeys("Password@1");
//         mapScreenPage.getSignIn().click();
//         mapScreenPage.Click_Permission();
//
//         mapScreenPage.Clicksettings_button();
//         Assert.assertTrue(mapScreenPage.getDefaultMapView().isSelected());
//
//     }
//
//
//     @Test
//     public void ColorVerificationLandmarksONOFF() throws InterruptedException {
//         mapScreenPage.getSignIn().click();
//         mapScreenPage.getUsername().sendKeys("Fleet360A");
//         mapScreenPage.getPassword().sendKeys("Password@1");
//         mapScreenPage.getSignIn().click();
//         mapScreenPage.Click_Permission();
//
//         mapScreenPage.Clicksettings_button();
//
//         Thread.sleep(3000);
//
//         WebElement textElement = driver.findElement(By.id("com.spireon.fleet.staging:id/landmarkTv"));
//         String colorValue = textElement.getCssValue("Color");
//         System.out.println(colorValue);
//         // Verify if the color is orange
//         if (colorValue.equals("rgba(255, 165, 0, 1)") || colorValue.equals("rgb(255, 165, 0)")) {
//             System.out.println("The text is orange and Landmarks on ON");
//         } else {
//             System.out.println("The text is not orange and Landmarks is OFF");
//         }
//
//     }


}

