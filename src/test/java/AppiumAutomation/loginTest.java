package AppiumAutomation;

import android.SignInPage;
import android.loginPage;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.ActionClass;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class loginTest extends BaseTest {

    //ActionClass actions=new ActionClass(driver);

    SignInPage signinpage;
    String platformName;


    @BeforeMethod
    public void beforeMethod(Method m) {
        signinpage = new SignInPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
    }

//    @Test(priority = 0)
//    public void AccountDialogueScreenVerification(){
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        actions.clickElement(actions.findElement(signinpage.SignIn));
//        signinpage.setUsername("tjbussfl");
//        signinpage.setPassword("123456");
//        actions.clickElement(actions.findElement(signinpage.SignIn));
//        actions.waitForVisibility(signinpage.getAccount_Dialogue_Screen());
//        Assert.assertTrue(signinpage.getAccount_Dialogue_Screen().isDisplayed());
//        actions.clickElement(signinpage.selectBtn);
//        if(signinpage.permission_access.isDisplayed() &&
//                signinpage.permission_access.isElementPresent()){
//            actions.clickElement(signinpage.permission_access);
//        }
//        else if(!signinpage.permission_access.isDisplayed())
//        {
//            actions.clickElement(signinpage.Account_icon);
//        }
//        else
//            return ;
//
//        //actions.clickElement(signinpage.permission_access);
//        //actions.clickElement(signinpage.Account_icon);
//        actions.clickElement(signinpage.Logout);
//        actions.clickElement(signinpage.Confirm_btn);
//    }




//    @Test
//    public void EmptyLoginCredentialsvalidation() throws InterruptedException {
//        actions.waitForVisibility(signinpage.SignIn);
//        actions.clickElement(signinpage.SignIn);
//        signinpage.setUsername("tjbussfl");
//        actions.clickElement(signinpage.SignIn);
//        actions.waitForVisibility(signinpage.errorMessage);
//        Assert.assertEquals(signinpage.getErrorMsg(), "Please enter a valid password");
//        Thread.sleep(2000);
//        actions.clickElement(signinpage.ok_cancel_Button);
//        Thread.sleep(2000);
//        signinpage.setUsername("");
//        signinpage.setPassword("123456");
//        actions.clickElement(signinpage.SignIn);
//        Assert.assertEquals(signinpage.getErrorMsg(), "Please enter a valid username");
//        Thread.sleep(2000);
//        actions.clickElement(signinpage.ok_cancel_Button);
//        signinpage.getPassword().clear();
//        actions.clickElement(signinpage.SignIn);
//        Assert.assertEquals(signinpage.getErrorMsg(), "Please enter a valid username");
//        actions.clickElement(signinpage.ok_cancel_Button);
//
//    }

//    @Test
//    public void test(){
//
//        actions.waitForVisibility(signinpage.SignIn);
//        actions.clickElement(signinpage.SignIn);
//        signinpage.setUsername("tjbussfl");
//        actions.clickElement(signinpage.SignIn);
//        actions.waitForVisibility(signinpage.errorMessage);
//        Assert.assertEquals(signinpage.getErrorMsg(), "Please enter a valid password");
//        if (Objects.equals(platformName, "android")) {
//            String ActualErrorMessage = signinpage.ForgotPasswordTxt.getText();
//            String ExpectedResult = "Forgot Password";
//            Assert.assertEquals(ActualErrorMessage, ExpectedResult);
//
//        }
//        else
//            if(platformName.equals("iOS")){
//               String ActualErrorMessage = signinpage.iosForgotPwTxt.getText();
//                String ExpectedResult = "Forgot Password?";
//                Assert.assertEquals(ActualErrorMessage, ExpectedResult);
//                return;
//
//            }
//
//
//
//    }
}
