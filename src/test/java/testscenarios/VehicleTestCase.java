package testscenarios;

import pageobjects.SignInPage;
import pageobjects.VehiclePage;
import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import core.TestUtils;

public class VehicleTestCase extends BaseTest {

    VehiclePage vehiclePage;
    SignInPage signInPage;

    @Test
    public void testVehicleUIElements() {
        TestUtils.logInUser(signInPage, getDriver(), "Fleet360A", "Password@1");
        TestUtils.waitForVisibility(vehiclePage.vehicleBottomBar, getDriver());
        vehiclePage.vehicleBottomBar.click();
        TestUtils.waitForVisibility(vehiclePage.vehicleTitle, getDriver());
        Assert.assertTrue((vehiclePage.getVehicleTitle().isDisplayed()));
        //Assert.assertTrue((vp.vehicleLists()).isDisplayed()));
        Assert.assertTrue(vehiclePage.searchFld().isDisplayed());
        Assert.assertTrue(vehiclePage.filterOption().isDisplayed());
    }


    @Override
    protected void initPage() {
        vehiclePage = new VehiclePage(getDriver());
        signInPage = new SignInPage(getDriver());
    }
}
