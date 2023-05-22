package AppiumAutomation;

import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MapScreenTestCases extends BaseClass
{

    @Test
      public void UIElementsValidation()
      {
          mapScreenPage.getSignIn().click();
          mapScreenPage.getUsername().sendKeys("Fleet360A");
          mapScreenPage.getPassword().sendKeys("Password@1");
          mapScreenPage.getSignIn().click();
          mapScreenPage.Click_Permission();

          Assert.assertTrue(mapScreenPage.getHomeScreen_icon().isSelected());
          Assert.assertTrue(mapScreenPage.getAccount_icon().isEnabled());
          Assert.assertTrue(mapScreenPage.getHomeScreen_icon().isEnabled());
          Assert.assertTrue(mapScreenPage.getAccount_icon().isEnabled());
          Assert.assertTrue(mapScreenPage.getLandmarks_icon().isEnabled());
          Assert.assertTrue(mapScreenPage.getVehicles_icon().isEnabled());
      }

      @Test
      public void UIScreenMatchingZeplinComps() throws InterruptedException {
          mapScreenPage.getSignIn().click();
          mapScreenPage.getUsername().sendKeys("Fleet360A");
          mapScreenPage.getPassword().sendKeys("Password@1");
          mapScreenPage.getSignIn().click();
          mapScreenPage.Click_Permission();

          Thread.sleep(2000);
          Assert.assertEquals(mapScreenPage.getFL_text(),mapScreenPage.fl_text);
          Assert.assertTrue(mapScreenPage.getSearch_icon().isEnabled());
          Assert.assertTrue(mapScreenPage.getRefresh_btn().isEnabled());
          Assert.assertTrue(mapScreenPage.getMoving_tab().isEnabled());
          Assert.assertTrue(mapScreenPage.getStopped_tab().isEnabled());
          Assert.assertTrue(mapScreenPage.getIdle_tab().isEnabled());
          Assert.assertTrue(mapScreenPage.getSettings_button().isEnabled());
          Assert.assertTrue(mapScreenPage.getFab_map().isEnabled());
          Assert.assertTrue(mapScreenPage.getFabcurrent_location().isEnabled());
      }




      @Test
      public void EntryMapScreen()
      {
          mapScreenPage.getSignIn().click();
          mapScreenPage.getUsername().sendKeys("Fleet360A");
          mapScreenPage.getPassword().sendKeys("Password@1");
          mapScreenPage.getSignIn().click();
          mapScreenPage.Click_Permission();

          Assert.assertTrue(mapScreenPage.getMap().isDisplayed());
          Assert.assertTrue(mapScreenPage.getAsset1().isDisplayed());
          Assert.assertTrue(mapScreenPage.getLandmark1().isDisplayed());
      }

      @Test
      public void LandmarksSelectionVerification() throws InterruptedException {
          mapScreenPage.getSignIn().click();
          mapScreenPage.getUsername().sendKeys("Fleet360A");
          mapScreenPage.getPassword().sendKeys("Password@1");
          mapScreenPage.getSignIn().click();
          mapScreenPage.Click_Permission();

          Thread.sleep(4000);

          mapScreenPage.ClickLandmark2_tag();
          Assert.assertEquals(mapScreenPage.getLandmark2_Popup_Title(),mapScreenPage.Pop_upTitle);
          mapScreenPage.ClickLandmark2_Popup_Close();
          Assert.assertTrue(mapScreenPage.getHomeScreen_icon().isDisplayed());

      }

      @Test
      public  void  VehicleDisplayVerification() throws InterruptedException {
          mapScreenPage.getSignIn().click();
          mapScreenPage.getUsername().sendKeys("Fleet360A");
          mapScreenPage.getPassword().sendKeys("Password@1");
          mapScreenPage.getSignIn().click();
          mapScreenPage.Click_Permission();

          Thread.sleep(2000);
          Assert.assertTrue(mapScreenPage.getVehicle1item().isDisplayed());
          Assert.assertTrue(mapScreenPage.getVehicle1item().isEnabled());
          mapScreenPage.getVehicle1();
          Assert.assertTrue(mapScreenPage.Vehile1PopupText().isDisplayed());
          Assert.assertEquals(mapScreenPage.getVehicle1PopupTitle(),mapScreenPage.Vehicle1Pop_up);
          mapScreenPage.Vehile1PopupText().click();
          Assert.assertEquals(mapScreenPage.getDetails_tabText(),mapScreenPage.details);
          mapScreenPage.ClickBack();
          mapScreenPage.ClickVehicle1_Close();
          Assert.assertTrue(mapScreenPage.getHomeScreen_icon().isDisplayed());
      }

      @Test
       public void SearchBarFunctionalitiesVerification() throws InterruptedException {
           mapScreenPage.getSignIn().click();
           mapScreenPage.getUsername().sendKeys("Fleet360A");
           mapScreenPage.getPassword().sendKeys("Password@1");
           mapScreenPage.getSignIn().click();
           mapScreenPage.Click_Permission();

           Thread.sleep(2000);
           mapScreenPage.ClickSearchIcon();
           Assert.assertTrue(mapScreenPage.getSearch_bar().isEnabled());
           Assert.assertEquals(mapScreenPage.getSearchBar_Text(),mapScreenPage.searchbartext);

       }

     @Test
    public void SpeedInfoVerificationforMovingandStoppedVehilces() throws InterruptedException {
        mapScreenPage.getSignIn().click();
        mapScreenPage.getUsername().sendKeys("Fleet360A");
        mapScreenPage.getPassword().sendKeys("Password@1");
        mapScreenPage.getSignIn().click();
        mapScreenPage.Click_Permission();

        Thread.sleep(2000);
        mapScreenPage.ClickVehicleicon();
        mapScreenPage.ClickMoving_tab();
        mapScreenPage.ClickMovingVehicle1();
        Assert.assertEquals(mapScreenPage.getVehicleSpeed(),mapScreenPage.vehiclespeed);
        mapScreenPage.getBack2();
        mapScreenPage.ClickMoving_tab();
        mapScreenPage.ClickStopped_tab();
        mapScreenPage.ClickStoppedVehicle1();
        Assert.assertEquals(mapScreenPage.getStoppedVehicleSpeed(),mapScreenPage.stoppedvehiclespeed);
        Assert.assertEquals(mapScreenPage.VehicleDurationText(),mapScreenPage.vehicledurationtext);
    }

    @Test
     public void ClickingMapSettingswhileNWoff() throws InterruptedException {
         mapScreenPage.getSignIn().click();
         mapScreenPage.getUsername().sendKeys("Fleet360A");
         mapScreenPage.getPassword().sendKeys("Password@1");
         mapScreenPage.getSignIn().click();
         mapScreenPage.Click_Permission();

         Thread.sleep(2000);
         mapScreenPage.Clicksettings_button();
         driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());
         Assert.assertTrue(mapScreenPage.getPopup1().isDisplayed());
         driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled().build());
     }


}

