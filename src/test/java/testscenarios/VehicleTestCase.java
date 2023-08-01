package testscenarios;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobjects.SignInPage;
import pageobjects.VehiclePage;
import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import core.TestUtils;

import java.time.Duration;

public class VehicleTestCase extends BaseTest {

    VehiclePage vehiclePage;

    @Override
    protected void init() {
        vehiclePage = new VehiclePage(getDriver());
    }

    @Override
    protected void deInit() {

    }

    @BeforeClass
    public void beforeClass(){
        vehiclePageSetup();
    }

    public void vehiclePageSetup(){
        TestUtils.logInUser(vehiclePage, getDriver(), "Fleet360A", "Password@1");
        TestUtils.waitForVisibility(vehiclePage.vehicleBottomBar, getDriver());
        vehiclePage.vehicleBottomBar.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(vehiclePage.vehicleLists()));
        Assert.assertTrue((vehiclePage.vehicleLists().isDisplayed()));
    }
    @AfterClass
    public void afterClass(){
        TestUtils.logOutUser(vehiclePage);
    }


    //	C19949	Verify vehicle list screen UI is matching with Zeplin comp
    //	C19950	Verify list of vehicles are shown properly
    @Test(priority = 0)
    public void testVehicleUIElements() {
        TestUtils.waitForVisibility(vehiclePage.vehicleTitle, getDriver());
        Assert.assertTrue((vehiclePage.getVehicleTitle().isDisplayed()));
        Assert.assertTrue((vehiclePage.vehicleLists()).isDisplayed());
        Assert.assertTrue(vehiclePage.searchField().isDisplayed());
        Assert.assertTrue(vehiclePage.filterOption().isDisplayed());
    }

    //C19965	Verify the vehicle status is shown correctly on the vehicle list screen
    @Test(priority = 1)
    public void testVehicleStatusDetailsDisplay()
    {
        Assert.assertTrue(vehiclePage.getVehicleList().get(0).isDisplayed(), "Vehicle Status is Not Displayed");
    }

}
