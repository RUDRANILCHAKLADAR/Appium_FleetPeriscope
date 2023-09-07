package pageobjects;

import core.testrail.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasePage {

    public SignInPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_forgot_password")
    @iOSXCUITFindBy(accessibility = "Forgot your password?")
    public WebElement forgotPassword;


    @AndroidFindBy(id = "com.spireon.fleet.staging:id/login_msg")
    @iOSXCUITFindBy(accessibility = "with your username and password")
    public WebElement loginMsg;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Sign In\"`]")
    public WebElement SignInTxt;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ImageButton")
    @iOSXCUITFindBy(accessibility = "Back")
    public WebElement backButton;

    @iOSXCUITFindBy(accessibility = "Sign In")
    public WebElement forgotPwBackBtn;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(accessibility = "Please enter a valid password")
    public WebElement errorMessage;

    @AndroidFindBy(id = "android:id/button2")
    @iOSXCUITFindBy(accessibility = "OK")
    public WebElement ok_cancel_Button;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "The credentials entered do not match our records. Verify your username and password.")
    public WebElement InvalidLoginErrMsg;

    //@AndroidFindBy(id = "android:id/button3")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    public WebElement okButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
    public WebElement anyAccount;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "Done")
    public WebElement selectBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    public WebElement homeScreenTitle;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView")
    public WebElement ForgotPasswordTxt;

    @iOSXCUITFindBy(iOSClassChain =
            "**/XCUIElementTypeStaticText[`label == \"Forgot Password?\"`]")
    public WebElement iosForgotPwTxt;


    // Locate the first CheckedTextView element within the ListView
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.CheckedTextView[4]")
    public WebElement radioButton;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.CheckedTextView[1]")
    private WebElement radioButton2;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/iv_title")
    public WebElement title;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/parentPanel")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    public WebElement Account_Dialogue_Screen;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout")
    public WebElement HomeScreen;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Map\"`]")
    public WebElement mapTextHomeScreen;

    @iOSXCUITFindBy(accessibility = "showpassword")
    public WebElement showPwdIcon;

    public WebElement getRadioButton() {
        return radioButton;
    }


    public boolean isRadioButtonChecked() {
        return radioButton.getAttribute("checked").equals("true");
    }

    public WebElement getSignIn() {
        return signIn;
    }

    public WebElement getUsername() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }


    public String getSignIntxt() {
        return SignInTxt.getText();
    }


    public String getErrorMsg() {
        return errorMessage.getText();
    }


    public String getInvalidLoginErrMsg() {
        return InvalidLoginErrMsg.getText();
    }


    public String getNetworkErrMsg() {
        return errorMessage.getText();
    }

    public WebElement getNetworkErr() {
        return errorMessage;
    }


    public WebElement getSelectbtn() {
        return selectBtn;
    }

    public String getHomeScreenTitle() {
        return homeScreenTitle.getText();
    }

    public String getForgotPasswordTxt() {
        return ForgotPasswordTxt.getText();
    }


    public WebElement getTitle() {
        return title;
    }

    public WebElement getAccount_Dialogue_Screen() {
        return Account_Dialogue_Screen;
    }

    public WebElement getRadioButton2() {
        return radioButton2;
    }

    public WebElement getHomeScreen() {
        return HomeScreen;
    }


    public void setUsername(String uname) {
        userName.clear();
        userName.sendKeys(uname);
    }

    public void setPassword(String pwd) {
        password.clear();
        password.sendKeys(pwd);
    }


    public String getErrorMessage() {
        return errorMessage.getText();
    }


}


