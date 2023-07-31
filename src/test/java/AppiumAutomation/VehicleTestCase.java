package AppiumAutomation;

import android.SignInPage;
import android.VehiclePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ActionClass;

public class VehicleTestCase extends BaseTest {

    VehiclePage vehiclePage;
    SignInPage signInPage;

    public void login() {
        ActionClass.waitForVisibility(signInPage.signIn, getDriver());
        signInPage.signIn.click();
        ActionClass.waitForVisibility(signInPage.userName, getDriver());
        ActionClass.sendKeys(signInPage.userName, "Fleet360A");
        ActionClass.sendKeys(signInPage.password, "Password@1");
        signInPage.signIn.click();
        ActionClass.waitForVisibility(signInPage.permission_access, getDriver());
        if (signInPage.permission_access.isDisplayed()) {
            ActionClass.waitForVisibility(signInPage.permission_access, getDriver());
            signInPage.permission_access.click();
        }
//        else
//       if(actions.findElement(sp.permission_access).isDisplayed()&&
//       actions.isElementPresent(sp.permission_access)){
//           actions.clickElement(sp.permission_access);
//       }
//       else if (!actions.isElementPresent(sp.permission_access)) {
//           System.out.println("No permission popup is displayed");
//
//       }
    }

    @Test
    public void testVehicleUIElements() {
        login();
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
