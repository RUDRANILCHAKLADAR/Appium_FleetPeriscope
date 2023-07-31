package AppiumAutomation;

import android.SignInPage;
import android.VehiclePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ActionClass;

public class VehicleTestCase extends BaseTest {

    VehiclePage vehiclePage;
    SignInPage signInPage;

    @Test
    public void testVehicleUIElements() {
        ActionClass.logInUser(signInPage, getDriver(), "Fleet360A", "Password@1");
        ActionClass.waitForVisibility(vehiclePage.vehicleBottomBar, getDriver());
        vehiclePage.vehicleBottomBar.click();
        ActionClass.waitForVisibility(vehiclePage.vehicleTitle, getDriver());
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
