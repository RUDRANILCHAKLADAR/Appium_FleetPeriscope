package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    public AppiumDriver driver;

    public loginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/bt_sign_in")
    @iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeButton[`label == \"SIGN IN\"`]")
    public WebElement SignIn;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/ed_username")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Username\"`]")
    public WebElement Username;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/ed_password")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`value == \"Password\"`]")
    public WebElement Password;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ImageButton")
    @iOSXCUITFindBy(accessibility = "Back")
    public WebElement  backButton;

    @iOSXCUITFindBy(accessibility = "Forgot your password?")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_forgot_password")
    public WebElement forgotPassword;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Forgot Password?\"`]")
    public WebElement forgotPwdHeader;

    public WebElement getSignIn()
    {
        return SignIn;
    }



}
