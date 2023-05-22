package AppiumAutomation;

import Android.ForgotPasswordPage;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTestCases extends BaseClass
{

    //C146197 Verify Forgot Password screen UI matches with Zeplin
    //C146206 Verify the text "If you still need help, contact" and FleetLocate Support button on the forgot password screen
    @Test
    public void UIScreenElementsVerification()
    {
        forgotPasswordPage.SignInClick();
        forgotPasswordPage.ForgotpasswordClick();
        Assert.assertTrue(forgotPasswordPage.getEmail().isEnabled());
        Assert.assertTrue(forgotPasswordPage.getSubmit_btn().isEnabled());
        Assert.assertTrue(forgotPasswordPage.getBackBtn().isEnabled());
        Assert.assertTrue(forgotPasswordPage.getFleetLocateSupport().isEnabled());
        Assert.assertEquals(forgotPasswordPage.FrgtPswrdMsg(), forgotPasswordPage.str);
        Assert.assertEquals(forgotPasswordPage.getForgotPswrdScreen(),"Forgot Password");
        Assert.assertEquals(forgotPasswordPage.getNeedHelp(),"If you still need help, contact");

    }

    // C146198 Verify user is able to see the instruction text at the top center of the screen below the Forgot Password text.
    @Test
    public void InstructionTextVisibilityVerification()
    {
        forgotPasswordPage.SignInClick();
        forgotPasswordPage.ForgotpasswordClick();
        Assert.assertEquals(forgotPasswordPage.FrgtPswrdMsg(),"Enter the email address you used to register. We'll send you an email with reset instructions.");

    }

    //C146199 Verify error messgae is shown without entering email if user taps on the submit button
    @Test
    public void EmptyEmailfieldErrorVerification()
    {
        forgotPasswordPage.SignInClick();
        forgotPasswordPage.ForgotpasswordClick();
        forgotPasswordPage.getEmail().sendKeys("");
        forgotPasswordPage.Submit_btn_Click();
        Assert.assertEquals(forgotPasswordPage.getErrorMsg(),"Please enter valid Email ID.");
        forgotPasswordPage.ClickOk_Btn();
    }

    //C146200 Verify error message is shown if user enters non registered email id and tap on the submit button
    @Test
    public void UnregisteredEmailIdErrorMsgVerification() throws InterruptedException {
        forgotPasswordPage.SignInClick();
        forgotPasswordPage.ForgotpasswordClick();
        forgotPasswordPage.getEmail().sendKeys("tjbusffl@mailinator.com");
        forgotPasswordPage.Submit_btn_Click();
        Thread.sleep(2000);
        Assert.assertEquals(forgotPasswordPage.getUnregisteredEmailErrorMsg(),"Please enter your registered Email ID and try again.");
        forgotPasswordPage.ClickTryAgain();
    }

   // C146201 Verify user gets the reset password email link by entering valid email when user taps on the Submit button
    @Test
    public void RegisteredEmailIdMsgVerification() throws InterruptedException {
        forgotPasswordPage.SignInClick();
        forgotPasswordPage.ForgotpasswordClick();
        forgotPasswordPage.getEmail().sendKeys("tjbussfl@spireon.com");
        forgotPasswordPage.Submit_btn_Click();
        Thread.sleep(4000);
        Assert.assertEquals(forgotPasswordPage.getResetMsg(),"Reset instruction sent successfully!");
        forgotPasswordPage.ClickOkbtn2();
    }

    //C146207 Verify that when you tap on "FleetLocate Support," it should take you to the support screen.
      @Test
      public void  SupportScreenVerification()
      {
          forgotPasswordPage.SignInClick();
          forgotPasswordPage.ForgotpasswordClick();
          forgotPasswordPage.getFleetLocateSupport().click();
          Assert.assertEquals(forgotPasswordPage.getSupport_Title(),"Support");

      }

      // C146208 Verify Support screen has Email support and Call support buttons
      @Test
      public void EmailandCallSupportVerification()
      {
          forgotPasswordPage.SignInClick();
          forgotPasswordPage.ForgotpasswordClick();
          forgotPasswordPage.getFleetLocateSupport().click();
          Assert.assertTrue(forgotPasswordPage.getEmailSupport_Btn().isDisplayed());
          Assert.assertTrue(forgotPasswordPage.getEmailSupport_Btn().isEnabled());
          Assert.assertTrue(forgotPasswordPage.getCallSupport_Btn().isDisplayed());
          Assert.assertTrue(forgotPasswordPage.getCallSupport_Btn().isEnabled());
      }

      //C146559 Verify proper n/w error message is shown when user taps on the submit button if n/w fails
      @Test
     public void NetworkErrorMessage()
     {
         forgotPasswordPage.SignInClick();
         forgotPasswordPage.ForgotpasswordClick();
         forgotPasswordPage.getEmail().sendKeys("tjbussfl@spireon.com");
         driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());
         forgotPasswordPage.Submit_btn_Click();
         Assert.assertEquals(forgotPasswordPage.getNetworkErrorMsg(),"Please check your network connection and try again.");
         forgotPasswordPage.ClickOkbtn3();
     }



}
