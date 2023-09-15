package testscenarios;

import core.testrail.Constants;
import io.appium.java_client.AppiumDriver;
import org.json.simple.JSONObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import pageobjects.VehiclePage;
import core.testrail.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import core.testrail.TestUtils;
import utility.model.UserToken;
import utility.nspireservice.FleetViewService;
import utility.nspireservice.IdentityService;

import java.time.Duration;
import java.util.HashMap;

import static org.testng.Assert.assertTrue;
import org.json.JSONArray;

public class VehicleTestCase extends BaseTest {

    VehiclePage vehiclePage;

    AppiumDriver vehiclePageDriver;

    @Override
    protected void init(ITestContext context) {
        vehiclePage = new VehiclePage(getDriver());
        vehiclePageDriver = getDriver();
        FleetViewService.setFleetViewServiceBaseUrl(envProperties.getFleetViewServiceBaseUrl());
        fetchNSetUserToken(context, "Fleet360A", "Password@1");
        vehiclePageSetup();
    }

    private void fetchNSetUserToken(ITestContext context, String userName, String password) {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("X-Nspire-AppToken", "deac4c6c-81f1-11e7-bb31-be2e44b06b34");
        UserToken userToken = IdentityService.getUserToken(envProperties.getIdentityBaseUrl(), headers,userName, password);
        System.out.println("userToken: " + userToken.getToken());
        System.out.println("the scope  " +  userToken.getScope());
        context.setAttribute(Constants.USER_TOKEN, userToken.getToken());
    }

    private Object getAssetList(ITestContext context) {
        org.json.JSONObject jsonData = new org.json.JSONObject();

        // Create a JSONArray for "filterParam"
        JSONArray filterParamArray = new JSONArray();
        JSONArray filterParamInnerArray = new JSONArray();
        filterParamInnerArray.put("deviceId");
        filterParamInnerArray.put("exists:yes");
        filterParamArray.put(filterParamInnerArray);

        // Add "filterParam", "limit", and "start" to the JSON object
        jsonData.put("filterParam", filterParamArray);
        jsonData.put("limit", 100);
        jsonData.put("start", 0);

        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("X-Nspire-UserToken", context.getAttribute(Constants.USER_TOKEN).toString()); // received from Identity service
        headers.put("Content-Type", "application/json");
        System.out.println("the jsondata" + jsonData.toString());
        return FleetViewService.getAssetList(headers,jsonData);

    }

    @Override
    protected void deInit() {
        TestUtils.logOutUser(vehiclePage, vehiclePageDriver);
    }

    public void vehiclePageSetup() {
        TestUtils.logInUser(vehiclePage, vehiclePageDriver, "Fleet360A", "Password@1", this);
        TestUtils.waitForVisibility(vehiclePage.vehicleBottomBar, vehiclePageDriver);
        vehiclePage.vehicleBottomBar.click();
        new WebDriverWait(vehiclePageDriver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(vehiclePage.vehicleLists()));
        Assert.assertTrue((vehiclePage.vehicleLists().isDisplayed()));
    }

    //	C19949	Verify vehicle list screen UI is matching with Zeplin comp
    //	C19950	Verify list of vehicles are shown properly
    @Test(priority = 0)
    public void testVehicleUIElements(ITestContext context) {
        TestUtils.waitForVisibility(vehiclePage.vehicleTitle, vehiclePageDriver);
        Assert.assertTrue((vehiclePage.getVehicleTitle().isDisplayed()));
        Assert.assertTrue((vehiclePage.vehicleLists()).isDisplayed());
        Assert.assertTrue(vehiclePage.searchField().isDisplayed());
        Assert.assertTrue(vehiclePage.filterOption().isDisplayed());


        org.json.JSONObject assetList = (org.json.JSONObject) getAssetList(context);

        assert assetList != null;
        System.out.println("the vehicle count from UI :" + vehiclePage.totalCount.getText());
        System.out.println("the vehicle count from API response :" + assetList.get("total").toString());
        assertTrue(vehiclePage.totalCount.getText().contains(assetList.get("total").toString()));
    }



}

