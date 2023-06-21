package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public AppiumDriver driver;

    public SignInPage(AppiumDriver driver) {
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


    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_forgot_password")
    @iOSXCUITFindBy(accessibility = "Forgot your password?")
    public WebElement forgotPassword;


    @AndroidFindBy(id = "com.spireon.fleet.staging:id/login_msg")
    @iOSXCUITFindBy(accessibility = "with your username and password")
    public WebElement  LoginMsg;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Sign In\"`]")
    public WebElement SignInTxt;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ImageButton")
    @iOSXCUITFindBy(accessibility = "Back")
    public WebElement  backButton;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(accessibility = "Please enter a valid password")
    public WebElement errorMessage;

    @iOSXCUITFindBy(accessibility = "Please enter a valid password")
    private WebElement emptyPwdMsg;

    @iOSXCUITFindBy(accessibility = "Please enter a valid username")
    private WebElement emptyUnameMsg;

    @AndroidFindBy(id = "android:id/button2")
    //Ok button for ios
    @iOSXCUITFindBy(accessibility = "OK")
    public WebElement ok_cancel_Button;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "The credentials entered do not match our records. Verify your username and password.")
    public WebElement InvalidLoginErrMsg;



    @AndroidFindBy(id = "android:id/button3")
    public WebElement Okbtn2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
    public WebElement anyAccount;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "Done")
    public WebElement selectBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    public WebElement FL_Periscope;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView")
    public WebElement ForgotPasswordTxt;

    @iOSXCUITFindBy(iOSClassChain =
            "**/XCUIElementTypeStaticText[`label == \"Forgot Password?\"`]")
    public WebElement iosForgotPwTxt;



     // Locate the first CheckedTextView element within the ListView
     @AndroidFindBy (xpath = "//android.widget.ListView/android.widget.CheckedTextView[4]")
     public WebElement radioButton;

    @AndroidFindBy (xpath = "//android.widget.ListView/android.widget.CheckedTextView[1]")
    private WebElement radioButton2;



    @AndroidFindBy (id = "com.spireon.fleet.staging:id/iv_title")
    public WebElement title;

    @AndroidFindBy (id = "com.spireon.fleet.staging:id/parentPanel")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    public WebElement Account_Dialogue_Screen;

    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout")
    private WebElement HomeScreen;

    @AndroidFindBy (id = "com.spireon.fleet.staging:id/action_account")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Account\"`]")
    public WebElement Account_icon;

    @AndroidFindBy (id = "com.spireon.fleet.staging:id/action_logout")
    @iOSXCUITFindBy(accessibility = "Logout")
    public WebElement Logout;

    @AndroidFindBy (id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "Confirm")
    public WebElement Confirm_btn;




    @iOSXCUITFindBy(accessibility = "showpassword")
    public WebElement showPwdIcon;

  //  blankpw=@iOSXCUITFindBy(accessibility = "Please enter a valid password")
//    blankunma=@iOSXCUITFindBy(accessibility = "Please enter a valid username")

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    public WebElement permission_access;

    public WebElement getRadioButton()
    {
        return radioButton;
    }

    public boolean isRadioButtonChecked()
     {  return radioButton.getAttribute("checked").equals("true");
     }
    public WebElement getSignIn()
   {
       return SignIn;
   }
    public WebElement getUsername()
    {
        return Username;
    }


    public WebElement getPassword()
    {
        return Password;
    }



   public  String getSignIntxt()
   {
       return SignInTxt.getText();
   }



    public String getErrorMsg()
    {
        return errorMessage.getText();
    }


    public String getInvalidLoginErrMsg()
    {
        return InvalidLoginErrMsg.getText();
    }


    public String getNetworkErrMsg()
    {
        return errorMessage.getText();
    }
    public WebElement getNetworkErr()
    {
        return errorMessage;
    }


    public WebElement getSelectbtn()
    {
        return selectBtn;
    }

    public String getFL_Periscope()
    {
        return FL_Periscope.getText();
    }

    public String getForgotPasswordTxt()
    {
        return ForgotPasswordTxt.getText();
    }


    public WebElement getTitle()
    {
        return title;
    }

    public WebElement getAccount_Dialogue_Screen()
    {
        return Account_Dialogue_Screen;
    }
    public WebElement getRadioButton2()
    {
        return radioButton2;
    }

    public WebElement getHomeScreen()
    {
        return HomeScreen;
    }


    public void setUsername(String uname){
        Username.clear();
        Username.sendKeys(uname);
    }

    public void setPassword(String pwd){
        Password.clear();
        Password.sendKeys(pwd);
    }

    public String getErrorMessage(){
       String errorMsg= errorMessage.getText();
       return errorMsg;
    }

}



