package testscenarios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobjects.AlertsPage;
import pageobjects.MapScreenPage;
import pageobjects.VehiclePage;
import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import core.TestUtils;

import java.time.Duration;

public class VehicleTestCase extends BaseTest {

    VehiclePage vehiclePage;
    MapScreenPage mapScreenPage;
    AlertsPage alertsPage;

    AppiumDriver vehiclePageDriver;

    @Override
    protected void init() {
        vehiclePage = new VehiclePage(getDriver());
        vehiclePageDriver = getDriver();
    }

    @Override
    protected void deInit() {

    }

    @BeforeClass
    public void beforeClass() {
        vehiclePageSetup();
    }

    public void vehiclePageSetup() {
        TestUtils.logInUser(vehiclePage, vehiclePageDriver, "Fleet360A", "Password@1");
        TestUtils.waitForVisibility(vehiclePage.vehicleBottomBar, vehiclePageDriver);
        vehiclePage.vehicleBottomBar.click();
        new WebDriverWait(vehiclePageDriver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(vehiclePage.vehicleLists()));
        Assert.assertTrue((vehiclePage.vehicleLists().isDisplayed()));
    }

    @AfterClass
    public void afterClass() {
        TestUtils.logOutUser(vehiclePage);
    }


    //	C19949	Verify vehicle list screen UI is matching with Zeplin comp
    //	C19950	Verify list of vehicles are shown properly
    @Test(priority = 0)
    public void testVehicleUIElements() {
        TestUtils.waitForVisibility(vehiclePage.vehicleTitle, vehiclePageDriver);
        Assert.assertTrue((vehiclePage.getVehicleTitle().isDisplayed()));
        Assert.assertTrue((vehiclePage.vehicleLists()).isDisplayed());
        Assert.assertTrue(vehiclePage.searchField().isDisplayed());
        Assert.assertTrue(vehiclePage.filterOption().isDisplayed());
    }

    //C19965	Verify the vehicle status is shown correctly on the vehicle list screen
    @Test(priority = 1)
    public void testVehicleStatusDetailsDisplay() {
        Assert.assertTrue(vehiclePage.getVehicleList().get(0).isDisplayed(), "Vehicle Status is Not Displayed");
    }


    //C19971	Verify pull down to refresh functionality
    @Test(priority = 2)
    public void testVehicleListScreenPullToRefresh() throws InterruptedException {
        TestUtils.clickElement(vehiclePage.vehicleBottomBar, vehiclePageDriver);
        TestUtils.pullToRefresh(vehiclePageDriver);
        TestUtils.waitForVisibility(vehiclePage.vehicleTitle, vehiclePageDriver);
        Assert.assertTrue((vehiclePage.getVehicleTitle().isDisplayed()));
        Assert.assertTrue((vehiclePage.vehicleLists()).isDisplayed());
        Assert.assertTrue(vehiclePage.searchField().isDisplayed());
        Assert.assertTrue(vehiclePage.filterOption().isDisplayed());
    }

    //C19972	Verify total count of vehicles in the vehicle list screen
    @Test(priority = 3)
    public void testVehicleListScreenTotalCountValidation() throws InterruptedException {
        TestUtils.clickElement(vehiclePage.vehicleBottomBar, vehiclePageDriver);
        Assert.assertTrue(vehiclePage.getTotalCount().isDisplayed());
        Log.info("Vehicle Count :: " + vehiclePage.getTotalCount().getText());
    }


    //	C19974	Verify user is able to go to other screens from vehicle screen
    //  C19975	Verify on click of individual vehicle it shows detailed vehicle page
    @Test(priority = 4)
    public void testVehicleListScreenVerification() throws InterruptedException {
        mapScreenPage = new MapScreenPage(vehiclePageDriver);

        mapScreenPage.clickHomeScreenIcon();
        Assert.assertEquals(mapScreenPage.getFLText(), mapScreenPage.title);
        mapScreenPage.clickAccountIcon();
        Assert.assertEquals(mapScreenPage.getAccountsText(), mapScreenPage.accountText);
        TestUtils.clickElement(vehiclePage.vehicleBottomBar, vehiclePageDriver);

        TestUtils.waitForVisibility(vehiclePage.getVehicleLists(), vehiclePageDriver);
        vehiclePage.getVehicleList().get(0).click();
        Assert.assertEquals(mapScreenPage.getDetails_tabText(), mapScreenPage.details);
        mapScreenPage.ClickBack();

    }

    //C20774	Verify if no filter is applied
    @Test(priority = 5)
    public void testFilterNotApplied() throws InterruptedException {

        for (int i = 0; i < 4; i++) {
            Assert.assertFalse(vehiclePage.getFilterTitleList().get(i).isSelected());
            Log.info("The " + vehiclePage.getFilterTitleList().get(i).getText() + " filter is not selected");
        }
        TestUtils.swipeLeft(vehiclePage.getFilterTitleList(), vehiclePageDriver);
        Assert.assertFalse(vehiclePage.getNotLMIcon().isSelected());
        Log.info("The " + vehiclePage.getNotLMIcon().getText() + " filter is not selected");
        Assert.assertFalse(vehiclePage.getNotReportingIcon().isSelected());
        Log.info("The " + vehiclePage.getNotReportingIcon().getText() + " filter is not selected");

    }

    //C103792	Verify on vehicle screen applied filters are highlighted and on the leftmost of the scrollbar
    //C103849	Verify scrolling functionality on top filter
    //C20844	Verify Filter functionality(ex:In Landmark/out of landmark filter is working properly)
    //C20783	Verify user is able to select more than one filters
    @Test(priority = 6)
    public void testMultiFilterSelected() {

        //Multi filter selection
        for (int i = 0; i < vehiclePage.getFilterTitleList().size(); i++) {
            if (vehiclePage.getFilterTitleList().get(i).getText().contains(vehiclePage.moving) || vehiclePage.getFilterTitleList().get(i).getText().contains(vehiclePage.stopped)) {
                vehiclePage.getFilterTitleList().get(i).click();
                Assert.assertTrue(vehiclePage.getFilterTitleList().get(0).isSelected());
            }
        }
        vehiclePage.getFilterTitleList().get(0).click();
        vehiclePage.getFilterTitleList().get(0).click();
        for (int i = 0; i < vehiclePage.getFilterTitleList().size() - 1; i++) {
            if (vehiclePage.getFilterTitleList().get(i).getText().contains(vehiclePage.inLandmark)) {
                vehiclePage.getFilterTitleList().get(i).click();
                TestUtils.swipeRight(vehiclePage.getFilterTitleList(), vehiclePageDriver);
                Assert.assertTrue(vehiclePage.getFilterTitleList().get(0).isSelected(), "In LandMark not Selected");
                vehiclePage.getFilterTitleList().get(0).click();
                TestUtils.swipeLeft(vehiclePage.getFilterTitleList(), vehiclePageDriver);
            }
            vehiclePage.getFilterTitleList().get(0).click();
            TestUtils.swipeRight(vehiclePage.getFilterTitleList(), vehiclePageDriver);
            if (vehiclePage.getFilterTitleList().get(i).getText().contains(vehiclePage.outofLandmark)) {
                vehiclePage.getFilterTitleList().get(i).click();
                TestUtils.swipeRight(vehiclePage.getFilterTitleList(), vehiclePageDriver);
                Assert.assertTrue(vehiclePage.getFilterTitleList().get(0).isSelected(), "Out of Landmark not Selected");
                vehiclePage.getFilterTitleList().get(0).click();
            }
        }
    }

}