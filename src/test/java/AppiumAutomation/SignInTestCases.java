package AppiumAutomation;

import android.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.ActionClass;

import java.time.Duration;
import java.util.List;


public class SignInTestCases extends BaseTest {


    private SignInPage signInPage;

    @Override
    protected void initPage() {
        signInPage = new SignInPage(getDriver());
    }

    @Test(priority = 0)
    public void testAccountDialogueScreenVerification(){
        ActionClass.waitForVisibility(signInPage.signIn, getDriver());
        Assert.assertTrue(signInPage.signIn.isDisplayed());
        signInPage.signIn.click();
        ActionClass.waitForVisibility(signInPage.userName, getDriver());
        signInPage.setUsername("tjbussfl");
        signInPage.setPassword("123456");
        signInPage.signIn.click();
        ActionClass.waitForVisibility(signInPage.getAccount_Dialogue_Screen(), getDriver());
        Assert.assertTrue(signInPage.getAccount_Dialogue_Screen().isDisplayed());
        signInPage.selectBtn.click();
        if (currentPlatform == BaseTest.Platform.ANDROID) {
            ActionClass.waitForVisibility(signInPage.permission_access, getDriver());
            signInPage.permission_access.click();
            signInPage.Account_icon.click();
        }
        signInPage.Logout.click();
        ActionClass.clickElement(signInPage.Confirm_btn, getDriver());
    }

    @Test(priority = 1)
    public void testForgotPasswordScreenValidation() {
        ActionClass.waitForVisibility(signInPage.signIn, getDriver());
        Assert.assertTrue(signInPage.signIn.isDisplayed());
        signInPage.signIn.click();
        signInPage.forgotPassword.click();
        if (currentPlatform== BaseTest.Platform.ANDROID) {
            String ActualErrorMessage = signInPage.ForgotPasswordTxt.getText();
            String ExpectedResult = "Forgot Password";
            Assert.assertEquals(ActualErrorMessage, ExpectedResult);
            signInPage.backButton.click();

        } else
        if(currentPlatform== BaseTest.Platform.iOS){
            String ActualErrorMessage = signInPage.iosForgotPwTxt.getText();
            String ExpectedResult = "Forgot Password?";
            Assert.assertEquals(ActualErrorMessage, ExpectedResult);
            signInPage.forgotPwBackBtn.click();
        }
    }

    //Verify Choose account screen is shown for some user if user scope is set
    //C18779,C146195-To check whether all the signIn elements are displayed or not
    @Test(priority = 2)
    public void testLoginUiElementsValidation() {
        ActionClass.waitForVisibility(signInPage.userName, getDriver());
        Assert.assertTrue(signInPage.userName.isDisplayed());
        Assert.assertTrue(signInPage.password.isDisplayed());
        Assert.assertTrue(signInPage.userName.isDisplayed());
        Assert.assertTrue(signInPage.forgotPassword.isDisplayed());
        Assert.assertTrue(signInPage.backButton.isEnabled());
    }

    //C18780-Verify user is able to enter the username and password in the Sign in Screen
    @Test(priority = 3)
    public void testLoginCredentialsValidation() {
        signInPage.setUsername("tjbussfl");
        signInPage.setPassword("123456");
    }

    //C18783-Verify proper message is shown if username or password fields are missing and tapping on Sign in button
    @Test(priority = 4)
    public void testEmptyLoginCredentialsValidation(){
        signInPage.password.clear();
        signInPage.setUsername("tjbussfl");
        signInPage.signIn.click();
        ActionClass.waitForVisibility(signInPage.errorMessage, getDriver());
        Assert.assertEquals(signInPage.getErrorMsg(), "Please enter a valid password");
        signInPage.ok_cancel_Button.click();
        signInPage.setUsername("");
        signInPage.setPassword("123456");
        signInPage.signIn.click();
        ActionClass.waitForVisibility(signInPage.errorMessage, getDriver());
        Assert.assertEquals(signInPage.getErrorMsg(), "Please enter a valid username");
        signInPage.ok_cancel_Button.click();
        signInPage.getPassword().clear();
        signInPage.signIn.click();
        ActionClass.waitForVisibility(signInPage.errorMessage, getDriver());
        Assert.assertEquals(signInPage.getErrorMsg(), "Please enter a valid username");
        signInPage.ok_cancel_Button.click();
    }