// //   C19965	Verify the vehicle status is shown correctly on the vehicle list screen
//    @Test(priority = 1)
//    public void testVehicleStatusDetailsDisplay() {
//        Assert.assertTrue(vehiclePage.getVehicleStatus().get(0).isDisplayed(), "Vehicle Status is Not Displayed on List Screen");
//    }
//
//
//    //C19971	Verify pull down to refresh functionality
//    @Test(priority = 2)
//    public void testVehicleListScreenPullToRefresh() throws InterruptedException {
//        TestUtils.clickElement(vehiclePage.vehicleBottomBar, vehiclePageDriver);
//        TestUtils.pullToRefresh(vehiclePageDriver);
//        TestUtils.waitForVisibility(vehiclePage.vehicleTitle, vehiclePageDriver);
//        Assert.assertTrue((vehiclePage.getVehicleTitle().isDisplayed()));
//        Assert.assertTrue((vehiclePage.vehicleLists()).isDisplayed());
//        Assert.assertTrue(vehiclePage.searchField().isDisplayed());
//        Assert.assertTrue(vehiclePage.filterOption().isDisplayed());
//    }
//
//    //C19972	Verify total count of vehicles in the vehicle list screen
//    @Test(priority = 3)
//    public void testVehicleListScreenTotalCountValidation() throws InterruptedException {
//        TestUtils.clickElement(vehiclePage.vehicleBottomBar, vehiclePageDriver);
//        Assert.assertTrue(vehiclePage.getTotalCount().isDisplayed());
//        Log.info("Vehicle Count :: " + vehiclePage.getTotalCount().getText());
//    }
//
//
//    //	C19974	Verify user is able to go to other screens from vehicle screen
//    //  C19975	Verify on click of individual vehicle it shows detailed vehicle page
//    @Test(priority = 4)
//    public void testVehicleListScreenVerification() throws InterruptedException {
//
//
//        vehiclePage.clickHomeScreenIcon();
//        Assert.assertEquals(vehiclePage.getHomeScreenTitle(), vehiclePage.homeScreenTitleText);
//        vehiclePage.clickAccountIcon();
//        Assert.assertEquals(vehiclePage.getAccountsText(), vehiclePage.accountText);
//        TestUtils.clickElement(vehiclePage.vehicleBottomBar, vehiclePageDriver);
//
//        TestUtils.waitForVisibility(vehiclePage.getVehicleLists(), vehiclePageDriver);
//        vehiclePage.getVehicleList().get(0).click();
//        Assert.assertEquals(vehiclePage.getDetails_tabText(), vehiclePage.details);
//        TestUtils.clickElement(vehiclePage.getDetailsBack(),vehiclePageDriver);
//
//    }
//
//    //C20774	Verify if no filter is applied
//    @Test(priority = 5)
//    public void testFilterNotApplied() throws InterruptedException {
//        for (int i = 0; i < 4; i++) {
//            Assert.assertFalse(vehiclePage.getFilterTitleList().get(i).isSelected());
//            Log.info("The " + vehiclePage.getFilterTitleList().get(i).getText() + " filter is not selected");
//        }
//        TestUtils.swipeLeft(vehiclePage.getFilterTitleList(), vehiclePageDriver);
//        Assert.assertFalse(vehiclePage.getNotLMIcon().isSelected());
//        Log.info("The " + vehiclePage.getNotLMIcon().getText() + " filter is not selected");
//        Assert.assertFalse(vehiclePage.getNotReportingIcon().isSelected());
//        Log.info("The " + vehiclePage.getNotReportingIcon().getText() + " filter is not selected");
//        TestUtils.swipeRight(vehiclePage.getFilterTitleList(), vehiclePageDriver);
//    }
//
//    //C103792	Verify on vehicle screen applied filters are highlighted and on the leftmost of the scrollbar
//    //C20783	Verify user is able to select more than one filters
//    @Test(priority = 6)
//    public void testMultiFilterSelected() {
//
//        //Multi filter selection
//       TestUtils.clickElement(vehiclePage.getMovingIcon(),vehiclePageDriver);
//        TestUtils.clickElement(vehiclePage.getStopIcon(),vehiclePageDriver);
//        Assert.assertTrue(vehiclePage.getFilterTitleList().get(0).isSelected() && vehiclePage.getFilterTitleList().get(0).getText().contains(vehiclePage.stopped));
//        Assert.assertTrue(vehiclePage.getFilterTitleList().get(1).isSelected() && vehiclePage.getFilterTitleList().get(1).getText().contains(vehiclePage.moving));
//        vehiclePage.getFilterTitleList().get(0).click();
//        vehiclePage.getFilterTitleList().get(0).click();
//
//    }
//
//    //C103849	Verify scrolling functionality on top filter
//    //C20844	Verify Filter functionality(ex:In Landmark/out of landmark filter is working properly)
//    @Test(priority = 7)
//    public void testInLMFAndOutOfLMFilterSelected() {
//        TestUtils.swipeLeft(vehiclePage.getFilterTitleList(), vehiclePageDriver);
//        vehiclePage.getLMIcon().click();
//        TestUtils.swipeRight(vehiclePage.getFilterTitleList(), vehiclePageDriver);
//
//        Assert.assertTrue(vehiclePage.getFilterTitleList().get(0).isSelected() && vehiclePage.getFilterTitleList().get(0).getText().contains(vehiclePage.inLandmark));
//        TestUtils.swipeLeft(vehiclePage.getFilterTitleList(), vehiclePageDriver);
//        vehiclePage.getNotLMIcon().click();
//        TestUtils.swipeRight(vehiclePage.getFilterTitleList(), vehiclePageDriver);
//        TestUtils.swipeRight(vehiclePage.getFilterTitleList(), vehiclePageDriver);
//        Assert.assertTrue(vehiclePage.getFilterTitleList().get(0).isSelected() && vehiclePage.getFilterTitleList().get(0).getText().contains(vehiclePage.outofLandmark));
//        vehiclePage.getFilterTitleList().get(0).click();
//    }
//
//    // C146560	Tap on filter icon which shows on the top right corner side
//    //	C103824	Verify tapping on Refresh button it should refresh the screen
//    //  C20778	Verify the search results match's all terms entered in the text.
//    //	C20782	Verify scroll functionality
//    @Test(priority = 8)
//    public void testActionsOnVehicleListScreen() {
//        vehiclePage.Click_filter();
//        TestUtils.waitForVisibility(vehiclePage.getFilterTitle(),vehiclePageDriver);
//        Assert.assertEquals(vehiclePage.getFilter_text(), vehiclePage.filter_text);
//        vehiclePage.ClickBack();
//        TestUtils.waitForVisibility(vehiclePage.getRefreshBtn(), vehiclePageDriver);
//        TestUtils.clickElement(vehiclePage.getRefreshBtn(),vehiclePageDriver);
//        TestUtils.ScrollDown(vehiclePageDriver);
//        vehiclePage.getSearch_icon();
//        vehiclePage.searchFld().sendKeys("Omar");
//        TestUtils.waitForVisibility(vehiclePage.getRefreshBtn(), vehiclePageDriver);
//
//
//        Assert.assertTrue(vehiclePage.getVehicleName().get(0).getText().contains("Omar"), "The search results doesn't match the terms entered in the text. ");
//
//        Log.info("The search results match's the terms entered in the text. ");
//        Log.info("The name of the vehicle is" + vehiclePage.getVehicleName().get(0).getText());
//        TestUtils.clickElement(vehiclePage.getDetailsBack(),vehiclePageDriver);
//    }



   //C19965	Verify the vehicle status is shown correctly on the vehicle list screen
    //C82688	Verify if the vehicle list details have status of vehicle along with hours in the second row For e.g: Stopped for 4h 22m
    //	C97944	Verify status duration shows correctly on vehicle list screen, details and map screen
