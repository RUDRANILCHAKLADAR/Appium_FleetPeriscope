package AppiumAutomation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Utils;

import java.time.Duration;

public class AlertsTestCases extends BaseClass {


    // C21287  Verify Alerts screen UI
    //C102181 Tap on any alert list item
    //C147073 Tap on Filter icon
    @Test(priority = 0)
    public void testAlertsScreenUIVerification() throws InterruptedException {

        signinpage.SignIN();
        alertsPage.ClickAlerts_icon();
          Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());



        Assert.assertEquals(alertsPage.getAlert_Title_text(), alertsPage.Alert_Title);
        Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());

        alertsPage.AlertListFull.get(0).click();

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(alertsPage.Back()));
        alertsPage.ClickBack();

        Assert.assertTrue(alertsPage.getFilter_icon().isEnabled());
        alertsPage.Click_filter();
        Assert.assertEquals(alertsPage.getFilter_text(), alertsPage.filter_text);
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
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(alertsPage.getNetwork_Error()));
        Assert.assertEquals(alertsPage.getNetwork_Error_Msg(), alertsPage.network_msg);
        driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled().build());
        alertsPage.ClickRetry();

        Assert.assertFalse(alertsPage.getAlertList().isEmpty());


        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(alertsPage.getFilter_icon()));

        pullToRefresh();

    }

    //C103327 Verify alert filter has categories like safety/Productivity/Monitoring/Asset health
    @Test(priority = 2)
    public void testAlertFilterCategoriesVerification() throws InterruptedException {


        alertsPage.Click_filter();


        Assert.assertTrue(alertsPage.getFilterCategoriesList().get(0).getText().contains(alertsPage.safety));
        Assert.assertTrue(alertsPage.getFilterCategoriesList().get(1).getText().contains(alertsPage.prod));
        Assert.assertTrue(alertsPage.getFilterCategoriesList().get(2).getText().contains(alertsPage.monitor));
        String Asset_health = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Asset Health (5)\"));")).getText();
        Assert.assertTrue(Asset_health.contains(alertsPage.asset));
        alertsPage.ClickBack();

    }


    //C103323 Verify Safety categories in Alerts Filter screen
    //C103324 Verify Productivity categories in Alerts Filter screen
    //C103325 Verify Monitoring categories in Alerts Filter screen
    //C103326 Verify Asset health categories in Alerts Filter screen
    @Test(priority = 3)
    public void testSafetyFilterVerfication() throws InterruptedException {
        alertsPage.Click_filter();



        Assert.assertTrue(alertsPage.getFilterList().get(0).getText().contains(alertsPage.safety1));
        Assert.assertTrue(alertsPage.getFilterList().get(1).getText().contains(alertsPage.safety2));
        Assert.assertTrue(alertsPage.getFilterList().get(2).getText().contains(alertsPage.safety3));
        Assert.assertTrue(alertsPage.getFilterList().get(3).getText().contains(alertsPage.safety4));
        Assert.assertTrue(alertsPage.getFilterList().get(4).getText().contains(alertsPage.safety5));
        Assert.assertTrue(alertsPage.getFilterList().get(5).getText().contains(alertsPage.productivity1));
        Assert.assertTrue(alertsPage.getFilterList().get(6).getText().contains(alertsPage.productivity2));
        Assert.assertTrue(alertsPage.getFilterList().get(7).getText().contains(alertsPage.productivity3));
        Assert.assertTrue(alertsPage.getFilterList().get(8).getText().contains(alertsPage.productivity4));
        Assert.assertTrue(alertsPage.getFilterList().get(9).getText().contains(alertsPage.monitor1));
        Assert.assertTrue(alertsPage.getFilterList().get(10).getText().contains(alertsPage.monitor2));

        Assert.assertEquals(driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Low Battery\"));")).getText(), alertsPage.asset1);
        Assert.assertEquals(driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Maintenance\"));")).getText(), alertsPage.asset2);
        Assert.assertEquals(driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tire Pressure\"));")).getText(), alertsPage.asset3);
        Assert.assertEquals(driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Engine Oil Life\"));")).getText(), alertsPage.asset4);
        Assert.assertEquals(driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"DTC Alert\"));")).getText(), alertsPage.asset5);

    }

    @Test(priority =4)
    public void testProductivityFilterSelection() {

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity1) || alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity2) || alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity3) || alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity4)) {
                alertsPage.getProductivity_List().get(i).click();

            }
        }
        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity1) || alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity2) || alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity3) || alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity4)) {
                Assert.assertTrue(alertsPage.getProductivity_List().get(i).isSelected());
                alertsPage.getProductivity_List().get(i).click();
            }

        }

        alertsPage.ClickBack();
       alertsPage.DismissAppRatingPopup();
        signinpage.Logout();

    }

    @Test(priority = 9)
    public void testProductivityListDisplayVerification() throws InterruptedException {
        int k=1;
        for (int i = 0; i <alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity1) || alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity2) || alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity3) || alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity4)) {


                String filter_name=alertsPage.getProductivity_List().get(i).getText();
                alertsPage.getProductivity_List().get(i).click();

                alertsPage.ClickBack();
                if(k==1) {
                    alertsPage.ClickRatingPopup();
                    alertsPage.ClickRatingPopup();
                    k=k+1;
                }

                new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.invisibilityOf(alertsPage.getProgress_bar()));
                if(Utils.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed())
                {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(),alertsPage.Alert_Msg);
                    System.out.println("In Productivity Filter No alerts are present for " + filter_name+" filter");
                    alertsPage.Click_filter();
                    alertsPage.getProductivity_List().get(i).click();
                }
                else if(alertsPage.getAlert_List().isDisplayed())
                {
                    System.out.println("In Productivity Filter, alerts are present for " +filter_name+ " filter" );
                    alertsPage.Click_filter();
                    alertsPage.getProductivity_List().get(i).click();
                }

            }
        }


    }

