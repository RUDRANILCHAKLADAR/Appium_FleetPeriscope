package AppiumAutomation;

import Android.ForgotPasswordPage;
import Android.SignInPage;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
//import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ForgotPasswordTestCases extends BaseClass
{


    //C146197 Verify Forgot Password screen UI matches with Zeplin
    //C146206 Verify the text "If you still need help, contact" and FleetLocate Support button on the forgot password screen
    @Test(priority =0)
    public void UIScreenElementsVerification()
    {
        signinpage.clickSignIn();
        forgotPasswordPage.ForgotpasswordClick();
        Assert.assertTrue(forgotPasswordPage.getEmail().isEnabled());
        Assert.assertTrue(forgotPasswordPage.getSubmit_btn().isEnabled());
        Assert.assertTrue(forgotPasswordPage.getBackBtn().isEnabled());
        Assert.assertTrue(forgotPasswordPage.getFleetLocateSupport().isEnabled());
        Assert.assertEquals(forgotPasswordPage.FrgtPswrdMsg(), forgotPasswordPage.str);
        Assert.assertEquals(forgotPasswordPage.getForgotPswrdScreen(),forgotPasswordPage.frgt_psswrd);
        Assert.assertEquals(forgotPasswordPage.getNeedHelp(),forgotPasswordPage.Need_help_txt);

    }

    // C146198 Verify user is able to see the instruction text at the top center of the screen below the Forgot Password text.
    @Test(priority =1)
    public void InstructionTextVisibilityVerification()
    {
       // forgotPasswordPage.SignInClick();
       // forgotPasswordPage.ForgotpasswordClick();
        Assert.assertEquals(forgotPasswordPage.FrgtPswrdMsg(),forgotPasswordPage.Email_register_text);

    }

    //C146199 Verify error message is shown without entering email if user taps on the submit button
    @Test(priority = 2)
    public void EmptyEmailfieldErrorVerification()
    {
//        forgotPasswordPage.SignInClick();
//        forgotPasswordPage.ForgotpasswordClick();
        forgotPasswordPage.getEmail().sendKeys("");
        forgotPasswordPage.Submit_btn_Click();
        Assert.assertEquals(forgotPasswordPage.getErrorMsg(),forgotPasswordPage.Valid_Email_text);
        forgotPasswordPage.ClickOk_Btn();
    }

    //C146200 Verify error message is shown if user enters non registered email id and tap on the submit button
    @Test(priority =3)
    public void UnregisteredEmailIdErrorMsgVerification() throws InterruptedException {
//        forgotPasswordPage.SignInClick();
//        forgotPasswordPage.ForgotpasswordClick();
        forgotPasswordPage.getEmail().sendKeys("tjbusffl@mailinator.com");
        forgotPasswordPage.Submit_btn_Click();
        Thread.sleep(2000);
       // new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(forgotPasswordPage.unrgstrederrmsg()));
        Assert.assertEquals(forgotPasswordPage.getUnregisteredEmailErrorMsg(),forgotPasswordPage.Registered_Email_text);
        forgotPasswordPage.ClickTryAgain();
    }

   // C146201 Verify user gets the reset password email link by entering valid email when user taps on the Submit button
    @Test(priority = 4)
    public void RegisteredEmailIdMsgVerification() throws InterruptedException {
//        forgotPasswordPage.SignInClick();
//        forgotPasswordPage.ForgotpasswordClick();
        forgotPasswordPage.getEmail().clear();
        forgotPasswordPage.getEmail().sendKeys("tjbussfl@spireon.com");
        forgotPasswordPage.Submit_btn_Click();
        Thread.sleep(4000);
        Assert.assertEquals(forgotPasswordPage.getResetMsg(),forgotPasswordPage.Reset_txt);
        forgotPasswordPage.ClickOkbtn2();
    }

    //C146207 Verify that when you tap on "FleetLocate Support," it should take you to the support screen.
      @Test(priority = 5)
      public void  SupportScreenVerification()
      {
//          forgotPasswordPage.SignInClick();
//          forgotPasswordPage.ForgotpasswordClick();
          forgotPasswordPage.getFleetLocateSupport().click();
          Assert.assertEquals(forgotPasswordPage.getSupport_Title(),forgotPasswordPage.support);
          //forgotPasswordPage.ClickBackSupport();

      }

      // C146208 Verify Support screen has Email support and Call support buttons
      @Test(priority = 6)
      public void EmailandCallSupportVerification()
       {
//          forgotPasswordPage.SignInClick();
//          forgotPasswordPage.ForgotpasswordClick();
          //forgotPasswordPage.getFleetLocateSupport().click();
          Assert.assertTrue(forgotPasswordPage.getEmailSupport_Btn().isDisplayed());
          Assert.assertTrue(forgotPasswordPage.getEmailSupport_Btn().isEnabled());
          Assert.assertTrue(forgotPasswordPage.getCallSupport_Btn().isDisplayed());
          Assert.assertTrue(forgotPasswordPage.getCallSupport_Btn().isEnabled());
           forgotPasswordPage.ClickBackSupport();
      }

      //C146559 Verify proper n/w error message is shown when user taps on the submit button if n/w fails
      @Test(priority = 7)
     public void NetworkErrorMessage()
     {
//         forgotPasswordPage.SignInClick();
//         forgotPasswordPage.ForgotpasswordClick();
         forgotPasswordPage.getEmail().sendKeys("tjbussfl@spireon.com");
         driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());
         forgotPasswordPage.Submit_btn_Click();
         Assert.assertEquals(forgotPasswordPage.getNetworkErrorMsg(),forgotPasswordPage.network_Err_msg);
         forgotPasswordPage.ClickOkbtn3();
         driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled().build());
     }



}