//
//    @Test(priority = 9)
//    public void testVehicleStatusDetailsDisplay2() {
//


//        Assert.assertNotNull(vehiclePage.getVehicleStatus().get(0).getText(), "Vehicle Status is Not Displayed on Vehicle List Screen ");
//        Log.info("The Vehicle Status of the 1st Alert in the Vehicle List Screen is " + vehiclePage.getVehicleStatus().get(0).getText());
//        vehiclePage.getVehicleList().get(0).click();
//        Assert.assertNotNull(vehiclePage.getVehicleStatusDetails().get(3).getText(), "Vehicle Status is Not Displayed on Vehicle Details Screen ");
//        Log.info("The Vehicle Status of the 1st Alert in the Vehicle Details Screen is " + vehiclePage.getVehicleStatusDetails().get(3).getText());
//        Assert.assertTrue(vehiclePage.getVehicleStatusDetails().get(2).getText()!= vehiclePage.Null && vehiclePage.getIcon().get(1).isEnabled());
//        vehiclePage.getIcon().get(1).click();
//        TestUtils.waitForVisibility(vehiclePage.getVehicleStatusMap(), vehiclePageDriver);
//        Assert.assertNotNull(vehiclePage.getVehicleStatusMap().getText(), "Vehicle Status is Not Displayed on Vehicle Map Screen ");
//        Log.info("The Vehicle Status of the 1st Alert in the Vehicle Map Screen is " + vehiclePage.getVehicleStatusMap().getText());
//        vehiclePage.ClickVehicle1_Close();
//        TestUtils.clickElement(vehiclePage.vehicleBottomBar, vehiclePageDriver);
//


