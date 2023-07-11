package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TripPage extends BasePage {
    public TripPage(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Trips")
    @AndroidFindBy(accessibility = "Trips")
    public WebElement tripTab;

    @iOSXCUITFindBy(accessibility = "TripCalendarButton")
    @AndroidFindBy(accessibility = "com.spireon.fleet.staging:id/trip_date_selector")
    public WebElement tripCalenderButton;

    @iOSXCUITFindBy(accessibility = "TripHistorySelectedDate")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/trip_date_selector")
    public WebElement tripCurrentDate;

    @iOSXCUITFindBy(accessibility = "autoRefreshIcon")
    @AndroidFindBy(accessibility = "com.spireon.fleet.staging:id/tv_auto_refresh")
    public WebElement autoRefreshIcon;

    @iOSXCUITFindBy(accessibility = "Back")
    public WebElement backButton;

    //@iOSXCUITFindBy(accessibility = "off")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@index='3']")
    public WebElement autoRefreshOn_Off;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@index='1']")
    public WebElement vehicleName;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/" +
            "XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/cv_trip']")
    public List<WebElement> trips;

    @iOSXCUITFindBy(accessibility = "This is where you'll find your vehicle's " +
            "trip history., The list is currently empty.")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_no_data")
    public WebElement noTrip;

    public WebElement getNoTrip() {
        return noTrip;
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/" +
            "XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/cv_trip']")
    public WebElement Trips;

    @iOSXCUITFindBy(accessibility = "Loading...")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/progress")
    public WebElement loading;


    public List<WebElement> tripLists() {
        return trips;
    }

    public void tripsCount() {
        int tripsCount = trips.size();
        System.out.println(tripsCount);
    }

    public void clickAnyTrip() {
        trips.get(0).click();

    }

    @iOSXCUITFindBy(accessibility = "ActivityDatePickerView")
    public WebElement datePicker;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"ActivityDatePickerView\"`]/XCUIElementTypeOther[1]")
    @AndroidFindBy(xpath = "//[@resource-id='com.spireon.fleet.staging:id/cv_trip']")
    public List<WebElement> calenderValues;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"ActivityDatePickerView\"`]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeStaticText")
    public WebElement currentMonth;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"ActivityDatePickerView\"`]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeCollectionView/XCUIElementTypeCell")
    public List<WebElement> dates;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"ActivityDatePickerView\"`]/XCUIElementTypeOther[2]/XCUIElementTypeOther/" +
            "XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeStaticText")
    public List<WebElement> days;

    @iOSXCUITFindBy(accessibility = "Ongoing Trip")
    public WebElement ongoingTrip;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText/[@index='0']")
    public WebElement moving_idle_Time;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[@index='1']")
    public WebElement startTime;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@index='2']")
    public WebElement stopTime;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@index='3']")
    public WebElement alertOnTrips;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[@index='4']")
    public WebElement startAddress;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@index='5']")
    public WebElement stopAddress;

    @iOSXCUITFindBy(accessibility = "Moving")
    public WebElement movingOngoingTrip;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[index='7']")
    public WebElement tripNumber;

    @iOSXCUITFindBy(accessibility = "datePickerPrev")
    public WebElement prevButton;


    public void selectCurrentDate() {
        for (int i = 0; i < dates.size(); i++) {
            int dateCount = dates.size();
            System.out.println(dateCount);

        }


    }

    @AndroidFindBy(xpath = "//android.view.View[@selected='true']")
    public WebElement selectedDate;


}
