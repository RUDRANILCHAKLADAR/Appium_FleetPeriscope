//package AppiumAutomation;
//
//import android.SignInPage;
//import android.vehiclePage;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import utility.ActionClass;
//
//import java.lang.reflect.Method;
//
//public class vehicleTestCase extends BaseTest{
//
//    vehiclePage vp;
//    SignInPage sp;
//
//    public void login(){
//        actions.waitForVisibility(actions.findElement(sp.SignIn));
//        actions.clickElement(actions.findElement(sp.SignIn));
//        actions.waitForVisibility(actions.findElement(sp.Username));
//        actions.sendKeys(sp.Username, "Fleet360A");
//        actions.sendKeys(sp.Password,"Password@1");
//        actions.clickElement(actions.findElement(sp.SignIn));
//        actions.waitForVisibility(actions.findElement(sp.permission_access));
//        if(actions.findElement(sp.permission_access).isDisplayed()){
//        actions.waitForVisibility(actions.findElement(sp.permission_access));
//        actions.clickElement(sp.permission_access);}
////        else
////       if(actions.findElement(sp.permission_access).isDisplayed()&&
////       actions.isElementPresent(sp.permission_access)){
////           actions.clickElement(sp.permission_access);
////       }
////       else if (!actions.isElementPresent(sp.permission_access)) {
////           System.out.println("No permission popup is displayed");
////
////       }
//    }
//
//
//
//    @BeforeMethod()
//    public void beforeMethod(Method m) {
//        vp = new vehiclePage(driver);
//        sp= new SignInPage(driver);
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//    }
//
//    @Test
//    public void testVehicleUIElements(){
//        login();
//        actions.waitForVisibility(actions.findElement(vp.vehicleBottomBar));
//        actions.clickElement(vp.vehicleBottomBar);
//        actions.waitForVisibility(actions.findElement(vp.vehicleTitle));
//        Assert.assertTrue((vp.getVehicleTitle().isDisplayed()));
//        Assert.assertTrue((vp.vehicleLists().isDisplayed()));
//        Assert.assertTrue(vp.searchFld().isDisplayed());
//        Assert.assertTrue(vp.filterOption().isDisplayed());
//    }
//
//
//}