//        Assert.assertTrue(vehiclePage.getVehicleStatusDetails().get(3).isDisplayed(), "Vehicle Status is Not Displayed on Vehicle Details Screen ");
//        Log.info("The Vehicle Status of the 1st Alert in the Vehicle Details Screen is " + vehiclePage.getVehicleStatusDetails().get(3).getText());
//
//
//        System.out.println(vehiclePage.getIcon().size());
//        System.out.println(vehiclePage.getVehicleStatusDetails().size());
//        Assert.assertTrue(vehiclePage.getIcon().get(1).isEnabled());
//        Assert.assertNotNull(vehiclePage.getVehicleStatusDetails().get(2).getText());
////        if ( vehiclePage.getIcon().get(1).isEnabled() && vehiclePage.getVehicleStatusDetails().get(2).getText()!=null && vehiclePage.getVehicleAddress().get(2).getText() != vehiclePage.Null) {
////            vehiclePage.getIcon().get(1).click();
////            TestUtils.waitForVisibility(vehiclePage.getVehicleStatusMap(), vehiclePageDriver);
////            Log.info("The Vehicle Status of the 1st Alert in the Vehicle Map Screen is " + vehiclePage.getVehicleStatusMap().getText());
////            vehiclePage.ClickVehicle1_Close();
////            TestUtils.clickElement(vehiclePage.vehicleBottomBar, vehiclePageDriver);
////        }
////        else
////        {
////            Log.info("The Vehicle Status of the 1st Alert in the Vehicle Map Screen cannot be displayed as it is a Non Reporting Vehicle");
////            TestUtils.clickElement(vehiclePage.getDetailsBack(),vehiclePageDriver);
////        }
  //  }





    // C22201	Verify vehicle address information in the Vehicle List screen
    //C104948	Verify in vehicle list screen landmarkName is shown if available instead of address.
