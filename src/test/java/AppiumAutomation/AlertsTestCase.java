
package AppiumAutomation;


import android.AlertsPage;
import android.ForgotPasswordPage;
import android.MapScreenPage;
import android.SignInPage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ActionClass;

import java.time.Duration;

public class AlertsTestCase extends BaseTest {

    public SignInPage signInPage;
    public ForgotPasswordPage forgotPasswordPage;

    public MapScreenPage mapScreenPage;
    public AlertsPage alertsPage;

    @Override
    protected void initPage() {
        signInPage = new SignInPage(getDriver());
        forgotPasswordPage = new ForgotPasswordPage(getDriver());
        mapScreenPage = new MapScreenPage(getDriver());
        alertsPage = new AlertsPage(getDriver());
    }

    // C21287  Verify Alerts screen UI
    //C102181 Tap on any alert list item
    //C147073 Tap on Filter icon
    @Test(priority = 0)
    public void testAlertsScreenUIVerification() throws InterruptedException {

        ActionClass.logInUser(signInPage, getDriver(), "Fleet360A", "Password@1");

        alertsPage.ClickAlerts_icon();
        Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());


        Assert.assertEquals(alertsPage.getAlert_Title_text(), alertsPage.Alert_Title);
        Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());

        alertsPage.AlertListFull.get(0).click();

        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(alertsPage.Back()));
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
    public void testAlertsScreenNetworkVerification() throws InterruptedException {
        alertsPage.Click_HomeScreen_icon();
        ActionClass.internetOff(getDriver());
        alertsPage.ClickAlerts_icon();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(alertsPage.getNetwork_Error()));
        Assert.assertEquals(alertsPage.getNetwork_Error_Msg(), alertsPage.network_msg);
        ActionClass.internetOn(getDriver());
        alertsPage.ClickRetry();

        Assert.assertNotNull(alertsPage.getAlertList());
        Assert.assertFalse(alertsPage.getAlertList().isEmpty());

        ActionClass.waitForInvisibility(alertsPage.getFilter_icon(), getDriver());

        ActionClass.pullToRefresh(getDriver());
    }

