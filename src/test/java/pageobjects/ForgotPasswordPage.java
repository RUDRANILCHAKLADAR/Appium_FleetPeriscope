package pageobjects;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/bt_sign_in")
    private WebElement SignIn;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_forgot_password")
    private WebElement forgotpassword;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/login_msg")
    private WebElement forgotpasswordmsg;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/ed_email")
    private WebElement email;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/bt_send_instructions")
    private WebElement Submit_btn;

    @AndroidFindBy(id = "android:id/message")
    private WebElement ErrorMsg;

    @AndroidFindBy(id = "android:id/message")
    private WebElement UnregisteredEmailErrorMsg;

    @AndroidFindBy(id = "android:id/button2")
    private WebElement OK_Btn;

    @AndroidFindBy(id = "android:id/button2")
    private WebElement Tryagain_Btn;
    @AndroidFindBy(id = "android:id/message")
    private WebElement ResetMsg;

    @AndroidFindBy(id = "android:id/button3")
    private WebElement Okbtn2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ImageButton")
    private WebElement BackBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView")
    private WebElement ForgotPswrdScreen;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    private WebElement NeedHelp;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/txt_kahu_support")
    private WebElement FleetLocateSupport;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    private WebElement Support_Title;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.Button")
    private WebElement EmailSupport_Btn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.Button")
    private WebElement CallSupport_Btn;

    @AndroidFindBy(id = "android:id/message")
    private WebElement NetworkErrorMsg;

    @AndroidFindBy(id = "android:id/button3")
    private WebElement OkBtn3;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")
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