//    @Test(priority = 10)
//    public void testVehicleAddressDetailsVerification()
//    {
//        TestUtils.waitForVisibility(vehiclePage.vehicleLists,vehiclePageDriver);
//
//        Assert.assertTrue(vehiclePage.getVehicleAddress().get(0).getText() != vehiclePage.Null && vehiclePage.getVehicleAddress().get(0).getText() != null,"Vehicle Address is not displayed properly" );
//        if (vehiclePage.getVehicleAddress().get(0).getText().contains("--"))
//        {
//            Assert.assertTrue(vehiclePage.getVehicleAddress().get(0).getText().contains("--"),"Address is displayed properly and is not null ");
//
//            Log.info("The Address of the Vehicle in the 1st Alert of the Vehicle List Screen is  Null as it is a Non Reporting Vehicle");
//        }
//        else if(vehiclePage.getVehicleAddress().get(0).getText() != null)
//        {
//            if(vehiclePage.getVehicleAddress().get(0).getText().contains(","))
//            {
//                Log.info("The Address of the Vehicle in the 1st Alert of the Vehicle List Screen is " + vehiclePage.getVehicleAddress().get(0).getText());
//            }
//            else
//            {
//                Log.info("The Landmark Name  in the 1st Alert of the Vehicle List Screen is " + vehiclePage.getVehicleAddress().get(0).getText());
//            }
//        }
//    }
//
//    //C22059	Verify proper message is shown if assets are not available
//
//    @Test(priority = 11)
//    public void testVehicleNoAssetsFound() throws InterruptedException {
//
//        TestUtils.swipeLeft(vehiclePage.getFilterTitleList(), vehiclePageDriver);
//        TestUtils.clickElement(vehiclePage.getLMIcon(),vehiclePageDriver);
//        Assert.assertEquals(vehiclePage.getNoAssetsFound().getText(), vehiclePage.noAssets, "The Vehicle List is Displayed properly or the Actual result doesn't match the Expected Result");
//        TestUtils.swipeRight(vehiclePage.getFilterTitleList(), vehiclePageDriver);
//
//        vehiclePage.getFilterTitleList().get(0).click();
//
//    }
//

    //C97997	Verify map icon is disabled for Non reporting vehicle if last known is not available
    //	C97998	Verify status duration is not shown for non reporting vehicles
//    @Test(priority = 12)
//    public void testVehicleStatusforNonReportingVehicle()
//    {
//        TestUtils.swipeLeft(vehiclePage.getFilterTitleList(),vehiclePageDriver);
//        for (int i = 0; i < vehiclePage.getFilterTitleList().size(); i++)
//        {
//            if (vehiclePage.getFilterTitleList().get(i).getText().contains(vehiclePage.nonReporting))
//            {
//                vehiclePage.getFilterTitleList().get(i).click();
//
//
//                vehiclePageDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"never reported\").instance(0))")).click();
//
//                if (vehiclePage.getVehicleStatusDetails().get(3).getText().contains(vehiclePage.neverReported))
//                {
//                    Assert.assertTrue(vehiclePage.getVehicleStatusDetails().get(3).getText().contains(vehiclePage.neverReported), "The Status Duration is  Displayed properly or the Actual result doesn't match the Expected Result for this NonReporting Vehicle");
//
////                    if (vehiclePage.getVehicleStatusDetails().get(2).getText().contains("--") )
////                    {
////                        Assert.assertFalse(vehiclePage.getMapIcon().isSelected(), "The Map Icon is enabled");
////                        Assert.assertEquals(vehiclePage.getVehicleStatusDetails().get(2).getText(), vehiclePage.Null, "The Vehicle Address is Displayed properly for this NonReporting Vehicle ");
////                        Log.info("The Vehicle Address  is Not Displayed properly  and the Map icon is disabled for this NonReporting Vehicle");
////                        TestUtils.clickElement(vehiclePage.getDetailsBack(),vehiclePageDriver);
////
////                    }
////                    else if (vehiclePage.getVehicleStatusDetails().get(2).getText() != "--" && vehiclePage.getIcon().get(1).isEnabled())
////                    {
////                        Assert.assertTrue(vehiclePage.getIcon().get(1).isEnabled(), "The Map Icon is disabled or is not present");
////                        Assert.assertNotEquals(vehiclePage.getVehicleStatusDetails().get(2).getText(), vehiclePage.Null, "The Vehicle Address is Null and Map icon is disabled or the Actual result  matches the Expected Result for this NonReporting Vehicle");
////                        Log.info("The Vehicle Address is displayed properly-->"+ vehiclePage.getVehicleStatusDetails().get(2).getText()+ "and Map icon is enabled");
////                        TestUtils.clickElement(vehiclePage.getDetailsBack(),vehiclePageDriver);
////                    }
//                    Assert.assertFalse(vehiclePage.getIcon().get(1).isSelected(), "The Map Icon is enabled");
//                    Assert.assertTrue(vehiclePage.getVehicleStatusDetails().get(2).getText().contains("--"),"The Vehicle Address is Displayed properly for this NonReporting Vehicle ");
//                }
//
//
//            }
//        }
//
//
//    }
//
//}

