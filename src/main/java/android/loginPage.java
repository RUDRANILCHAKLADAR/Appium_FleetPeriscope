package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    //Chosse Account popup ios
    @iOSXCUITFindBy(accessibility = "Cancel")
    private WebElement cancel;

    @iOSXCUITFindBy(accessibility = "Done")
    private WebElement done;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Choose Account\"`]")
    private WebElement chooseAccountText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeImage")
    private  WebElement tickMark;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    private WebElement accountNameFirst;

    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTable\"")
    private List<WebElement> listOfAccounts;

    //Home Screen

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Map\"`]")
    private WebElement mapText;

    @iOSXCUITFindBy(accessibility = "Home")
    private WebElement homeBottomBar;



    //Logot
    @iOSXCUITFindBy(accessibility = "Cancel")
    public WebElement cancelBtn;

    @iOSXCUITFindBy(accessibility = "Are you sure you want to Logout?")
    private WebElement logoutTxt;





}