//    public void testAlertsScreenNetworkVerificaton() throws InterruptedException {
//
//
//        alertsPage.Click_HomeScreen_icon();
//        driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());
//        alertsPage.ClickAlerts_icon();
//        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(alertsPage.getNetwork_Error()));
//        Assert.assertEquals(alertsPage.getNetwork_Error_Msg(), alertsPage.network_msg);
//        driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled().build());
//        alertsPage.ClickRetry();
//
//        Assert.assertFalse(alertsPage.getAlertList().isEmpty());
//
//
//        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(alertsPage.getFilter_icon()));
//
//        pullToRefresh();
//
//    }

    //C103327 Verify alert filter has categories like safety/Productivity/Monitoring/Asset health
    @Test(priority = 2)
    public void testAlertFilterCategoriesVerification() throws InterruptedException {


        alertsPage.Click_filter();


        Assert.assertTrue(alertsPage.getFilterCategoriesList().get(0).getText().contains(alertsPage.safety));
        Assert.assertTrue(alertsPage.getFilterCategoriesList().get(1).getText().contains(alertsPage.prod));
        Assert.assertTrue(alertsPage.getFilterCategoriesList().get(2).getText().contains(alertsPage.monitor));
        String Asset_health = getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Asset Health (5)\"));")).getText();
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

        Assert.assertEquals(getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Low Battery\"));")).getText(), alertsPage.asset1);
        Assert.assertEquals(getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Maintenance\"));")).getText(), alertsPage.asset2);
        Assert.assertEquals(getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tire Pressure\"));")).getText(), alertsPage.asset3);
        Assert.assertEquals(getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Engine Oil Life\"));")).getText(), alertsPage.asset4);
        Assert.assertEquals(getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"DTC Alert\"));")).getText(), alertsPage.asset5);

    }

    @Test(priority = 4)
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

        ActionClass.logOutUser(signInPage);
    }

    @Test(priority = 9)
    public void testProductivityListDisplayVerification() throws InterruptedException {
        int k = 1;
        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity1) || alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity2) || alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity3) || alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity4)) {


                String filter_name = alertsPage.getProductivity_List().get(i).getText();
                alertsPage.getProductivity_List().get(i).click();

                alertsPage.ClickBack();
                if (k == 1) {
                    alertsPage.ClickRatingPopup();
                    alertsPage.ClickRatingPopup();
                    k = k + 1;
                }

                new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.invisibilityOf(alertsPage.getProgress_bar()));
                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Productivity Filter No alerts are present for " + filter_name + " filter");
                    alertsPage.Click_filter();
                    alertsPage.getProductivity_List().get(i).click();
                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    System.out.println("In Productivity Filter, alerts are present for " + filter_name + " filter");
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
    public void testLandmarkArrivalandDepartureFilterVerification() {
        ActionClass.logInUser(signInPage, getDriver(), "Fleet360A", "Password@1");

        alertsPage.ClickAlerts_icon();
        alertsPage.Click_filter();

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity4)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();
                new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.invisibilityOf(alertsPage.getProgress_bar()));

                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Productivity Filter No alerts are present for " + alertsPage.productivity4 + " filter");

                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    // System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getAttribute("text")); (we can do assertion of header count, but cannot print it.....will check later)
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
                        System.out.println("In Productivity Filter  alerts are present for " + alertsPage.productivity4 + " filter");
                        System.out.println("The Landmark name for this alert ----" + result[0]);
                        alertsPage.ClickBack();
                    } else if (result[0] == null) {
                        System.out.println("In Productivity Filter  alerts are present for " + alertsPage.productivity4 + " filter");
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
                new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.invisibilityOf(alertsPage.getProgress_bar()));

                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Productivity Filter No alerts are present for " + alertsPage.productivity1 + " filter");

                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    System.out.println("In Productivity Filter  alerts are present for " + alertsPage.productivity1 + " filter");
                    // System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText()); (we can do assertion of header count, but cannot print it.....will check later)
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
    public void testStopFilterVerification() {


        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity2)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();
                new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.invisibilityOf(alertsPage.getProgress_bar()));

                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Productivity Filter No alerts are present for " + alertsPage.productivity2 + " filter");

                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    System.out.println("In Productivity Filter  alerts are present for " + alertsPage.productivity2 + " filter");
                    //  System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText()); (we can do assertion of header count, but cannot print it.....will check later)
                    System.out.println("The Stopped time for the Vehicle name " + alertsPage.getAlertVehicleName().get(0).getText() + " is " + alertsPage.getAlertVehicleTime().get(0));

                }
                alertsPage.Click_filter();
                alertsPage.getProductivity_List().get(i).click();
            }
        }

    }

    //   C21455	Tap on Input alert on Filters screen
//	C147170	Tap on Input alert list item
//	C166383	Verify that header displays the information of the list in the following format(Ex:7-day history, Total (xxxx): Showing 1 to 50)
    @Test(priority = 8)
    public void testInputFilterVerification() {
        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.productivity3)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();
                ActionClass.waitForVisibility(alertsPage.getProgress_bar(), getDriver());

                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Productivity Filter No alerts are present for " + alertsPage.productivity3 + " filter");
                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    System.out.println("In Productivity Filter  alerts are present for " + alertsPage.productivity3 + " filter");
                    System.out.println("For this Input filter alert the Vehicle name is " + alertsPage.getAlertVehicleName().get(0).getText());
                    //   System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());(we can do assertion of header count, but cannot print it.....will check later)
                }
                alertsPage.Click_filter();
                alertsPage.getProductivity_List().get(i).click();
            }
        }


    }


    //	C24360	Tap on Speed Limit alert on Filter screen