//    C21456	Tap on Arrival/Departure alert on Filters screen
//	C93507	Verify tapping on any Arrival/Departure alert list item takes the user to alert details screen and shows the landmark name
//	C93508	Verify if landmark name is empty or null then we need to show the address of the alert.
//	C147174	Tap on any alert list item
//	C166386	Verify that header displays the information of the list in the following format(Ex:7-day history, Total (xxxx): Showing 1 to 50)
    @Test(priority = 5)
    public void testLandmarkArrivalandDepartureFilterVerification()
    {
        signinpage.SignIN();

        alertsPage.ClickAlerts_icon();
        alertsPage.Click_filter();

        for (int i = 0; i <alertsPage.getProductivity_List().size(); i++)
        {
            if( alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity4))
            {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();
                new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.invisibilityOf(alertsPage.getProgress_bar()));

                if (Utils.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Productivity Filter No alerts are present for " + alertsPage.productivity1 + " filter");

                }
                else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                  // System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getAttribute("text"));
                    alertsPage.getAlertListFull().get(0).click();
                    //String landmark_name=alertsPage.getLandmarkName().getText();
                    String address_name = alertsPage.getAddressName().getText();

                    // Split the sentence into words
                    String[] words = address_name.split("\n");

                    // Create an array to store the first word and the rest of the sentence
                    String[] result = new String[2];

                    // Store the first word in the first index of the array
                    result[0] = words[0];

                    // Store the rest of the sentence in the second index of the array
                    StringBuilder restOfSentence = new StringBuilder();
                    for (int j = 1; j < words.length; j++) {
                        restOfSentence.append(words[j]).append(" ");
                    }
                    result[1] = restOfSentence.toString().trim();

                    if (result[0] != null) {
                        System.out.println("The Landmark name for this alert ----" + result[0]);
                        alertsPage.ClickBack();
                    }
                    else if (result[0] == null) {
                        System.out.println("The Landmark name for this alert is not displayed or is null");
                        System.out.println("The Address name for this alert is " + result[1]);
                        alertsPage.ClickBack();
                    }
                }
                alertsPage.Click_filter();
                alertsPage.getProductivity_List().get(i).click();
            }
        }
    }

//    C21454	Tap on Idle alert on Filter screen
//	C82672	Verify if the user can see how long the vehicle have been idling. For e.g: 5m
//	C147179	Tap on any idle alert list item
//	C166384	Verify that header displays the information of the list in the following format(Ex:7-day history, Total (xxxx): Showing 1 to 50)
    @Test(priority = 6)
    public void testIdleFilterVerification() {

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity1)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();
                new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.invisibilityOf(alertsPage.getProgress_bar()));

                if (Utils.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Productivity Filter No alerts are present for " + alertsPage.productivity1 + " filter");

                }
                else if (alertsPage.getAlert_List().isDisplayed()) {
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                   // System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());
                    System.out.println("The idle time for the Vehicle name " + alertsPage.getAlertVehicleName().get(0).getText() + " is " + alertsPage.getAlertVehicleTime().get(0));

                }
                alertsPage.Click_filter();
                alertsPage.getProductivity_List().get(i).click();
            }
        }
    }


//    C21462	Tap on Stop alert on Filter screen
//	C82681	Verify if user is able to see since how long the vehicle has been stopped For e.g: 1422d
//	C147181	Tap on any Stop alert list item
//	C166385	Verify that header displays the information of the list in the following format(Ex:7-day history, Total (xxxx): Showing 1 to 50)
    @Test(priority = 7)
    public void testStopFilterVerification()
    {


        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity2)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();
                new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.invisibilityOf(alertsPage.getProgress_bar()));

                if (Utils.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Productivity Filter No alerts are present for " + alertsPage.productivity2 + " filter");

                }
                else if (alertsPage.getAlert_List().isDisplayed()) {
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                  //  System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());
                    System.out.println("The Stopped time for the Vehicle name " + alertsPage.getAlertVehicleName().get(0).getText() + " is " + alertsPage.getAlertVehicleTime().get(0));

                }
                alertsPage.Click_filter();
                alertsPage.getProductivity_List().get(i).click();
            }
        }

    }

//    C21455	Tap on Input alert on Filters screen
//	C147170	Tap on Input alert list item
//	C166383	Verify that header displays the information of the list in the following format(Ex:7-day history, Total (xxxx): Showing 1 to 50)
    @Test(priority = 8)
    public void testInputFilterVerification()
    {


        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity3)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();
                new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.invisibilityOf(alertsPage.getProgress_bar()));

                if (Utils.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Productivity Filter No alerts are present for " + alertsPage.productivity3 + " filter");

                }
                else if (alertsPage.getAlert_List().isDisplayed()) {
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                 //   System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());


                }
                alertsPage.Click_filter();
                alertsPage.getProductivity_List().get(i).click();
            }
        }


    }
}


