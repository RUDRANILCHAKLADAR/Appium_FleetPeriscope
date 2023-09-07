package pageobjects;

import core.testrail.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(AppiumDriver driver) {
        super(driver);
    }

    public String str = "Enter the email address you used to register. We'll send you an email with reset instructions.";

    public String frgt_psswrd = "Forgot Password";

    public String Need_help_txt = "If you still need help, contact";

    public String Email_register_text = "Enter the email address you used to register. We'll send you an email with reset instructions.";

    public String Valid_Email_text = "Please enter valid Email ID.";

    public String Registered_Email_text = "Please enter your registered Email ID and try again.";

    public String Reset_txt = "Reset instruction sent successfully!";

    public String support = "Support";

    public String network_Err_msg = "Please check your network connection and try again.";

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SIGN IN\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/bt_sign_in")
    private WebElement SignIn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Forgot your password?\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_forgot_password")
    private WebElement forgotpassword;

    @iOSXCUITFindBy(accessibility = "Enter the email address that you used to register. We'll send you an email with reset instructions.")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/login_msg")
    private WebElement forgotpasswordmsg;

    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Email\"")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/ed_email")
    private WebElement email;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SUBMIT\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/bt_send_instructions")
    private WebElement Submit_btn;

    @iOSXCUITFindBy(accessibility = "Please enter valid Email ID.")
    @AndroidFindBy(id = "android:id/message")
    private WebElement ErrorMsg;

    @iOSXCUITFindBy(accessibility = "Please enter your registered email-id and try again")
    @AndroidFindBy(id = "android:id/message")
    private WebElement UnregisteredEmailErrorMsg;

    @iOSXCUITFindBy(accessibility = "OK")
    @AndroidFindBy(id = "android:id/button2")
    private WebElement OK_Btn;

    @iOSXCUITFindBy(accessibility = "OK")
    @AndroidFindBy(id = "android:id/button2")
    private WebElement Tryagain_Btn;

    @iOSXCUITFindBy(accessibility = "Reset Instruction Sent Successfully!")
    @AndroidFindBy(id = "android:id/message")
    private WebElement ResetMsg;

    @iOSXCUITFindBy(accessibility = "OK")
    @AndroidFindBy(id = "android:id/button3")
    private WebElement Okbtn2;

    @iOSXCUITFindBy(accessibility = "Sign In")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
    private WebElement BackBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Forgot Password?\"")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Forgot Password']")
    private WebElement ForgotPswrdScreen;

    @iOSXCUITFindBy(accessibility = "If you still need help, contact")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='If you still need help, contact']")
    private WebElement NeedHelp;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"FleetLocate Support\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/txt_kahu_support")
    private WebElement FleetLocateSupport;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Support\"")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Support']")
    private WebElement Support_Title;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"EMAIL SUPPORT\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/btn_support")
    private WebElement EmailSupport_Btn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CALL SUPPORT\"`]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='CALL SUPPORT']")
    private WebElement CallSupport_Btn;

    @iOSXCUITFindBy(accessibility = "Please check your internet connection and try again.")
    @AndroidFindBy(id = "android:id/message")
    private WebElement NetworkErrorMsg;

    @iOSXCUITFindBy(accessibility = "Retry")
    @AndroidFindBy(id = "android:id/button3")
    private WebElement OkBtn3;

    @iOSXCUITFindBy(accessibility = "Forgot Password?")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
    private WebElement BackSupport;

    public WebElement unrgstrederrmsg() {
        return UnregisteredEmailErrorMsg;
    }

    public WebElement getBackSupport() {
        return BackSupport;
    }

    public void ClickBackSupport() {
        BackSupport.click();
    }

    public WebElement getOkBtn3() {
        return OkBtn3;
    }

    public void ClickOkbtn3() {
        OkBtn3.click();
    }

    public String getNetworkErrorMsg() {
        return NetworkErrorMsg.getText();
    }


    public WebElement getEmailSupport_Btn() {
        return EmailSupport_Btn;
    }

    public WebElement getCallSupport_Btn() {
        return CallSupport_Btn;
    }

    public String getSupport_Title() {
        return Support_Title.getText();
    }


    public WebElement getFleetLocateSupport() {
        return FleetLocateSupport;
    }

    public String getNeedHelp() {
        return NeedHelp.getText();
    }

    public String getForgotPswrdScreen() {
        return ForgotPswrdScreen.getText();
    }

    public WebElement getBackBtn() {
        return BackBtn;
    }

    public String getResetMsg() {
        return ResetMsg.getText();
    }

    public WebElement getOkbtn2() {
        return Okbtn2;
    }

    public void ClickOkbtn2() {
        Okbtn2.click();
    }

    public WebElement getTryagain_Btn() {
        return Tryagain_Btn;
    }

    public void ClickTryAgain() {
        Tryagain_Btn.click();
    }

    public String getUnregisteredEmailErrorMsg() {
        return UnregisteredEmailErrorMsg.getText();
    }

    public String getErrorMsg() {
        return ErrorMsg.getText();
    }

    public WebElement getOK_Btn() {
        return OK_Btn;
    }

    public void ClickOk_Btn() {
        OK_Btn.click();
    }


    public WebElement getSubmit_btn() {
        return Submit_btn;
    }

    public void Submit_btn_Click() {
        Submit_btn.click();
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getSignIn() {
        return SignIn;
    }

    public void SignInClick() {
        SignIn.click();
    }

    public WebElement getForgotpassword() {
        return forgotpassword;
    }

    public void ForgotpasswordClick() {
        forgotpassword.click();
    }

    public String FrgtPswrdMsg() {
        return forgotpasswordmsg.getText();
    }
    //String  MSG="Enter the email address you used to register. We'll send you an email with reset instructions.";


}