//	C147176	Tap on any alert list item
    @Test(priority = 10)
    public void testSafetyPostedSpeedLimitVerification() {

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.safety3)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();

                ActionClass.waitForVisibility(alertsPage.getProgress_bar(), getDriver());

                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Safety Filter No alerts are present for " + alertsPage.safety3 + " filter");

                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    //   System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());(we can do assertion of header count, but cannot print it.....will check later)
                    System.out.println("In Safety Filter  alerts are present for " + alertsPage.safety3 + " filter");
                    System.out.println("The Vehicle name for Posted Speed Limit filter alert is " + alertsPage.getAlertVehicleName().get(0).getText() + " and it's Speed Limit is" + alertsPage.getAlertVehicleTime().get(0).getText());

                }
                alertsPage.Click_filter();
                Assert.assertTrue(alertsPage.getProductivity_List().get(i).isSelected());
                alertsPage.getProductivity_List().get(i).click();
            }
        }


    }

    //C21463	Tap on Hard Braking alert on Filter screen
    //C147178	Tap on any alert list item
    @Test(priority = 11)
    public void testSafetyHardBrakingVerification() {

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.safety1)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();

                ActionClass.waitForVisibility(alertsPage.getProgress_bar(), getDriver());

                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Safety Filter No alerts are present for " + alertsPage.safety1 + " filter");

                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    //   System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());(we can do assertion of header count, but cannot print it.....will check later)
                    System.out.println("In Safety Filter  alerts are present for " + alertsPage.safety1 + " filter");
                    System.out.println("The  Vehicle name for Hard Breaking & Hard Acceleration filter alert is " + alertsPage.getAlertVehicleName().get(0).getText());

                }
                alertsPage.Click_filter();
                Assert.assertTrue(alertsPage.getProductivity_List().get(i).isSelected());
                alertsPage.getProductivity_List().get(i).click();
            }
        }

    }


    //C21460	Tap on Odd Hours alert on Filter screen
    //C147177	Tap on any alert list item
    @Test(priority = 12)
    public void testSafetyOddHourVerification() {

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.safety2)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();

                ActionClass.waitForVisibility(alertsPage.getProgress_bar(), getDriver());

                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Safety Filter No alerts are present for " + alertsPage.safety2 + " filter");

                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    //   System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());(we can do assertion of header count, but cannot print it.....will check later)
                    System.out.println("In Safety Filter  alerts are present for " + alertsPage.safety2 + " filter");
                    System.out.println("The  Vehicle name for Odd Hours filter alert is " + alertsPage.getAlertVehicleName().get(0).getText());
                }
                alertsPage.Click_filter();
                Assert.assertTrue(alertsPage.getProductivity_List().get(i).isSelected());
                alertsPage.getProductivity_List().get(i).click();
            }
        }


    }


    //C21474	Tap on Unauthorized Movement alert on Filter screen
//C96835	Verify alert registration id name is shown on alert list
//C147184	Tap on any alert list item
    @Test(priority = 13)
    public void testSafetyUnauthorizedMomentVerification() {

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.safety5)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();

                ActionClass.waitForVisibility(alertsPage.getProgress_bar(), getDriver());

                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Safety Filter No alerts are present for " + alertsPage.safety5 + " filter");

                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    //   System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());(we can do assertion of header count, but cannot print it.....will check later)
                    System.out.println("In Safety Filter  alerts are present for " + alertsPage.safety5 + " filter");
                    System.out.println("The  Alert Registration id name for Unauthorized Movement filter alert is " + alertsPage.getAlertName().get(0).getText());

                }
                alertsPage.Click_filter();
                Assert.assertTrue(alertsPage.getProductivity_List().get(i).isSelected());
                alertsPage.getProductivity_List().get(i).click();
            }
        }
    }


    //C21461	Tap on Speed threshold alert on Filter screen
    //C82675	Verify that the user is able to see the current speed threshold For e.g: 20.0 mph
    //C147180	Tap on any alert list item
    @Test(priority = 14)
    public void testSafetySpeedThresholdVerification() {

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.safety4)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();
                ActionClass.waitForVisibility(alertsPage.getProgress_bar(), getDriver());

                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Safety Filter No alerts are present for " + alertsPage.safety4 + " filter");

                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    //   System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());(we can do assertion of header count, but cannot print it.....will check later)
                    System.out.println("In Safety Filter  alerts are present for " + alertsPage.safety4 + " filter");
                    System.out.println("The  Vehicle name for SpeedThreshold filter alert is " + alertsPage.getAlertVehicleName().get(0).getText() + " and it's threshold speed is " + alertsPage.getAlertVehicleTime().get(0).getText());
                }
                alertsPage.Click_filter();
                Assert.assertTrue(alertsPage.getProductivity_List().get(i).isSelected());
                alertsPage.getProductivity_List().get(i).click();
            }
        }


    }


    //C24352	Tap on Low Battery alert on Filter screen
