package Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignInPage {

//    AndroidDriver driver;
//
//    public SignInPage(AndroidDriver driver) {
//        super();
//        this.driver = driver;
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//    }

    public AppiumDriver driver;

    public SignInPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/bt_sign_in")
    public WebElement SignIn;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/ed_username")
    private WebElement Username;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/ed_password")
    private WebElement Password;

    @AndroidFindBy(id = "com.spireon.fleet.staging:id/bt_sign_in")
    private WebElement Login;
   @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_forgot_password")
    private WebElement forgotPassword;


    @AndroidFindBy(id = "com.spireon.fleet.staging:id/login_msg")
    private WebElement  LoginMsg;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView")
    private WebElement SignInTxt;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ImageButton")
    private WebElement  backButton;

    @AndroidFindBy(id = "android:id/message")
    private WebElement errorMessage;

    @AndroidFindBy(id = "android:id/button2")
    private WebElement ok_cancel_Button;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
    private WebElement InvalidLoginErrMsg;



    @AndroidFindBy(id = "android:id/button3")
    private WebElement Okbtn2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
    private WebElement anyAccount;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement selectbtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    private WebElement FL_Periscope;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView")
    private WebElement ForgotPasswordTxt;



    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]")
    private WebElement cancelbtn2;


     // Locate the first CheckedTextView element within the ListView
     @AndroidFindBy (xpath = "//android.widget.ListView/android.widget.CheckedTextView[4]")
     private WebElement radioButton;

    @AndroidFindBy (xpath = "//android.widget.ListView/android.widget.CheckedTextView[1]")
    private WebElement radioButton2;

    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
    private WebElement BasicUser;
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/rv_filters")
    private WebElement recyclerView ;
    @AndroidFindBy(className = "android.widget.LinearLayout")
    List<WebElement> linearLayouts;

    @AndroidFindBy (id = "com.spireon.fleet.staging:id/action_alerts")
    private WebElement alertButton;
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_filter_alerts")
    private WebElement filter;

   @AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[12]/android.widget.TextView")
   private WebElement AssetHealth;

   //Advance User
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ImageView")
    private WebElement alertButton2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[11]" )
    private WebElement assetHealth_adv;

    @AndroidFindBy (id = "com.spireon.fleet.staging:id/iv_title")
    private WebElement title;

    @AndroidFindBy (id = "com.spireon.fleet.staging:id/parentPanel")
    private WebElement Account_Dialogue_Screen;

    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout")
    private WebElement HomeScreen;

    @AndroidFindBy (id = "com.spireon.fleet.staging:id/action_account")
    private WebElement Account_icon;

    @AndroidFindBy (id = "com.spireon.fleet.staging:id/action_logout")
    private WebElement Logout;

    @AndroidFindBy (id = "android:id/button1")
    private WebElement Confirm_btn;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement permission_access;

    public void Click_Permission()
    {
        permission_access.click();
    }


    public WebElement getAccount_icon()
    {
        return Account_icon;
    }

    public WebElement getLogout()
    {
        return Logout;
    }

    public WebElement getConfirm_btn()
    {
        return Confirm_btn;
    }


    public void clickRadioButton() {  radioButton.click();  }
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
    public WebElement getLogin()
    {
        return Login;
    }
    public WebElement getForgotPassword()
    {
        return forgotPassword;
    }

   public String getLoginMsg()
   {
       return LoginMsg.getText();
   }

   public  String getSignIntxt()
   {
       return SignInTxt.getText();
   }

   public WebElement getBackButton()
   {
       return backButton;
   }

    public String getErrorMsg()
    {
        return errorMessage.getText();
    }

    public WebElement getOk_cancel_Button()
    {
        return ok_cancel_Button;
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

    public WebElement getOkbtn2()
    {
        return Okbtn2;
    }

    public WebElement getAccount()
    {
        return anyAccount;
    }

    public WebElement getSelectbtn()
    {
        return selectbtn;
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
        Username.click();
        Username.sendKeys(uname);
    }

    public void setPassword(String pwd){
        Password.click();
        Password.sendKeys(pwd);
    }

    public void clickSignIn(){
        SignIn.click();
    }

    public void clickSelectBtn(){
        selectbtn.click();
    }

    public void clickLogout(){
        Logout.click();
    }

    public void clickConfirm_btn(){
        Confirm_btn.click();
    }

    public String getErrorMessage(){
       String errorMsg= errorMessage.getText();
       return errorMsg;
    }

}



