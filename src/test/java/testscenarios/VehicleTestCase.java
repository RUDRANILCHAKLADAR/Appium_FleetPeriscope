package testscenarios;

import pageobjects.SignInPage;
import pageobjects.VehiclePage;
import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import core.TestUtils;

public class VehicleTestCase extends BaseTest {

    VehiclePage vehiclePage;

    @Override
    protected void init() {
        vehiclePage = new VehiclePage(getDriver());
    }

    @Override
    protected void deInit() {

    }

    @Test
    public void testVehicleUIElements() {
        TestUtils.logInUser(vehiclePage, getDriver(), "Fleet360A", "Password@1");
        TestUtils.waitForVisibility(vehiclePage.vehicleBottomBar, getDriver());
        vehiclePage.vehicleBottomBar.click();
        TestUtils.waitForVisibility(vehiclePage.vehicleTitle, getDriver());
        Assert.assertTrue((vehiclePage.getVehicleTitle().isDisplayed()));
        //Assert.assertTrue((vp.vehicleLists()).isDisplayed()));
        Assert.assertTrue(vehiclePage.searchFld().isDisplayed());
        Assert.assertTrue(vehiclePage.filterOption().isDisplayed());
    }
}