    @Test(priority = 5)
    public void testInvalidCredentialValidations(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        signInPage.setUsername("tjbuss");
        signInPage.setPassword("1234");
        wait.until(ExpectedConditions.elementToBeClickable(signInPage.getSignIn()));
        actions.clickElement(signInPage.signIn);
        String actualError = signInPage.getInvalidLoginErrMsg();
        String expectedResult = "The credentials entered do not match our records. Verify your username and password.";
        Assert.assertEquals(actualError, expectedResult);
        actions.clickElement(signInPage.ok_cancel_Button);
    }

    @Test(priority = 6)
    public void testNoInternetConnection() {
        actions.internetOff();
        actions.waitForVisibility(signInPage.userName);
        signInPage.setUsername("tjbussfl");
        signInPage.setPassword("123456");
        Assert.assertTrue(signInPage.getSignIn().isEnabled());
        actions.waitForVisibility(signInPage.signIn);
        actions.clickElement(signInPage.signIn);
        actions.waitForVisibility(signInPage.errorMessage);
        String ActualErrorMessage = signInPage.getNetworkErrMsg();
        String ExpectedResult = "Please check your network connection and try again.";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        actions.clickElement(signInPage.okButton);
        actions.internetOn();
        actions.clickElement(signInPage.signIn);

    }

    //C20853-Verify after selecting a account user is able to sign in successfully
    @Test(priority = 7)
    public void testUserAbleToSelectAnyAccount(){
        actions.waitForVisibility(signInPage.getAccount_Dialogue_Screen());
        actions.clickElement(signInPage.anyAccount);
        signInPage.getSelectbtn().click();
        actions.waitForVisibility(signInPage.Account_icon);
        String ActualErrorMessage = signInPage.getFL_Periscope();
        String ExpectedResult = "FL Periscope";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        actions.clickElement(signInPage.Account_icon);
        actions.clickElement(signInPage.Logout);
        actions.clickElement(signInPage.Confirm_btn);

    }

    //Verify tapping on cancel button on dialogue pop up, account is not selected and user is returned to Sign In screen
    @Test(priority = 8)
    public void testUserAccountSelectionCancel(){
        actions.clickElement(signInPage.signIn);
        signInPage.setUsername("tjbussfl");
        signInPage.setPassword("123456");
        actions.clickElement(signInPage.signIn);
        actions.waitForVisibility(signInPage.getAccount_Dialogue_Screen());
        actions.clickElement(signInPage.ok_cancel_Button);
        Assert.assertEquals(signInPage.getSignIntxt(), "Sign In");

    }
    //Verify user is able to select one account from the list when user attempts to sign in and if multiple accounts are linked to the username
    @Test(priority = 9)
    public void testAccountSelectionVerification(){
        actions.clickElement(signInPage.signIn);
        actions.waitForVisibility(signInPage.getAccount_Dialogue_Screen());
        actions.clickElement(signInPage.radioButton);
        Assert.assertTrue(signInPage.getRadioButton().getAttribute("checked").equals("true"));
        actions.clickElement(signInPage.ok_cancel_Button);
    }

