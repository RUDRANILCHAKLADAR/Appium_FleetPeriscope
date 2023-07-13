package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LandmarkPage {

    public AppiumDriver driver;

    public LandmarkPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.spireon.fleet.staging:id/action_landmarks")
    public WebElement landmarkBottomBarIcon;

    @AndroidFindBy(xpath="//[@text='Landmarks']")
    public WebElement landmarkTitle;

    @AndroidFindBy(xpath="//[@resource-id='com.spireon.fleet.staging:id/landmark_show_count']")
    public WebElement landmarkTotalCnt;

    @AndroidFindBy(xpath="//[@resource-id='com.spireon.fleet.staging:id/card_landmark_list']")
    public WebElement landmarkList;

    @AndroidFindBy(xpath="//[@resource-id='com.spireon.fleet.staging:id/iv_landmark_icon']")
    public WebElement landmarkIcon;

    @AndroidFindBy(xpath="//[@resource-id='com.spireon.fleet.staging:id/rl_landmark_detail']")
    public WebElement landmarkDetails;

    @AndroidFindBy(xpath="//[@text='Refresh']")
    public WebElement refresh;




}
