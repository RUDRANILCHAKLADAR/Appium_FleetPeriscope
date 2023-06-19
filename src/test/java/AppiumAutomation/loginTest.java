package AppiumAutomation;

import android.loginPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class loginTest extends BaseTest {

    loginPage signinpage;
    String platformName;


    @BeforeMethod
    public void beforeMethod(Method m) {
        signinpage = new loginPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
    }

    @Test(priority = 1)
    public void testLoginUiElementsValidation() {
        actions.waitForVisibility(signinpage.SignIn);
        Assert.assertTrue(actions.findElement(signinpage.SignIn).isDisplayed());
        actions.clickElement(signinpage.SignIn);
        actions.waitForVisibility(signinpage.Username);
        Assert.assertTrue(actions.findElement(signinpage.Username).isDisplayed());
        Assert.assertTrue(actions.findElement(signinpage.Password).isDisplayed());
        Assert.assertTrue(actions.findElement(signinpage.Username).isDisplayed());
        Assert.assertTrue(actions.findElement(signinpage.forgotPassword).isDisplayed());
        Assert.assertTrue(actions.findElement(signinpage.backButton).isEnabled());
    }


    @Parameters({"platformName"})
    @Test(enabled=false)
    public void testForgotPasswordScreenValidation() throws InterruptedException {
        actions.waitForVisibility(signinpage.SignIn);
        Assert.assertTrue(actions.findElement(signinpage.SignIn).isDisplayed());
        actions.clickElement(signinpage.SignIn);
        actions.clickElement(signinpage.forgotPassword);
        if (platformName.equals("android")) {
            String ActualErrorMessage = signinpage.forgotPwdHeader.getText();
            String ExpectedResult = "Forgot Password";
            Assert.assertEquals(ActualErrorMessage, ExpectedResult);
            return;
        }
        else
            if(platformName.equals("iOS")){
                String ActualErrorMessage = signinpage.forgotPwdHeader.getText();
                String ExpectedResult = "Forgot Password?";
                Assert.assertEquals(ActualErrorMessage, ExpectedResult);
                return;

            }
//        String ActualErrorMessage = signinpage.forgotPwdHeader.getText();
//        String ExpectedResult = "Forgot Password";
//        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        Thread.sleep(3000);
        actions.clickElement(signinpage.backButton);
    }
}