    //Verify user is able to select one account from the list when user attempts to sign in and if multiple accounts are linked to the username
    @Test(priority = 10)
    public void UserLoginVerification(){
        signInPage.setUsername("tjbussfl");
        signInPage.setPassword("123456");
        actions.clickElement(signInPage.signIn);
        actions.waitForVisibility(signInPage.getAccount_Dialogue_Screen());
        actions.clickElement(signInPage.radioButton);
        Assert.assertTrue(signInPage.getRadioButton().getAttribute("checked").equals("true"));
        //Verify tapping on cancel button on dialogue pop up, account is not selected and user is returned to Sign In screen
        actions.clickElement(signInPage.ok_cancel_Button);
        Assert.assertEquals(signInPage.getSignIntxt(), "Sign In");
        //C20853-Verify after selecting a account user is able to sign in successfully
        actions.clickElement(signInPage.signIn);
        actions.waitForVisibility(signInPage.getAccount_Dialogue_Screen());
        actions.clickElement(signInPage.anyAccount);
        signInPage.getSelectbtn().click();
        actions.waitForVisibility(signInPage.FL_Periscope);
        String ActualErrorMessage = signInPage.getFL_Periscope();
        String ExpectedResult = "FL Periscope";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        actions.clickElement(signInPage.Account_icon);
        actions.clickElement(signInPage.Logout);
        actions.clickElement(signInPage.Confirm_btn);
    }
    @Test(enabled = false)
    public void AdvanceUserLoginVerification() throws InterruptedException {
        actions.clickElement(signInPage.signIn);
        signInPage.setUsername("Fleet360A");
        signInPage.setPassword("Password@1");
        actions.clickElement(signInPage.signIn);
        signInPage.ok_cancel_Button.click();
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
        signInPage.getSignIn().click();
        signInPage.getUsername().click();
        signInPage.getUsername().sendKeys("pratibha_mone_1");
        //signinpage.getUsername().sendKeys("Fleet360A");
        signInPage.getPassword().click();
        signInPage.getPassword().sendKeys("123456");
        // signinpage.getPassword().sendKeys("Password@1");
        signInPage.getSignIn().click();
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
        signInPage.getSignIn().click();
        actions.clickElement(signInPage.backButton);
        Assert.assertTrue(signInPage.getTitle().isDisplayed());
    }

    @Test(priority = 12)
    public void testAccountScreenDisplayVerification(){
        actions.clickElement(signInPage.signIn);
        signInPage.setUsername("tjbussfl");
        signInPage.setPassword("123456");
        actions.clickElement(signInPage.signIn);
        actions.waitForVisibility(signInPage.getAccount_Dialogue_Screen());
        Assert.assertTrue(signInPage.getAccount_Dialogue_Screen().isDisplayed());
        Assert.assertTrue(signInPage.getRadioButton2().getAttribute("checked").equals("true"));
        actions.clickElement(signInPage.ok_cancel_Button);
    }

    //Verify account setting is checked tapping on Sign in button for the valid user credentials
    //Verify account setting screen is not shown if user scope is not set
    @Test(priority = 13)
    public void testAccountScreenNotDisplayedVerification(){
        actions.waitForVisibility(signInPage.userName);
        signInPage.setUsername("Fleet360A");
        signInPage.setPassword("Password@1");
        actions.clickElement(signInPage.signIn);
        actions.waitForVisibility(signInPage.FL_Periscope);
        Assert.assertTrue(signInPage.getHomeScreen().isDisplayed());
        if (signInPage.getHomeScreen().isDisplayed())
            System.out.println("Account Screen pop up is not displayed");
        else
            System.out.println("Account Screen pop up is  displayed");
        actions.clickElement(signInPage.Account_icon);
        actions.clickElement(signInPage.Logout);
        actions.clickElement(signInPage.Confirm_btn);
    }

    @Test(priority = 14)
    public void testAfterAccountSelectionNetworkVerification() {
        actions.clickElement(signInPage.signIn);
        actions.waitForVisibility(signInPage.userName);
        signInPage.setUsername("tjbussfl");
        signInPage.setPassword("123456");
        actions.clickElement(signInPage.signIn);
        actions.waitForVisibility(signInPage.getAccount_Dialogue_Screen());
        //To disable wifi / data connection
        actions.internetOff();
        signInPage.getSelectbtn().click();
        String ActualErrorMessage = signInPage.getNetworkErrMsg();
        String ExpectedResult = "Please check your network connection and try again.";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        //To enable wifi / data connection
        actions.internetOn();
        actions.clickElement(signInPage.okButton);
    }


}