//C147185	Tap on any Low battery alert list item
    @Test(priority = 15)
    public void testAssetHealthLowBatteryVerification() {

        getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Low Battery\"));"));

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.asset1)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();
                ActionClass.waitForVisibility(alertsPage.getProgress_bar(), getDriver());

                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Asset Health Filter No alerts are present for " + alertsPage.asset1 + " filter");

                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());

                    //   System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());(we can do assertion of header count, but cannot print it.....will check later)
                    System.out.println("In Asset Health Filter  alerts are present for " + alertsPage.asset1 + " filter");
                    System.out.println("The  Asset name for  this corresponding Low Battery filter alert is " + alertsPage.getAlertVehicleName().get(0).getText());
                    System.out.println("The  Alert name for  this corresponding Low Battery filter alert is " + alertsPage.getAlertName().get(0).getText());
                    System.out.println("The Low Battery voltage is  " + alertsPage.getAlertVehicleTime().get(0).getText());
                }
                alertsPage.Click_filter();
                getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Low Battery\"));"));
                Assert.assertTrue(alertsPage.getProductivity_List().get(i).isSelected());
                alertsPage.getProductivity_List().get(i).click();
            }
        }


    }

    //C21457	Tap on Maintenance alert on Filter screen
//C82673	Check user is able to see the actual odometer of the vehicle
//C82674	Verify that the user is able to see the current engine hours For e.g: 1438 hrs
//C147183	Tap on any alert list item
    @Test(priority = 16)
    public void testAssetHealthMaintenanceVerification() {

        getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Maintenance\"));"));

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.asset2)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();

                ActionClass.waitForVisibility(alertsPage.getProgress_bar(), getDriver());

                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Safety Filter No alerts are present for " + alertsPage.asset2 + " filter");

                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    //   System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());(we can do assertion of header count, but cannot print it.....will check later)
                    System.out.println("In Asset Health Filter  alerts are present for " + alertsPage.asset2 + " filter");
                    String Type_Of_Alert = alertsPage.getAlertVehicleTime().get(0).getText();
                    if (Type_Of_Alert.contains("Time Period")) {
                        System.out.println("The  Asset name for  this corresponding Maintenance filter alert is " + alertsPage.getAlertVehicleName().get(0).getText());
                        System.out.println("The  Alert name for  this corresponding Maintenance filter alert is " + alertsPage.getAlertName().get(0).getText());
                        System.out.println("The Maintenance Alert type it is  --->  " + alertsPage.getAlertVehicleTime().get(0).getText());
                        System.out.println("For the Maintenance Alert type --->  " + alertsPage.getAlertVehicleTime().get(0).getText() + "--->the corresponding value is --->" + alertsPage.getSubValue().get(0).getText());
                        System.out.println("The Timing for this corresponding Maintenance filter alert is " + alertsPage.getAlertTime().get(0).getText());
                    } else if (Type_Of_Alert.contains("Engine Hours")) {
                        System.out.println("The  Asset name for  this corresponding Maintenance filter  alert is " + alertsPage.getAlertVehicleName().get(0).getText());
                        System.out.println("The  Alert name for  this corresponding Maintenance filter  alert is " + alertsPage.getAlertName().get(0).getText());
                        System.out.println("The Maintenance Alert type it is  --->  " + alertsPage.getAlertVehicleTime().get(0).getText());
                        System.out.println("For the Maintenance Alert type --->  " + alertsPage.getAlertVehicleTime().get(0).getText() + "--->the corresponding value is --->" + alertsPage.getSubValue().get(0).getText());
                        System.out.println("The Timing for this corresponding Maintenance filter  alert is " + alertsPage.getAlertTime().get(0).getText());
                    } else if (Type_Of_Alert.contains("Distance")) {
                        System.out.println("The  Asset name for  this corresponding Maintenance filter alert is " + alertsPage.getAlertVehicleName().get(0).getText());
                        System.out.println("The  Alert name for  this corresponding Maintenance filter alert is " + alertsPage.getAlertName().get(0).getText());
                        System.out.println("The Maintenance Alert type it is  --->  " + alertsPage.getAlertVehicleTime().get(0).getText());
                        System.out.println("For the Maintenance Alert type --->  " + alertsPage.getAlertVehicleTime().get(0).getText() + "--->the corresponding value is --->" + alertsPage.getSubValue().get(0).getText());
                        System.out.println("The Timing for this corresponding Maintenance filter alert is " + alertsPage.getAlertTime().get(0).getText());
                    }
                }
                alertsPage.Click_filter();
                getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Maintenance\"));"));
                Assert.assertTrue(alertsPage.getProductivity_List().get(i).isSelected());
                alertsPage.getProductivity_List().get(i).click();
            }
        }


    }

    //C98072	Apply a filter on DTC Alert
    //C98076	Verify that header displays the information of the list in the following format(Ex:7-day history, Total (xxxx): Showing 1 to 50)
    //C98077	Tap on any DTC alert list item
    //C98079	Verify Alert name, Asset name , Diagnostic code,  time is shown on DTC alert list screen
    @Test(priority = 17)
    public void testAssetHealthDTCAlertsVerification() {

        getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"DTC Alert\"));"));

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.asset5)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();

                ActionClass.waitForVisibility(alertsPage.getProgress_bar(), getDriver());
                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Asset Health Filter No alerts are present for " + alertsPage.asset5 + " filter");
                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    //   System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());(we can do assertion of header count, but cannot print it.....will check later)
                    System.out.println("In Asset Health Filter  alerts are present for " + alertsPage.asset5 + " filter");
                    System.out.println("The  Asset name for  this corresponding DTC Alert filter alert is " + alertsPage.getAlertVehicleName().get(0).getText());
                    System.out.println("The  Alert name for  this corresponding DTC Alert filter alert is " + alertsPage.getAlertName().get(0).getText());
                    System.out.println("The Diagnostic code for this DTC Alert filter alert is " + alertsPage.getAlertVehicleTime().get(0).getText());
                    System.out.println("The Timing for this corresponding DTC filter alert is " + alertsPage.getAlertTime().get(0).getText());
                }
                alertsPage.Click_filter();
                getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"DTC Alert\"));"));
                Assert.assertTrue(alertsPage.getProductivity_List().get(i).isSelected());
                alertsPage.getProductivity_List().get(i).click();
            }
        }
    }


    //C90297	Verify Engine Oil Life alert info
    //C90318	Tap on Engine Oil Life on Filter screen
    //C147186	Tap on any alert list item
    @Test(priority = 18)
    public void testAssetHealthEngineOilVerification() {

        getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Engine Oil Life\"));"));

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.asset4)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();

                ActionClass.waitForVisibility(alertsPage.getProgress_bar(), getDriver());
                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Asset Health Filter No alerts are present for " + alertsPage.asset4 + " filter");
                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    //   System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());(we can do assertion of header count, but cannot print it.....will check later)
                    System.out.println("In Asset Health Filter  alerts are present for " + alertsPage.asset4 + " filter");
                    System.out.println("The  Asset name for  this corresponding Engine Oil Life filter alert is " + alertsPage.getAlertVehicleName().get(0).getText());
                    System.out.println("The  Alert name for  this corresponding Engine Oil Life filter alert is " + alertsPage.getAlertName().get(0).getText());
                    System.out.println("The Oil level % for this Engine Oil Life filter  alert is " + alertsPage.getAlertVehicleTime().get(0).getText());
                    System.out.println("The Timing for this corresponding Engine Oil Life filter alert is " + alertsPage.getAlertTime().get(0).getText());
                }
                alertsPage.Click_filter();
                getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Engine Oil Life\"));"));
                Assert.assertTrue(alertsPage.getProductivity_List().get(i).isSelected());
                alertsPage.getProductivity_List().get(i).click();
            }
        }


    }


    //C90296	Verify Tire Pressure alert info
