package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/bt_sign_in")
    @iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeButton[`label == \"SIGN IN\"`]")
    public WebElement signIn;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/ed_username")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Username\"`]")
    public WebElement userName;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/ed_password")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`value == \"Password\"`]")
    public WebElement password;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    public WebElement permission_access;

    @iOSXCUITFindBy(accessibility = "Home")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/bb_bottom_bar_icon")
    public WebElement homeBottomBar;

    @AndroidFindBy (id = "com.spireon.fleet.staging:id/action_account")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Account\"`]")
    public WebElement Account_icon;

    @AndroidFindBy (id = "com.spireon.fleet.staging:id/action_logout")
    @iOSXCUITFindBy(accessibility = "Logout")
    public WebElement Logout;

    @AndroidFindBy (id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "Confirm")
    public WebElement Confirm_btn;
}
