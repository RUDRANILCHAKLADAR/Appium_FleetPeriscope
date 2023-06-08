package AppiumAutomation;

import Android.AlertsPage;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AlertsTestCases extends BaseClass
{


   // C21287  Verify Alerts screen UI
    //C102181 Tap on any alert list item
    //C147073 Tap on Filter icon
    @Test(priority = 0)
    public void testAlertsScreenUIVerification() throws InterruptedException {
        alertsPage.getSignIn().click();
        alertsPage.getUsername().sendKeys("Fleet360A");
        alertsPage.getPassword().sendKeys("Password@1");
        alertsPage.getSignIn().click();
        alertsPage.Click_Permission();

        alertsPage.ClickAlerts_icon();
      //  Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());


        Assert.assertTrue(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]")).isDisplayed());

        Assert.assertEquals(alertsPage.getAlert_Title_text(),alertsPage.Alert_Title);
        Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());

        List<WebElement> AlertList = driver.findElements(By.id("com.spireon.fleet.staging:id/ll_item"));
        AlertList.get(0).click();
        Thread.sleep(3000);
        alertsPage.ClickBack();

        Assert.assertTrue(alertsPage.getFilter_icon().isEnabled());
        alertsPage.Click_filter();
        Assert.assertEquals(alertsPage.getFilter_text(),alertsPage.filter_text);
        alertsPage.ClickBack();


    }


    //C22123 Verify proper message is shown while loading alerts when network fails
    //C22124 Tapping on retry option network call should happen
    //C21297 Verify pull down to refresh functionality
    @Test(priority = 1)
    public void testAlertsScreenNetworkVerificaton() throws InterruptedException {



        alertsPage.Click_HomeScreen_icon();
        driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());
        alertsPage.ClickAlerts_icon();
        Thread.sleep(3000);
        Assert.assertEquals(alertsPage.getNetwork_Error_Msg(),alertsPage.network_msg);
        driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled().build());
        alertsPage.ClickRetry();
        List<WebElement> AlertList = driver.findElements(By.id("com.spireon.fleet.staging:id/ll_item"));
        Assert.assertFalse(AlertList.isEmpty());

       Thread.sleep(3000);

        pullToRefresh();

    }

    //C103327 Verify alert filter has categories like safety/Productivity/Monitoring/Asset health
    @Test(priority = 2)
    public void testAlertFilterCategoriesVerification() throws InterruptedException {



        alertsPage.Click_filter();
        Thread.sleep(2000);


        List<WebElement> FilterCategoriesList = driver.findElements(By.id("com.spireon.fleet.staging:id/tv_filter_type"));
        Assert.assertTrue(FilterCategoriesList.get(0).getText().contains(alertsPage.safety));
        Assert.assertTrue(FilterCategoriesList.get(1).getText().contains(alertsPage.prod));
        Assert.assertTrue(FilterCategoriesList.get(2).getText().contains(alertsPage.monitor));
        Thread.sleep(2000);
        String as = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Asset Health (5)\"));")).getText();
        Assert.assertTrue(as.contains(alertsPage.asset));
        alertsPage.ClickBack();

    }


    //C103323 Verify Safety categories in Alerts Filter screen
    //C103324 Verify Productivity categories in Alerts Filter screen
    //C103325 Verify Monitoring categories in Alerts Filter screen
    //C103326 Verify Asset health categories in Alerts Filter screen
    @Test(priority = 3)
    public void testSafetyFilterVerfication() throws InterruptedException {



        alertsPage.Click_filter();
        Thread.sleep(2000);


       List<WebElement> FilterList = driver.findElements(By.id("com.spireon.fleet.staging:id/material_drawer_name"));
        Assert.assertTrue(FilterList.get(0).getText().contains(alertsPage.safety1));
        Assert.assertTrue(FilterList.get(1).getText().contains(alertsPage.safety2));
        Assert.assertTrue(FilterList.get(2).getText().contains(alertsPage.safety3));
        Assert.assertTrue(FilterList.get(3).getText().contains(alertsPage.safety4));
        Assert.assertTrue(FilterList.get(4).getText().contains(alertsPage.safety5));
        Assert.assertTrue(FilterList.get(5).getText().contains(alertsPage.productivity1));
        Assert.assertTrue(FilterList.get(6).getText().contains(alertsPage.productivity2));
        Assert.assertTrue(FilterList.get(7).getText().contains(alertsPage.productivity3));
        Assert.assertTrue(FilterList.get(8).getText().contains(alertsPage.productivity4));
        Assert.assertTrue(FilterList.get(9).getText().contains(alertsPage.monitor1));
        Assert.assertTrue(FilterList.get(10).getText().contains(alertsPage.monitor2));


        Assert.assertEquals( driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Low Battery\"));")).getText(),alertsPage.asset1);
        Assert.assertEquals( driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Maintenance\"));")).getText(),alertsPage.asset2);
        Assert.assertEquals( driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tire Pressure\"));")).getText(),alertsPage.asset3);
        Assert.assertEquals( driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Engine Oil Life\"));")).getText(),alertsPage.asset4);
        Assert.assertEquals( driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"DTC Alert\"));")).getText(),alertsPage.asset5);

    }

}
