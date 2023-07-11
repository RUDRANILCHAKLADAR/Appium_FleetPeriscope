package AppiumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;


public class SignInTestCases extends BaseTest {


    @Test(priority = 0)
    public void testAccountDialogueScreenVerification(){
        actions.waitForVisibility(sp.SignIn);
        Assert.assertTrue(actions.findElement(sp.SignIn).isDisplayed());
        actions.clickElement(actions.findElement(sp.SignIn));
        actions.waitForVisibility(actions.findElement(sp.Username));
        sp.setUsername("tjbussfl");
        sp.setPassword("123456");
        actions.clickElement(actions.findElement(sp.SignIn));
        actions.waitForVisibility(sp.getAccount_Dialogue_Screen());
        Assert.assertTrue(sp.getAccount_Dialogue_Screen().isDisplayed());
        actions.clickElement(sp.selectBtn);
        if (currentPlatform == BaseTest.Platform.ANDROID) {
            actions.waitForVisibility(sp.permission_access);
            actions.clickElement(sp.permission_access);
            actions.clickElement(sp.Account_icon);
        }
        else {
            if (currentPlatform == BaseTest.Platform.iOS) {
                actions.clickElement(sp.Account_icon);
            }
        }
        actions.clickElement(sp.Logout);
        actions.clickElement(sp.Confirm_btn);
    }

    @Test(priority = 1)
    public void testForgotPasswordScreenValidation() {
        actions.waitForVisibility(sp.SignIn);
        Assert.assertTrue(actions.findElement(sp.SignIn).isDisplayed());
        actions.clickElement(sp.SignIn);
        actions.clickElement(sp.forgotPassword);
        if (currentPlatform== BaseTest.Platform.ANDROID) {
            String ActualErrorMessage = sp.ForgotPasswordTxt.getText();
            String ExpectedResult = "Forgot Password";
            Assert.assertEquals(ActualErrorMessage, ExpectedResult);
            actions.clickElement(sp.backButton);

        } else
        if(currentPlatform== BaseTest.Platform.iOS){
            String ActualErrorMessage = sp.iosForgotPwTxt.getText();
            String ExpectedResult = "Forgot Password?";
            Assert.assertEquals(ActualErrorMessage, ExpectedResult);
            actions.clickElement(sp.forgotPwBackBtn);
        }
    }

    //Verify Choose account screen is shown for some user if user scope is set
    //C18779,C146195-To check whether all the signIn elements are displayed or not
    @Test(priority = 2)
    public void testLoginUiElementsValidation() {
        actions.waitForVisibility(sp.Username);
        Assert.assertTrue(actions.findElement(sp.Username).isDisplayed());
        Assert.assertTrue(actions.findElement(sp.Password).isDisplayed());
        Assert.assertTrue(actions.findElement(sp.Username).isDisplayed());
        Assert.assertTrue(actions.findElement(sp.forgotPassword).isDisplayed());
        Assert.assertTrue(actions.findElement(sp.backButton).isEnabled());
    }

    //C18780-Verify user is able to enter the username and password in the Sign in Screen
    @Test(priority = 3)
    public void testLoginCredentialsValidation() {
        sp.setUsername("tjbussfl");
        sp.setPassword("123456");
    }

    //C18783-Verify proper message is shown if username or password fields are missing and tapping on Sign in button
    @Test(priority = 4)
    public void testEmptyLoginCredentialsValidation(){
        sp.Password.clear();
        sp.setUsername("tjbussfl");
        actions.clickElement(sp.SignIn);
        actions.waitForVisibility(sp.errorMessage);
        Assert.assertEquals(sp.getErrorMsg(), "Please enter a valid password");
        actions.clickElement(sp.ok_cancel_Button);
        sp.setUsername("");
        sp.setPassword("123456");
        actions.clickElement(sp.SignIn);
        actions.waitForVisibility(sp.errorMessage);
        Assert.assertEquals(sp.getErrorMsg(), "Please enter a valid username");
        actions.clickElement(sp.ok_cancel_Button);
        sp.getPassword().clear();
        actions.clickElement(sp.SignIn);
        actions.waitForVisibility(sp.errorMessage);
        Assert.assertEquals(sp.getErrorMsg(), "Please enter a valid username");
        actions.clickElement(sp.ok_cancel_Button);
    }

