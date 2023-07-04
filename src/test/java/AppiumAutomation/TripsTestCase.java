package AppiumAutomation;

import android.SignInPage;
import android.TripPage;
import android.VehicleDetailsPage;
import android.VehiclePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ActionClass;
import utility.Utils;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.apache.commons.lang3.compare.ComparableUtils.ge;

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


    /*C22530- Tap on Trips
    C22510- Verify user is able to click on dates in calendar component
    C105323- Tap on any trip list item
    C146621-Verify trips empty screen*/

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


//   @Test(priority = 4)
//    public void testClickOnCalender(){
//        actions.clickElement(tp.tripCalenderButton);
//        actions.waitForVisibility(tp.datePicker);
//        String currentMonth=tp.currentMonth.getText();
//        System.out.println(currentMonth);
//        //Total Number of dates visible on the calender view
//        int totalNumberOfDates= tp.dates.size();
//        System.out.println(totalNumberOfDates);
//
//        for(int i=0;i<totalNumberOfDates;i++){
//            if(tp.dates.get(i).isSelected()){
//                System.out.println(i);
//            }
//            LocalDate currentDate = LocalDate.now();
//            String currentDateString = currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//
//        }
//        }


    @Test(priority = 1)
    public void testCurrentDateValidation(){
      String currentDate= tp.tripCurrentDate.getText();
      System.out.println("Today's date is: "+currentDate);

    }

    //C23937- Verify user is able to turn on/off auto refresh button
    @Test(priority = 2)
    public void testRefreshButtonFunctionality(){
        Assert.assertTrue(tp.autoRefreshIcon.isDisplayed());
        if(tp.autoRefreshIcon.isDisplayed())
        {
            String refreshOn=tp.autoRefreshOn_Off.getText();
            System.out.println("Auto refresh is:"+ refreshOn);
            tp.autoRefreshIcon.click();
            String refreshOff=tp.autoRefreshOn_Off.getText();
            System.out.println("Auto refresh is:"+ refreshOff);
        }
        else if(!tp.autoRefreshIcon.isDisplayed()){
            System.out.println("Auto refresh is not visible");
        }

    }


    //C22391- Verify Trip list screen UI is matching with Zeplyn
    @Test(priority = 3)
    public void testTripUiElement(){
        Assert.assertTrue(tp.autoRefreshIcon.isDisplayed());
        Assert.assertTrue(tp.backButton.isDisplayed());
        Assert.assertTrue(tp.vehicleName.isDisplayed());
        Assert.assertTrue(tp.tripCurrentDate.isDisplayed());
        Assert.assertTrue(tp.tripCalenderButton.isDisplayed());

    }
     //Scrolling functionality
     // Pull to refresh functionality
    @Test(priority = 4)
    public void testPullToRefreshAndScrollTripScreen(){
        actions.pullToRefresh();
        actions.scrollToEnd();

    }

    @Test
    public void testTypesOfTrips(){
        for(int i=0;i<tp.listOfTrips.size();i++){
            if(Utils.isElementPresent(tp.ongoingTrip)&&tp.ongoingTrip.isDisplayed()){
                System.out.println("Ongoing Trip is present");
                System.out.println("Start time is :"+ tp.startTime.getText());
                Assert.assertFalse(tp.stopTime.isDisplayed());
                System.out.println("Start address is :"+ tp.startAddress.getText());
                System.out.println(("Vehicle's moving, idle time is :"+tp.moving_idle_Time.getText()));
                Assert.assertTrue(tp.movingOngoingTrip.isDisplayed());
            }
            else if(Utils.isElementPresent(tp.tripNumber)&&tp.tripNumber.isDisplayed()){
                System.out.println("Full Trip is present");
                System.out.println("Start time is :"+ tp.startTime.getText());
                Assert.assertTrue(tp.stopTime.isDisplayed());
                System.out.println("stop time is :"+ tp.stopTime.getText());
                System.out.println("Start address is :"+ tp.startAddress.getText());
                System.out.println("Stop address is :"+ tp.stopAddress.getText());
                System.out.println(("Vehicle's moving, idle time is :"+tp.moving_idle_Time.getText()));
                Assert.assertFalse(tp.movingOngoingTrip.isDisplayed());
                System.out.println("Trip count number is:"+tp.tripNumber.getText());
            }
        }
    }

}
