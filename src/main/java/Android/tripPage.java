package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TripPage {
    public AppiumDriver driver;

    public TripPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "Trips")
    @AndroidFindBy(accessibility = "Trips")
    public WebElement tripTab;

    @iOSXCUITFindBy(accessibility = "TripCalendarButton")
    @AndroidFindBy(accessibility = "com.spireon.fleet.staging:id/trip_date_selector")
    public WebElement tripCalenderButton;

    @iOSXCUITFindBy(accessibility = "TripHistorySelectedDate")
    public WebElement tripCalenderDate;

    @iOSXCUITFindBy(accessibility = "autoRefreshIcon")
    @AndroidFindBy(accessibility = "com.spireon.fleet.staging:id/tv_auto_refresh")
    WebElement autoRefreshIcon;

    @iOSXCUITFindBy(accessibility = "Back")
    public WebElement backButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTable\"")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/cv_trip']")
    public List<WebElement> listOfTrips;

    @iOSXCUITFindBy(accessibility = "This is where you'll find your vehicle's " +
            "trip history., The list is currently empty.")
    public WebElement noTrip;

    public WebElement getNoTrip(){return noTrip;}

    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTable\"")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/cv_trip']")
    public WebElement trips;

    @iOSXCUITFindBy(accessibility = "Loading...")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/progress")
    public WebElement loading;


    public List<WebElement> tripLists(){
        return listOfTrips;
    }

    public void tripsCount() {
        int tripsCount=listOfTrips.size();
        System.out.println(tripsCount);
    }

    public void clickAnyTrip(){
        listOfTrips.get(1).click();

    }



    //trips: id="com.spireon.fleet.staging:id/swipe_trips"






}