    @Test(priority = 5)
    public void testInvalidCredentialValidations(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        sp.setUsername("tjbuss");
        sp.setPassword("1234");
        wait.until(ExpectedConditions.elementToBeClickable(sp.getSignIn()));
        actions.clickElement(sp.SignIn);
        String actualError = sp.getInvalidLoginErrMsg();
        String expectedResult = "The credentials entered do not match our records. Verify your username and password.";
        Assert.assertEquals(actualError, expectedResult);
        actions.clickElement(sp.ok_cancel_Button);
    }

    @Test(priority = 6)
    public void testNoInternetConnection() {
        sp.setUsername("tjbussfl");
        sp.setPassword("123456");
        Assert.assertTrue(sp.getSignIn().isEnabled());
        actions.internetOff();
        actions.waitForVisibility(sp.SignIn);
        actions.clickElement(sp.SignIn);
        actions.waitForVisibility(sp.errorMessage);
        String ActualErrorMessage = sp.getNetworkErrMsg();
        String ExpectedResult = "Please check your network connection and try again.";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        actions.internetOn();
        actions.clickElement(sp.Okbtn2);
        actions.clickElement(sp.SignIn);

    }

    //C20853-Verify after selecting a account user is able to sign in successfully
    @Test(priority = 7)
    public void testUserAbleToSelectAnyAccount(){
        actions.waitForVisibility(sp.getAccount_Dialogue_Screen());
        actions.clickElement(sp.anyAccount);
        sp.getSelectbtn().click();
        actions.waitForVisibility(sp.Account_icon);
        String ActualErrorMessage = sp.getFL_Periscope();
        String ExpectedResult = "FL Periscope";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        actions.clickElement(sp.Account_icon);
        actions.clickElement(sp.Logout);
        actions.clickElement(sp.Confirm_btn);

    }

    //Verify tapping on cancel button on dialogue pop up, account is not selected and user is returned to Sign In screen
    @Test(priority = 8)
    public void testUserAccountSelectionCancel(){
        actions.clickElement(sp.SignIn);
        sp.setUsername("tjbussfl");
        sp.setPassword("123456");
        actions.clickElement(sp.SignIn);
        actions.waitForVisibility(sp.getAccount_Dialogue_Screen());
        actions.clickElement(sp.ok_cancel_Button);
        Assert.assertEquals(sp.getSignIntxt(), "Sign In");

    }
    //Verify user is able to select one account from the list when user attempts to sign in and if multiple accounts are linked to the username
    @Test(priority = 9)
    public void testAccountSelectionVerification(){
        actions.clickElement(sp.SignIn);
        actions.waitForVisibility(sp.getAccount_Dialogue_Screen());
        actions.clickElement(sp.radioButton);
        Assert.assertTrue(sp.getRadioButton().getAttribute("checked").equals("true"));
        actions.clickElement(sp.ok_cancel_Button);
    }

