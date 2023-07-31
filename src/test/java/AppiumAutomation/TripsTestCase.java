package AppiumAutomation;

import android.SignInPage;
import android.TripPage;
import android.VehicleDetailsPage;
import android.VehiclePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ActionClass;
import utility.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TripsTestCase extends BaseTest {

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
        ActionClass.waitForVisibility(signInPage.signIn, getDriver());
        signInPage.signIn.click();
        ActionClass.waitForVisibility(signInPage.userName, getDriver());
        ActionClass.sendKeys(signInPage.userName, "Fleet360A");
        ActionClass.sendKeys(signInPage.password, "Password@1");
        signInPage.signIn.click();
        if (currentPlatform == BaseTest.Platform.ANDROID) {
            ActionClass.waitForVisibility(signInPage.permission_access, getDriver());
            signInPage.permission_access.isDisplayed();
            signInPage.permission_access.click();

        } /*else {
            if (currentPlatform == BaseTest.Platform.iOS) {
                ActionClass.waitForVisibility(signInPage.homeBottomBar, getDriver());

            }
        }*/
        ActionClass.waitForVisibility(signInPage.homeBottomBar, getDriver());
    }

    public void clickAndSearch() {
        ActionClass.waitForVisibility(vehiclePage.listOfVehicles, getDriver());
        vehiclePage.searchIcon.click();
        if (currentPlatform == BaseTest.Platform.ANDROID) {
            ActionClass.waitForVisibility(vehiclePage.searchField, getDriver());
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

    @Test(priority = 0)
    public void testTripScreenValidation() {
        login();
        vehiclePage.vehicleBottomBar.click();
        clickAndSearch();
        ActionClass.waitForVisibility(vehiclePage.firstVehicle, getDriver());
        vehiclePage.firstVehicle.click();
        ActionClass.waitForVisibility(vehicleDetailsPage.detailsTab, getDriver());
        tripPage.tripTab.click();
        ActionClass.waitForInvisibility(tripPage.loading, getDriver());
        if (Utils.isElementPresent(tripPage.getNoTrip()) && tripPage.getNoTrip().isDisplayed()) {
            System.out.println("No Trips found");
            String noTripText = tripPage.getNoTrip().getText();
            System.out.println("Empty list Trip Text is:" + noTripText);
        } else if (tripPage.trips.size() > 0) {
            ActionClass.waitForInvisibility(tripPage.loading, getDriver());
            System.out.println("Trips are present");
            int tripsCount = tripPage.trips.size();
            System.out.println("Total number of trips present on current Date is:" + tripsCount);
            ActionClass.clickElement(tripPage.trips.get(0), getDriver());
            ActionClass.clickElement(tripPage.backButton, getDriver());

        }

    }


    @Test(priority = 1)
    public void testClickOnCalender() {
        ActionClass.clickElement(tripPage.tripCalenderButton, getDriver());
        ActionClass.waitForVisibility(tripPage.datePicker, getDriver());
        String currentMonthYearVal = tripPage.currentMonth.getText();
        System.out.println(currentMonthYearVal);
        //Total Number of dates visible on the calendar view
        int totalNumberOfDates = tripPage.dates.size();
        System.out.println(totalNumberOfDates);
        LocalDate currentDate = LocalDate.now();
        String currentDateString = currentDate.format(DateTimeFormatter.ofPattern("d/MM/yyyy"));
        String[] splitter = currentDateString.split("/");
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
        tripPage.tripCalenderButton.click();
        ActionClass.waitForVisibility(tripPage.datePicker, getDriver());
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


    @Test(priority = 2)
    public void testCurrentDateValidation() {
        String currentDate = tripPage.tripCurrentDate.getText();
        System.out.println("Today's date is: " + currentDate);

    }

    //C23937- Verify user is able to turn on/off auto refresh button
    @Test(priority = 3)
    public void testRefreshButtonFunctionality() {
        Assert.assertTrue(tripPage.autoRefreshIcon.isDisplayed());
        if (tripPage.autoRefreshIcon.isDisplayed()) {
            String refreshOn = tripPage.autoRefreshOn_Off.getText();
            System.out.println("Auto refresh is:" + refreshOn);
            tripPage.autoRefreshIcon.click();
            String refreshOff = tripPage.autoRefreshOn_Off.getText();
            System.out.println("Auto refresh is:" + refreshOff);
        } else if (!tripPage.autoRefreshIcon.isDisplayed()) {
            System.out.println("Auto refresh is not visible");
        }

    }


    //C22391- Verify Trip list screen UI is matching with Zeplin
    @Test(priority = 4)
    public void testTripUiElement() {
        Assert.assertTrue(tripPage.autoRefreshIcon.isDisplayed());
        Assert.assertTrue(tripPage.backButton.isDisplayed());
        Assert.assertTrue(tripPage.vehicleName.isDisplayed());
        Assert.assertTrue(tripPage.tripCurrentDate.isDisplayed());
        Assert.assertTrue(tripPage.tripCalenderButton.isDisplayed());

    }

    //Scrolling functionality
    // Pull to refresh functionality
    @Test(priority = 5)
    public void testPullToRefreshAndScrollTripScreen() {
        ActionClass.pullToRefresh(getDriver());
        ActionClass.scrollToEnd(getDriver());

    }

    @Test(priority = 6)
    public void testTypesOfTrips() {
        for (int i = 0; i < tripPage.trips.size(); i++) {
            if (Utils.isElementPresent(tripPage.ongoingTrip) && tripPage.ongoingTrip.isDisplayed()) {
                System.out.println("Ongoing Trip is present");
                System.out.println("Start time is :" + tripPage.startTime.getText());
                System.out.println("Start address is :" + tripPage.startAddress.getText());
                System.out.println(("Vehicle's moving, idle time is :" + tripPage.moving_idle_Time.getText()));
                Assert.assertTrue(tripPage.movingOngoingTrip.isDisplayed());
                Assert.assertFalse(tripPage.stopTime.isDisplayed());
            } else if (Utils.isElementPresent(tripPage.tripNumber) && tripPage.tripNumber.isDisplayed()) {
                System.out.println("Full Trip is present");
                System.out.println("Start time is :" + tripPage.startTime.getText());
                Assert.assertTrue(tripPage.stopTime.isDisplayed());
                System.out.println("stop time is :" + tripPage.stopTime.getText());
                System.out.println("Start address is :" + tripPage.startAddress.getText());
                System.out.println("Stop address is :" + tripPage.stopAddress.getText());
                System.out.println(("Vehicle's moving, idle time is :" + tripPage.moving_idle_Time.getText()));
                Assert.assertFalse(tripPage.movingOngoingTrip.isDisplayed());
                System.out.println("Trip count number is:" + tripPage.tripNumber.getText());
            }
        }
    }


}
