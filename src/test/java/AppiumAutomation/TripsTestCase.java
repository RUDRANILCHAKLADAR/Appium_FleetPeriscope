package AppiumAutomation;

import android.SignInPage;
import android.TripPage;
import android.VehicleDetailsPage;
import android.VehiclePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TripsTestCase extends BaseTest{

    private SignInPage signInPage;
    private VehiclePage vehiclePage;
    private TripPage tripPage;
    private VehicleDetailsPage vehicleDetailsPage;

    @Override
    protected void initPage() {
        signInPage = new SignInPage(getDriver());
        vehiclePage = new VehiclePage(getDriver());
        tripPage = new TripPage(getDriver());
        vehicleDetailsPage = new VehicleDetailsPage(getDriver());
    }

       public void login() {
        actions.waitForVisibility(actions.findElement(signInPage.signIn));
        actions.clickElement(actions.findElement(signInPage.signIn));
        actions.waitForVisibility(actions.findElement(signInPage.userName));
        actions.sendKeys(signInPage.userName, "Fleet360A");
        actions.sendKeys(signInPage.password, "Password@1");
        actions.clickElement(actions.findElement(signInPage.signIn));
        if (currentPlatform == BaseTest.Platform.ANDROID) {
            actions.waitForVisibility(signInPage.permission_access);
            signInPage.permission_access.isDisplayed();
            actions.clickElement(signInPage.permission_access);

        } else {
            if (currentPlatform == BaseTest.Platform.iOS) {
                actions.waitForVisibility(signInPage.homeBottomBar);

            }
        }
        actions.waitForVisibility(signInPage.homeBottomBar);
    }

    public void clickAndSearch() {
        actions.waitForVisibility(actions.findElement(vehiclePage.listOfVehicles));
        vehiclePage.searchIcon.click();
        if (currentPlatform == BaseTest.Platform.ANDROID) {
            actions.waitForVisibility(vehiclePage.searchField);
            Assert.assertTrue(vehiclePage.searchIcon.isDisplayed());
            vehiclePage.searchField.sendKeys("AS820390001479");


        } else {
            if (currentPlatform == BaseTest.Platform.iOS) {
                vehiclePage.searchIcon.sendKeys("AS820390001479");

            }
        }
    }




    //C22530- Tap on Trips
    //C22510- Verify user is able to click on dates in calendar component
    //C105323- Tap on any trip list item
    //C146621-Verify trips empty screen*/

    @Test
    public void testTripScreenValidation() {
        login();
        vehiclePage.vehicleBottomBar.click();
        clickAndSearch();
        actions.waitForVisibility(vehiclePage.firstVehicle);
        actions.clickElement(vehiclePage.firstVehicle);
        actions.waitForVisibility(vehicleDetailsPage.detailsTab);
        actions.clickElement(tripPage.tripTab);
        actions.waitForInvisibility(tripPage.loading);
        if(Utils.isElementPresent(tripPage.getNoTrip()) && tripPage.getNoTrip().isDisplayed())
        {
            System.out.println("No Trips found");
            String noTripText= tripPage.getNoTrip().getText();
            System.out.println("Empty list Trip Text is:" +noTripText);
        }
        else if(tripPage.trips.size()>0)
        {   actions.waitForInvisibility(tripPage.loading);
            System.out.println("Trips are present" );
            int tripsCount= tripPage.trips.size();
            System.out.println("Total number of trips present on current Date is:"+tripsCount);
            actions.clickElement(tripPage.trips.get(0));
            actions.clickElement(tripPage.backButton);

        }

    }


    @Test(priority = 1)
    public void testClickOnCalender() {
        actions.clickElement(tripPage.tripCalenderButton);
        actions.waitForVisibility(tripPage.datePicker);
        String currentMonthYearVal = tripPage.currentMonth.getText();
        System.out.println(currentMonthYearVal);
        //Total Number of dates visible on the calender view
        int totalNumberOfDates = tripPage.dates.size();
        System.out.println(totalNumberOfDates);
        LocalDate currentDate = LocalDate.now();
        String currentDateString = currentDate.format(DateTimeFormatter.ofPattern("d/MM/yyyy"));
        String splitter[] = currentDateString.split("/");
        //System.out.println("System date:"+splitter);
        String targetDate = splitter[0];
        for (WebElement date : tripPage.dates) {
            String dateText = date.findElement(By.xpath("//XCUIElementTypeOther/XCUIElementTypeStaticText")).getText();
            //System.out.println("dateText:"+dateText);
            if (dateText.equals(targetDate)) {
                date.click();
                break;
            }

        }
        actions.clickElement(tripPage.tripCalenderButton);
        actions.waitForVisibility(tripPage.datePicker);
        WebElement selectedDate = tripPage.datePicker.findElement(By.className("highlighted"));
        if (selectedDate.getText().equals(targetDate)) {
            System.out.println("The selected date is currently highlighted.");
        } else {
            System.out.println("The selected date is not highlighted.");
        }

        LocalDate localDatePrevious = currentDate.minusDays(1);
        System.out.println("\nNext Day is :- \n"
                + localDatePrevious);

//        LocalDate localDateNext = currentDate.plusDays(1);
//        String localDateNextString = localDateNext.format(DateTimeFormatter.ofPattern("d/MM/yyyy"));
//        System.out.println(localDateNextString);


    }


    @Test(priority = 1)
    public void testCurrentDateValidation(){
      String currentDate= tripPage.tripCurrentDate.getText();
      System.out.println("Today's date is: "+currentDate);

    }

    //C23937- Verify user is able to turn on/off auto refresh button
    @Test(priority = 2)
    public void testRefreshButtonFunctionality(){
        Assert.assertTrue(tripPage.autoRefreshIcon.isDisplayed());
        if(tripPage.autoRefreshIcon.isDisplayed())
        {
            String refreshOn= tripPage.autoRefreshOn_Off.getText();
            System.out.println("Auto refresh is:"+ refreshOn);
            tripPage.autoRefreshIcon.click();
            String refreshOff= tripPage.autoRefreshOn_Off.getText();
            System.out.println("Auto refresh is:"+ refreshOff);
        }
        else if(!tripPage.autoRefreshIcon.isDisplayed()){
            System.out.println("Auto refresh is not visible");
        }

    }


    //C22391- Verify Trip list screen UI is matching with Zeplyn
    @Test(priority = 3)
    public void testTripUiElement(){
        Assert.assertTrue(tripPage.autoRefreshIcon.isDisplayed());
        Assert.assertTrue(tripPage.backButton.isDisplayed());
        Assert.assertTrue(tripPage.vehicleName.isDisplayed());
        Assert.assertTrue(tripPage.tripCurrentDate.isDisplayed());
        Assert.assertTrue(tripPage.tripCalenderButton.isDisplayed());

    }
     //Scrolling functionality
     // Pull to refresh functionality
    @Test(priority = 4)
    public void testPullToRefreshAndScrollTripScreen(){
        actions.pullToRefresh();
        actions.scrollToEnd();

    }

    @Test(priority = 5)
    public void testTypesOfTrips(){
        for(int i = 0; i< tripPage.trips.size(); i++){
            if(Utils.isElementPresent(tripPage.ongoingTrip)&& tripPage.ongoingTrip.isDisplayed()){
                System.out.println("Ongoing Trip is present");
                System.out.println("Start time is :"+ tripPage.startTime.getText());
                System.out.println("Start address is :"+ tripPage.startAddress.getText());
                System.out.println(("Vehicle's moving, idle time is :"+ tripPage.moving_idle_Time.getText()));
                Assert.assertTrue(tripPage.movingOngoingTrip.isDisplayed());
                Assert.assertFalse(tripPage.stopTime.isDisplayed());
            }
            else if(Utils.isElementPresent(tripPage.tripNumber)&& tripPage.tripNumber.isDisplayed()){
                System.out.println("Full Trip is present");
                System.out.println("Start time is :"+ tripPage.startTime.getText());
                Assert.assertTrue(tripPage.stopTime.isDisplayed());
                System.out.println("stop time is :"+ tripPage.stopTime.getText());
                System.out.println("Start address is :"+ tripPage.startAddress.getText());
                System.out.println("Stop address is :"+ tripPage.stopAddress.getText());
                System.out.println(("Vehicle's moving, idle time is :"+ tripPage.moving_idle_Time.getText()));
                Assert.assertFalse(tripPage.movingOngoingTrip.isDisplayed());
                System.out.println("Trip count number is:"+ tripPage.tripNumber.getText());
            }
        }
    }



}