    //Verify user is able to select one account from the list when user attempts to sign in and if multiple accounts are linked to the username
    @Test(priority = 10)
    public void UserLoginVerification(){
        sp.setUsername("tjbussfl");
        sp.setPassword("123456");
        actions.clickElement(sp.SignIn);
        actions.waitForVisibility(sp.getAccount_Dialogue_Screen());
        actions.clickElement(sp.radioButton);
        Assert.assertTrue(sp.getRadioButton().getAttribute("checked").equals("true"));
        //Verify tapping on cancel button on dialogue pop up, account is not selected and user is returned to Sign In screen
        actions.clickElement(sp.ok_cancel_Button);
        Assert.assertEquals(sp.getSignIntxt(), "Sign In");
        //C20853-Verify after selecting a account user is able to sign in successfully
        actions.clickElement(sp.SignIn);
        actions.waitForVisibility(sp.getAccount_Dialogue_Screen());
        actions.clickElement(sp.anyAccount);
        sp.getSelectbtn().click();
        actions.waitForVisibility(sp.FL_Periscope);
        String ActualErrorMessage = sp.getFL_Periscope();
        String ExpectedResult = "FL Periscope";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        actions.clickElement(sp.Account_icon);
        actions.clickElement(sp.Logout);
        actions.clickElement(sp.Confirm_btn);
    }
    @Test(enabled = false)
    public void AdvanceUserLoginVerification() throws InterruptedException {
        actions.clickElement(sp.SignIn);
        sp.setUsername("Fleet360A");
        sp.setPassword("Password@1");
        actions.clickElement(sp.SignIn);
        sp.ok_cancel_Button.click();
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
        sp.getSignIn().click();
        sp.getUsername().click();
        sp.getUsername().sendKeys("pratibha_mone_1");
        //signinpage.getUsername().sendKeys("Fleet360A");
        sp.getPassword().click();
        sp.getPassword().sendKeys("123456");
        // signinpage.getPassword().sendKeys("Password@1");
        sp.getSignIn().click();
//        signinpage.getBasicUser().click();
//        signinpage.getSelectbtn().click();
//        signinpage.getAlertButton().click();
//        signinpage.getFilter().click();
//
//        signinpage.getAssethealth().click();
//        signinpage.scrollAndClick();
//        Thread.sleep(6000);


//        List<WebElement> webElementsList = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[12]"));
//        boolean isDtcFound = false;
//
//        for (WebElement element : webElementsList) {
//            String elementText = element.getText();
//            if (elementText.contains("DTC")) {
//                isDtcFound = true;
//                break;
//            }
//        }
//        //  Assert.assertTrue(isDtcFound, "Basic User");
//        if (isDtcFound) {
//            System.out.println("Not a Basic User");
//        } else {
//            System.out.println("BASIC user");
//        }
//    }

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
 }

    @Test(priority = 11)
    public void testBackCarouselPageVerification() {
        sp.getSignIn().click();
        actions.clickElement(sp.backButton);
        Assert.assertTrue(sp.getTitle().isDisplayed());
    }

    @Test(priority = 12)
    public void testAccountScreenDisplayVerification(){
        actions.clickElement(sp.SignIn);
        sp.setUsername("tjbussfl");
        sp.setPassword("123456");
        actions.clickElement(sp.SignIn);
        actions.waitForVisibility(sp.getAccount_Dialogue_Screen());
        Assert.assertTrue(sp.getAccount_Dialogue_Screen().isDisplayed());
        Assert.assertTrue(sp.getRadioButton2().getAttribute("checked").equals("true"));
        actions.clickElement(sp.ok_cancel_Button);
    }

    //Verify account setting is checked tapping on Sign in button for the valid user credentials
    //Verify account setting screen is not shown if user scope is not set
    @Test(priority = 13)
    public void testAccountScreenNotDisplayedVerification(){
        actions.waitForVisibility(sp.Username);
        sp.setUsername("Fleet360A");
        sp.setPassword("Password@1");
        actions.clickElement(sp.SignIn);
        actions.waitForVisibility(sp.FL_Periscope);
        Assert.assertTrue(sp.getHomeScreen().isDisplayed());
        if (sp.getHomeScreen().isDisplayed())
            System.out.println("Account Screen pop up is not displayed");
        else
            System.out.println("Account Screen pop up is  displayed");
        actions.clickElement(sp.Account_icon);
        actions.clickElement(sp.Logout);
        actions.clickElement(sp.Confirm_btn);
    }

    @Test(priority = 14)
    public void testAfterAccountSelectionNetworkVerification() {
        actions.clickElement(sp.SignIn);
        actions.waitForVisibility(sp.Username);
        sp.setUsername("tjbussfl");
        sp.setPassword("123456");
        actions.clickElement(sp.SignIn);
        actions.waitForVisibility(sp.getAccount_Dialogue_Screen());
        //To disable wifi / data connection
        actions.internetOff();
        sp.getSelectbtn().click();
        String ActualErrorMessage = sp.getNetworkErrMsg();
        String ExpectedResult = "Please check your network connection and try again.";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        //To enable wifi / data connection
        actions.internetOn();
        actions.clickElement(sp.Okbtn2);
    }

}