//C90320	Tap on Tire pressure alert on Filter screen
//C147172	Tap on any Tire Pressure alert list item
    @Test(priority = 19)
    public void testAssetHealthTirePressureVerification() {

        getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tire Pressure\"));"));

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.asset3)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();

                ActionClass.waitForVisibility(alertsPage.getProgress_bar(), getDriver());
                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Asset Health Filter No alerts are present for " + alertsPage.asset3 + " filter");
                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    //   System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());(we can do assertion of header count, but cannot print it.....will check later)
                    System.out.println("In Asset Health Filter  alerts are present for " + alertsPage.asset3 + " filter");
                    System.out.println("The  Asset name for  this corresponding Tire Pressure filter alert is " + alertsPage.getAlertVehicleName().get(0).getText());
                    System.out.println("The  Alert name for  this corresponding Tire Pressure filter alert is " + alertsPage.getAlertName().get(0).getText());
                    System.out.println("The tire pressure value for this Tire Pressure filter alert is" + alertsPage.getAlertVehicleTime().get(0).getText() + " " + alertsPage.getSubValue().get(0).getText());
                    System.out.println("The Timing for this corresponding Tire Pressure filter alert is " + alertsPage.getAlertTime().get(0).getText());
                }
                alertsPage.Click_filter();
                getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tire Pressure\"));"));
                Assert.assertTrue(alertsPage.getProductivity_List().get(i).isSelected());
                alertsPage.getProductivity_List().get(i).click();
            }
        }
    }


    //  C21291	Tap on Temperature alert on Filter screen
    //	C82676	Verify if the user is able to see the current temperature. For e.g: 64.2F
    //	C147175	Tap on any alert list item
    @Test(priority = 20)
    public void testMonitoringTemperatureVerification() {

        getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tire Pressure\"));"));

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.monitor2)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();

                ActionClass.waitForVisibility(alertsPage.getProgress_bar(), getDriver());
                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Monitoring Filter No alerts are present for " + alertsPage.monitor2 + " filter");
                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    //   System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());(we can do assertion of header count, but cannot print it.....will check later)
                    System.out.println("In Monitoring Filter  alerts are present for " + alertsPage.monitor2 + " filter");
                    System.out.println("The  Asset name for  this corresponding Temperature filter alert is " + alertsPage.getAlertVehicleName().get(0).getText());
                    System.out.println("The  Alert name for  this corresponding Temperature filter alert is " + alertsPage.getAlertName().get(0).getText());
                    System.out.println("The temperature value for this Temperature filter alert is " + alertsPage.getAlertVehicleTime().get(0).getText());
                    System.out.println("The Timing for this corresponding Temperature filter alert is " + alertsPage.getAlertTime().get(0).getText());
                }
                alertsPage.Click_filter();
                getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tire Pressure\"));"));
                Assert.assertTrue(alertsPage.getProductivity_List().get(i).isSelected());
                alertsPage.getProductivity_List().get(i).click();
            }
        }
    }


    //  C90298	Verify Fuel Tank alert info
