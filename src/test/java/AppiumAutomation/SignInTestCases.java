package AppiumAutomation;
import android.SignInPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.Utils;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SignInTestCases extends BaseTest {
    SignInPage signinpage;
    @BeforeMethod
    public void beforeMethod(Method m) {
        signinpage = new SignInPage(driver);
    }
   @AfterMethod
   public void afterMethod(){}

    @Test(priority = 0)
    public void testAccountDialogueScreenVerification(){
        actions.waitForVisibility(signinpage.SignIn);
        Assert.assertTrue(actions.findElement(signinpage.SignIn).isDisplayed());
        actions.clickElement(actions.findElement(signinpage.SignIn));
        actions.waitForVisibility(actions.findElement(signinpage.Username));
        signinpage.setUsername("tjbussfl");
        signinpage.setPassword("123456");
        actions.clickElement(actions.findElement(signinpage.SignIn));
        actions.waitForVisibility(signinpage.getAccount_Dialogue_Screen());
        Assert.assertTrue(signinpage.getAccount_Dialogue_Screen().isDisplayed());
        actions.clickElement(signinpage.selectBtn);
        if (currentPlatform == BaseTest.Platform.ANDROID) {
            actions.waitForVisibility(signinpage.permission_access);
            actions.clickElement(signinpage.permission_access);
            actions.clickElement(signinpage.Account_icon);
        }
        else {
            if (currentPlatform == BaseTest.Platform.iOS) {
                actions.clickElement(signinpage.Account_icon);
            }
        }
        actions.clickElement(signinpage.Logout);
        actions.clickElement(signinpage.Confirm_btn);
    }

    @Test(priority = 1)
    public void testForgotPasswordScreenValidation() {
        actions.waitForVisibility(signinpage.SignIn);
        Assert.assertTrue(actions.findElement(signinpage.SignIn).isDisplayed());
        actions.clickElement(signinpage.SignIn);
        actions.clickElement(signinpage.forgotPassword);
        if (currentPlatform== BaseTest.Platform.ANDROID) {
            String ActualErrorMessage = signinpage.ForgotPasswordTxt.getText();
            String ExpectedResult = "Forgot Password";
            Assert.assertEquals(ActualErrorMessage, ExpectedResult);
            actions.clickElement(signinpage.backButton);

        } else
        if(currentPlatform== BaseTest.Platform.iOS){
            String ActualErrorMessage = signinpage.iosForgotPwTxt.getText();
            String ExpectedResult = "Forgot Password?";
            Assert.assertEquals(ActualErrorMessage, ExpectedResult);
            actions.clickElement(signinpage.forgotPwBackBtn);
        }
    }

    //Verify Choose account screen is shown for some user if user scope is set
    //C18779,C146195-To check whether all the signIn elements are displayed or not
    @Test(priority = 2)
    public void testLoginUiElementsValidation() {
        actions.waitForVisibility(signinpage.Username);
        Assert.assertTrue(actions.findElement(signinpage.Username).isDisplayed());
        Assert.assertTrue(actions.findElement(signinpage.Password).isDisplayed());
        Assert.assertTrue(actions.findElement(signinpage.Username).isDisplayed());
        Assert.assertTrue(actions.findElement(signinpage.forgotPassword).isDisplayed());
        Assert.assertTrue(actions.findElement(signinpage.backButton).isEnabled());
    }

    //C18780-Verify user is able to enter the username and password in the Sign in Screen
    @Test(priority = 3)
    public void testLoginCredentialsValidation() {
        signinpage.setUsername("tjbussfl");
        signinpage.setPassword("123456");
    }

    //C18783-Verify proper message is shown if username or password fields are missing and tapping on Sign in button
    @Test(priority = 4)
    public void testEmptyLoginCredentialsValidation() throws InterruptedException {
        signinpage.Password.clear();
        signinpage.setUsername("tjbussfl");
        actions.clickElement(signinpage.SignIn);
        actions.waitForVisibility(signinpage.errorMessage);
        Assert.assertEquals(signinpage.getErrorMsg(), "Please enter a valid password");
        actions.clickElement(signinpage.ok_cancel_Button);
        signinpage.setUsername("");
        signinpage.setPassword("123456");
        actions.clickElement(signinpage.SignIn);
        actions.waitForVisibility(signinpage.errorMessage);
        Assert.assertEquals(signinpage.getErrorMsg(), "Please enter a valid username");
        actions.clickElement(signinpage.ok_cancel_Button);
        signinpage.getPassword().clear();
        actions.clickElement(signinpage.SignIn);
        actions.waitForVisibility(signinpage.errorMessage);
        Assert.assertEquals(signinpage.getErrorMsg(), "Please enter a valid username");
        actions.clickElement(signinpage.ok_cancel_Button);
    }

    @Test(priority = 5)
    public void testInvalidCredentialValidations(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        signinpage.setUsername("tjbuss");
        signinpage.setPassword("1234");
        wait.until(ExpectedConditions.elementToBeClickable(signinpage.getSignIn()));
        actions.clickElement(signinpage.SignIn);
        String actualError = signinpage.getInvalidLoginErrMsg();
        String expectedResult = "The credentials entered do not match our records. Verify your username and password.";
        Assert.assertEquals(actualError, expectedResult);
        actions.clickElement(signinpage.ok_cancel_Button);
    }

    @Test(priority = 6)
    public void testNoInternetConnection() {
        signinpage.setUsername("tjbussfl");
        signinpage.setPassword("123456");
        Assert.assertTrue(signinpage.getSignIn().isEnabled());
        actions.internetOff();
        actions.waitForVisibility(signinpage.SignIn);
        actions.clickElement(signinpage.SignIn);
        actions.waitForVisibility(signinpage.errorMessage);
        String ActualErrorMessage = signinpage.getErrorMessage();
        String ExpectedResult = "Please check your network connection and try again.";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        actions.internetOn();
        actions.clickElement(signinpage.Okbtn2);
        actions.clickElement(signinpage.SignIn);
    }

    //C20853-Verify after selecting a account user is able to sign in successfully
    @Test(priority = 7)
    public void testUserAbleToSelectAnyAccount(){
        actions.waitForVisibility(signinpage.getAccount_Dialogue_Screen());
        actions.clickElement(signinpage.anyAccount);
        signinpage.getSelectbtn().click();
        actions.waitForVisibility(signinpage.Account_icon);
        String ActualErrorMessage = signinpage.getFL_Periscope();
        String ExpectedResult = "FL Periscope";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        actions.clickElement(signinpage.Account_icon);
        actions.clickElement(signinpage.Logout);
        actions.clickElement(signinpage.Confirm_btn);

    }

    //Verify tapping on cancel button on dialogue pop up, account is not selected and user is returned to Sign In screen
    @Test(priority = 8)
    public void testUserAccountSelectionCancel(){
        actions.clickElement(signinpage.SignIn);
        signinpage.setUsername("tjbussfl");
        signinpage.setPassword("123456");
        actions.clickElement(signinpage.SignIn);
        actions.waitForVisibility(signinpage.getAccount_Dialogue_Screen());
        actions.clickElement(signinpage.ok_cancel_Button);
        Assert.assertEquals(signinpage.getSignIntxt(), "Sign In");

    }
    //Verify user is able to select one account from the list when user attempts to sign in and if multiple accounts are linked to the username
    @Test(priority = 9)
    public void testAccountSelectionVerification(){
        actions.clickElement(signinpage.SignIn);
        actions.waitForVisibility(signinpage.getAccount_Dialogue_Screen());
        actions.clickElement(signinpage.radioButton);
        Assert.assertTrue(signinpage.getRadioButton().getAttribute("checked").equals("true"));
        actions.clickElement(signinpage.ok_cancel_Button);
    }

    //Verify user is able to select one account from the list when user attempts to sign in and if multiple accounts are linked to the username
    @Test(priority = 10)
    public void UserLoginVerification(){
        signinpage.setUsername("tjbussfl");
        signinpage.setPassword("123456");
        actions.clickElement(signinpage.SignIn);
        actions.waitForVisibility(signinpage.getAccount_Dialogue_Screen());
        actions.clickElement(signinpage.radioButton);
        Assert.assertTrue(signinpage.getRadioButton().getAttribute("checked").equals("true"));
        //Verify tapping on cancel button on dialogue pop up, account is not selected and user is returned to Sign In screen
        actions.clickElement(signinpage.ok_cancel_Button);
        Assert.assertEquals(signinpage.getSignIntxt(), "Sign In");
        //C20853-Verify after selecting a account user is able to sign in successfully
        actions.clickElement(signinpage.SignIn);
        actions.waitForVisibility(signinpage.getAccount_Dialogue_Screen());
        actions.clickElement(signinpage.anyAccount);
        signinpage.getSelectbtn().click();
        actions.waitForVisibility(signinpage.FL_Periscope);
        String ActualErrorMessage = signinpage.getFL_Periscope();
        String ExpectedResult = "FL Periscope";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        actions.clickElement(signinpage.Account_icon);
        actions.clickElement(signinpage.Logout);
        actions.clickElement(signinpage.Confirm_btn);
    }
    @Test(enabled = false)
    public void AdvanceUserLoginVerification() throws InterruptedException {
        actions.clickElement(signinpage.SignIn);
        signinpage.setUsername("Fleet360A");
        signinpage.setPassword("Password@1");
        actions.clickElement(signinpage.SignIn);
        signinpage.ok_cancel_Button.click();
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        Thread.sleep(6000);
        List<WebElement> webElementsList = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[11]"));
        boolean isDtcFound = false;

        for (WebElement element : webElementsList) {
            System.out.print(element);
            String elementText = element.getText();
            if (elementText.contains("DTC")) {
                isDtcFound = true;
                break;
            }
        }

        if (isDtcFound) {
            System.out.println("Not a basic user");
        } else {
            System.out.println("BASIC user");
        }
    }


    @Test(enabled = false)
    public void BasicUserLoginVerification(){
        signinpage.getSignIn().click();
        signinpage.getUsername().click();
        signinpage.getUsername().sendKeys("pratibha_mone_1");
        //signinpage.getUsername().sendKeys("Fleet360A");
        signinpage.getPassword().click();
        signinpage.getPassword().sendKeys("123456");
        // signinpage.getPassword().sendKeys("Password@1");
        signinpage.getSignIn().click();
//        signinpage.getBasicUser().click();
//        signinpage.getSelectbtn().click();
//        signinpage.getAlertButton().click();
//        signinpage.getFilter().click();
//
//        signinpage.getAssethealth().click();
//        signinpage.scrollAndClick();
//        Thread.sleep(6000);


        List<WebElement> webElementsList = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[12]"));
        boolean isDtcFound = false;

        for (WebElement element : webElementsList) {
            String elementText = element.getText();
            if (elementText.contains("DTC")) {
                isDtcFound = true;
                break;
            }
        }
        //  Assert.assertTrue(isDtcFound, "Basic User");
        if (isDtcFound) {
            System.out.println("Not a Basic User");
        } else {
            System.out.println("BASIC user");
        }
    }

        boolean isDTCAlert=false;
//        for (WebElement linearLayout : signinpage.listOfFilters()) {
//            WebElement textView = linearLayout.findElement(By.id("com.spireon.fleet.staging:id/material_drawer_name"));
//            String text = textView.getText();
//       System.out.println(text);
//            if (text.contains("DTC alert")) {
//                // This LinearLayout contains a DTC alert
//                isDTCAlert=true;
//            }
//
//       Assert.assertTrue(isDTCAlert,"Basic User");
//
//        }

    @Test(priority = 11)
    public void testBackCarouselPageVerification() {
        signinpage.getSignIn().click();
        actions.clickElement(signinpage.backButton);
        Assert.assertTrue(signinpage.getTitle().isDisplayed());
    }

    @Test(priority = 12)
    public void testAccountScreenDisplayVerification(){
        actions.clickElement(signinpage.SignIn);
        signinpage.setUsername("tjbussfl");
        signinpage.setPassword("123456");
        actions.clickElement(signinpage.SignIn);
        actions.waitForVisibility(signinpage.getAccount_Dialogue_Screen());
        Assert.assertTrue(signinpage.getAccount_Dialogue_Screen().isDisplayed());
        Assert.assertTrue(signinpage.getRadioButton2().getAttribute("checked").equals("true"));
        actions.clickElement(signinpage.ok_cancel_Button);
    }

    //Verify account setting is checked tapping on Sign in button for the valid user credentials
    //Verify account setting screen is not shown if user scope is not set
    @Test(priority = 13)
    public void testAccountScreenNotDisplayedVerification(){
        actions.waitForVisibility(signinpage.Username);
        signinpage.setUsername("Fleet360A");
        signinpage.setPassword("Password@1");
        actions.clickElement(signinpage.SignIn);
        actions.waitForVisibility(signinpage.FL_Periscope);
        Assert.assertTrue(signinpage.getHomeScreen().isDisplayed());
        if (signinpage.getHomeScreen().isDisplayed())
            System.out.println("Account Screen pop up is not displayed");
        else
            System.out.println("Account Screen pop up is  displayed");
        actions.clickElement(signinpage.Account_icon);
        actions.clickElement(signinpage.Logout);
        actions.clickElement(signinpage.Confirm_btn);
    }

    @Test(priority = 14)
    public void testAfterAccountSelectionNetworkVerification() {
        actions.clickElement(signinpage.SignIn);
        actions.waitForVisibility(signinpage.Username);
        signinpage.setUsername("tjbussfl");
        signinpage.setPassword("123456");
        actions.clickElement(signinpage.SignIn);
        actions.waitForVisibility(signinpage.getAccount_Dialogue_Screen());
        //To disable wifi / data connection
        actions.internetOff();
        signinpage.getSelectbtn().click();
        String ActualErrorMessage = signinpage.getNetworkErrMsg();
        String ExpectedResult = "Please check your network connection and try again.";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        //To enable wifi / data connection
        actions.internetOn();
        actions.clickElement(signinpage.Okbtn2);
    }

}




