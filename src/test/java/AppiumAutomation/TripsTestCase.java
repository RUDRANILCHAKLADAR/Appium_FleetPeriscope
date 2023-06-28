package AppiumAutomation;

import android.SignInPage;
import android.TripPage;
import android.VehicleDetailsPage;
import android.VehiclePage;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ActionClass;
import utility.Utils;

import java.lang.reflect.Method;
import java.util.List;

public class TripsTestCase extends BaseTest{

    TripPage tp;
    SignInPage sp;
    VehiclePage vp;
    VehicleDetailsPage vdp;

    public void login() {
        actions.waitForVisibility(actions.findElement(sp.SignIn));
        actions.clickElement(actions.findElement(sp.SignIn));
        actions.waitForVisibility(actions.findElement(sp.Username));
        actions.sendKeys(sp.Username, "Fleet360A");
        actions.sendKeys(sp.Password, "Password@1");
        actions.clickElement(actions.findElement(sp.SignIn));
        if (currentPlatform == BaseTest.Platform.ANDROID) {
            actions.waitForVisibility(sp.permission_access);
            sp.permission_access.isDisplayed();
            actions.clickElement(sp.permission_access);

        } else {
            if (currentPlatform == BaseTest.Platform.iOS) {
                actions.waitForVisibility(sp.homeBottomBar);

            }
        }

    }

    @BeforeMethod()
    public void beforeMethod(Method m) {
        tp = new TripPage(driver);
        sp= new SignInPage(driver);
        vp= new VehiclePage(driver);
        vdp=new VehicleDetailsPage(driver);
    }

    public void clickAndSearch() {
        actions.waitForVisibility(actions.findElement(vp.listOfVehicles));
        vp.searchIcon.click();
        if (currentPlatform == BaseTest.Platform.ANDROID) {
            actions.waitForVisibility(vp.searchField);
            Assert.assertTrue(vp.searchIcon.isDisplayed());
            vp.searchField.sendKeys("AS221150001956");


        } else {
            if (currentPlatform == BaseTest.Platform.iOS) {
                vp.searchIcon.sendKeys("AS221150001956");

            }
        }
    }

    @AfterMethod
    public void afterMethod() {
    }

    @Test
    public void testTripScreenValidation() {
        login();
        vp.vehicleBottomBar.click();
        clickAndSearch();
        actions.waitForVisibility(vp.firstVehicle);
        actions.clickElement(vp.firstVehicle);
        actions.waitForVisibility(vdp.detailsTab);
        actions.clickElement(tp.tripTab);
        actions.waitForInvisibility(tp.loading);
//
//        if(Utils.isElementPresent(tp.getNoTrip()) && tp.getNoTrip().isDisplayed())
//        {
//            System.out.println("No Trips found");
//        }
//        else if((actions.findElement(tp.trips).isDisplayed()))
//        {   actions.waitForVisibility(tp.trips);
//            System.out.println("Trips are present" );
//            actions.clickElement(tp.listOfTrips.get(0));
//
//        }


        if(Utils.isElementPresent(tp.getNoTrip()) && tp.getNoTrip().isDisplayed())
        {
            System.out.println("No Trips found");
            String noTripText=tp.getNoTrip().getText();
            System.out.println("Empty list Trip Text is:" +noTripText);
        }
        else if((actions.listOfElements(tp.listOfTrips).size()!=0))
        {   actions.waitForVisibility(tp.trips);
            System.out.println("Trips are present" );
            int tripsCount= actions.listOfElements(tp.listOfTrips).size();
            System.out.println("Total number of trips present on current Date is:"+tripsCount);
            actions.clickElement(tp.listOfTrips.get(0));

        }



    }

}
