package AppiumAutomation;

import android.SignInPage;
import android.VehiclePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VehicleTestCase extends BaseTest{

    VehiclePage vp;
    SignInPage sp;

    public void login(){
        actions.waitForVisibility(actions.findElement(sp.signIn));
        actions.clickElement(actions.findElement(sp.signIn));
        actions.waitForVisibility(actions.findElement(sp.userName));
        actions.sendKeys(sp.userName, "Fleet360A");
        actions.sendKeys(sp.password,"Password@1");
        actions.clickElement(actions.findElement(sp.signIn));
        actions.waitForVisibility(actions.findElement(sp.permission_access));
        if(actions.findElement(sp.permission_access).isDisplayed()){
        actions.waitForVisibility(actions.findElement(sp.permission_access));
        actions.clickElement(sp.permission_access);}
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



    @BeforeMethod()
    public void beforeMethod(Method m) {
        vp = new VehiclePage(driver);
        sp= new SignInPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
    }

    @Test
    public void testVehicleUIElements(){
        login();
        actions.waitForVisibility(actions.findElement(vp.vehicleBottomBar));
        actions.clickElement(vp.vehicleBottomBar);
        actions.waitForVisibility(actions.findElement(vp.vehicleTitle));
        Assert.assertTrue((vp.getVehicleTitle().isDisplayed()));
        //Assert.assertTrue((vp.vehicleLists()).isDisplayed()));
        Assert.assertTrue(vp.searchFld().isDisplayed());
        Assert.assertTrue(vp.filterOption().isDisplayed());
    }


}