//	C90322	Tap on Fuel tank alert on Filter screen
//	C147173	Tap on any alert list item
    @Test(priority = 21)
    public void testMonitoringFuelTankVerification() {

        getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tire Pressure\"));"));

        for (int i = 0; i < alertsPage.getProductivity_List().size(); i++) {
            if (alertsPage.getProductivity_List().get(i).getText().contains(alertsPage.monitor1)) {
                alertsPage.getProductivity_List().get(i).click();
                alertsPage.ClickBack();

                ActionClass.waitForVisibility(alertsPage.getProgress_bar(), getDriver());
                if (ActionClass.isElementPresent(alertsPage.getNo_Alerts_Found()) && alertsPage.getNo_Alerts_Found().isDisplayed()) {
                    Assert.assertEquals(alertsPage.getNo_Alerts_Found_Msg(), alertsPage.Alert_Msg);
                    System.out.println("In Monitoring Filter No alerts are present for " + alertsPage.monitor1 + " filter");
                } else if (alertsPage.getAlert_List().isDisplayed()) {
                    Assert.assertTrue(alertsPage.getAlert_List().isDisplayed());
                    alertsPage.getAlertListFull().get(0).click();
                    alertsPage.ClickBack();
                    Assert.assertTrue(alertsPage.getTotal_itemsCount().isDisplayed());
                    //   System.out.println("Total alerts present in list" + alertsPage.getTotal_itemsCount().getText());(we can do assertion of header count, but cannot print it.....will check later)
                    System.out.println("In Monitoring Filter  alerts are present for " + alertsPage.monitor1 + " filter");
                    System.out.println("The  Asset name for  this corresponding Fuel tank filter alert is " + alertsPage.getAlertVehicleName().get(0).getText());
                    System.out.println("The  Alert name for  this corresponding Fuel tank filter alert is " + alertsPage.getAlertName().get(0).getText());
                    System.out.println("The Fuel Level value for this Fuel tank filter alert is " + alertsPage.getAlertVehicleTime().get(0).getText());
                    System.out.println("The Timing for this corresponding Fuel tank filter alert is " + alertsPage.getAlertTime().get(0).getText());
                }
                alertsPage.Click_filter();
                getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tire Pressure\"));"));
                Assert.assertTrue(alertsPage.getProductivity_List().get(i).isSelected());
                alertsPage.getProductivity_List().get(i).click();
            }
        }
    }
}


  

