package AppiumAutomation;

import Android.SignInPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.PointOption.point;

public class SignInTestCases extends BaseClass {

    @Test(priority = 0)
    public void AccountDialogueScreenVerification() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        signinpage.getSignIn().click();
        signinpage.getUsername().click();
        signinpage.getUsername().sendKeys("tjbussfl");
        signinpage.getPassword().click();
        signinpage.getPassword().sendKeys("123456");
        signinpage.getSignIn().click();
        Thread.sleep(2000);
        Assert.assertTrue(signinpage.getAccount_Dialogue_Screen().isDisplayed());
        Thread.sleep(2000);
        signinpage.getSelectbtn().click();
        signinpage.Click_Permission();
        signinpage.getAccount_icon().click();
        signinpage.getLogout().click();
        signinpage.getConfirm_btn().click();

    }


    //Verify Choose account screen is shown for some user if user scope is set
    //C18779,C146195-To check whether all the SignIn elements are displayed or not
    @Test(priority = 2)
    public void LoginUIelementsvalidation() {
        signinpage.getCancelbtn().click();
        Assert.assertTrue(signinpage.getSignIn().isDisplayed());
        //signinpage.getSignIn().click();
        Assert.assertTrue(signinpage.getUsername().isDisplayed());
        Assert.assertTrue(signinpage.getPassword().isDisplayed());
        Assert.assertTrue(signinpage.getLogin().isDisplayed());
        Assert.assertTrue(signinpage.getForgotpassword().isDisplayed());
        Assert.assertEquals(signinpage.getLoginMsg(), "with your username and password");
        Assert.assertEquals(signinpage.getSignIntxt(), "Sign In");
        Assert.assertTrue(signinpage.getBackbutton().isEnabled());

    }
    @Test(priority = 1)
    public void ForgotPasswordScreenValidation() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        signinpage.getSignIn().click();
        signinpage.getForgotpassword().click();
        String ActualErrorMessage = signinpage.getForgotPasswordTxt();
        String ExpectedResult = "Forgot Password";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        Thread.sleep(3000);
        signinpage.getBackbutton2().click();
    }

    //C18780-Verify user is able to enter the username and password in the Sign in Screen
    @Test(priority = 3)
    public void LoginCredentialsvalidation() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //  signinpage.getSignIn().click();
        signinpage.getUsername().click();
        signinpage.getUsername().sendKeys("tjbussfl");
        signinpage.getPassword().click();
        signinpage.getPassword().sendKeys("123456");
    }


    //C18783-Verify proper message is shown if username or password fields are missing and tapping on Sign in button
    @Test(priority = 4)
    public void EmptyLoginCredentialsvalidation() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //  signinpage.getSignIn().click();
        signinpage.getUsername().clear();
        signinpage.getPassword().clear();
        signinpage.getUsername().sendKeys("tjbussfl");
        signinpage.getSignIn().click();
        Assert.assertEquals(signinpage.getpswrdErrMsg(), "Please enter a valid password");
        Thread.sleep(2000);
        signinpage.getOkbtn().click();
        Thread.sleep(2000);
        signinpage.getUsername().clear();
        signinpage.getPassword().sendKeys("123456");
        signinpage.getSignIn().click();
        Assert.assertEquals(signinpage.getusrnmErrrMsg(), "Please enter a valid username");
        Thread.sleep(2000);
        signinpage.getOkbtn().click();
        signinpage.getPassword().clear();
        signinpage.getSignIn().click();
        Assert.assertEquals(signinpage.getusrnmErrrMsg(), "Please enter a valid username");
        signinpage.getOkbtn().click();

    }

    @Test(priority = 5)
    public void InvalidCredentialValidations() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //signinpage.getSignIn().click();
        signinpage.getUsername().clear();
        signinpage.getUsername().sendKeys("tjbuss");
        signinpage.getPassword().clear();
        signinpage.getPassword().sendKeys("1234");
        wait.until(ExpectedConditions.elementToBeClickable(signinpage.getSignIn()));
        signinpage.getSignIn().click();
        String actualerror = signinpage.getInvalidLoginErrMsg();
        String expectedresult = "The credentials entered do not match our records. Verify your username and password.";
        Assert.assertEquals(actualerror, expectedresult);
        Thread.sleep(2000);
        signinpage.getTryagainBtn().click();
    }

    @Test(priority = 6)
    public void NoInternetConnection() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //signinpage.getSignIn().click();
        // To disable wifi/ Data connection
        //driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());
        signinpage.getUsername().clear();
        signinpage.getUsername().sendKeys("fleetdrivertest1@mailinator.com");
        signinpage.getPassword().clear();
        signinpage.getPassword().sendKeys("243234");
        Assert.assertTrue(signinpage.getSignIn().isEnabled());
        driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());
        signinpage.getSignIn().click();
        String ActualErrorMessage = signinpage.getNetworkErrMsg();
        String ExpectedResult = "Please check your network connection and try again.";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        //To enable wifi / data connection
        driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled().build());
        signinpage.getOkbtn2().click();
        new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.invisibilityOf(signinpage.getNetworkErr()));


    }

    //C20853-Verify after selecting a account user is able to sign in successfully
    @Test(priority = 7)
    public void UserisabletoselectanAccount() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //  signinpage.getSignIn().click();
        signinpage.getUsername().click();
        signinpage.getUsername().sendKeys("tjbussfl");
        signinpage.getPassword().click();
        signinpage.getPassword().sendKeys("123456");
        signinpage.getSignIn().click();
        Thread.sleep(2000);
        signinpage.getAccount().click();
        signinpage.getSelectbtn().click();
        Thread.sleep(2000);
        signinpage.Click_Permission();
        String ActualErrorMessage = signinpage.getFL_Periscope();
        String ExpectedResult = "FL Periscope";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        signinpage.getAccount_icon().click();
        signinpage.getLogout().click();
        signinpage.getConfirm_btn().click();

    }



    //Verify tapping on cancel button on dialogue pop up, account is not selected and user is returned to Sign In screen
    @Test(priority = 8)
    public void UserAccountSelectionCancel() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         signinpage.getSignIn().click();
        signinpage.getUsername().click();
        signinpage.getUsername().sendKeys("tjbussfl");
        signinpage.getPassword().click();
        signinpage.getPassword().sendKeys("123456");
        signinpage.getSignIn().click();
        Thread.sleep(2000);
        signinpage.getCancelbtn().click();
        Assert.assertEquals(signinpage.getSignIntxt(), "Sign In");

    }

    //Verify user is able to select one account from the list when user attempts to sign in and if multiple accounts are linked to the username
    @Test(priority = 9)
    public void AccountSelectionVerification() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //  signinpage.getSignIn().click();
        signinpage.getUsername().click();
        signinpage.getUsername().sendKeys("tjbussfl");
        signinpage.getPassword().click();
        signinpage.getPassword().sendKeys("123456");
        signinpage.getSignIn().click();
        Thread.sleep(2000);
        signinpage.clickRadioButton();
        Thread.sleep(2000);
        Assert.assertTrue(signinpage.getRadioButton().getAttribute("checked").equals("true"));
        signinpage.getCancelbtn().click();
    }

    @Test(priority = 10)
    public void UserLoginVerification() throws InterruptedException {
        //Verify user is able to select one account from the list when user attempts to sign in and if multiple accounts are linked to the username
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // signinpage.getSignIn().click();
        signinpage.getUsername().click();
        signinpage.getUsername().clear();
        signinpage.getUsername().sendKeys("tjbussfl");
        signinpage.getPassword().click();
        signinpage.getPassword().clear();
        signinpage.getPassword().sendKeys("123456");
        signinpage.getSignIn().click();
        Thread.sleep(2000);
        signinpage.clickRadioButton();
        Thread.sleep(2000);
        Assert.assertTrue(signinpage.getRadioButton().getAttribute("checked").equals("true"));

        //Verify tapping on cancel button on dialogue pop up, account is not selected and user is returned to Sign In screen
        Thread.sleep(2000);
        signinpage.getCancelbtn().click();
        Assert.assertEquals(signinpage.getSignIntxt(), "Sign In");

        //C20853-Verify after selecting a account user is able to sign in successfully
        signinpage.getUsername().sendKeys("tjbussfl");
        signinpage.getPassword().click();
        signinpage.getPassword().sendKeys("123456");
        signinpage.getSignIn().click();
        Thread.sleep(2000);
        signinpage.getAccount().click();
        signinpage.getSelectbtn().click();
        Thread.sleep(2000);
        signinpage.Click_Permission();
        String ActualErrorMessage = signinpage.getFL_Periscope();
        String ExpectedResult = "FL Periscope";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);

        signinpage.getAccount_icon().click();
        signinpage.getLogout().click();
        signinpage.getConfirm_btn().click();

    }
//
//    @Test
//    public void AdvanceUserLoginVerification() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        signinpage.getSignIn().click();
//        signinpage.getUsername().click();
//        //signinpage.getUsername().sendKeys("pratibha_mone_1");Fleet360A
//        signinpage.getUsername().sendKeys("Fleet360A");
//        signinpage.getPassword().click();
//        //signinpage.getPassword().sendKeys("123456");Password@1
//        signinpage.getPassword().sendKeys("Password@1");
//        signinpage.getSignIn().click();
//        //signinpage.getBasicUser().click();
//        //signinpage.getSelectbtn().click();
//        signinpage.getAlertButton2().click();
//        signinpage.getFilter2().click();
//        Dimension size = driver.manage().window().getSize();
//        int startX = size.width / 2;
//        int startY = (int) (size.height * 0.8);
//        int endY = (int) (size.height * 0.2);
//        new TouchAction(driver).press(point(startX, startY)).moveTo(point(startX, endY)).release().perform();
//
//        //driver.findElements
//        //  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))").click();
//        signinpage.getAssethealth_adv().click();
//        Thread.sleep(6000);
//
//
//        List<WebElement> webElementsList = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[11]"));
//        boolean isDtcFound = false;
//
//        for (WebElement element : webElementsList) {
//            System.out.print(element);
//            String elementText = element.getText();
//            if (elementText.contains("DTC")) {
//                isDtcFound = true;
//                break;
//            }
//        }
//
//        if (isDtcFound) {
//            System.out.println("Not a basic user");
//        } else {
//            System.out.println("BASIC user");
//        }
//    }
//
//
//    @Test
//    public void BasicUserLoginVerification() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        signinpage.getSignIn().click();
//        signinpage.getUsername().click();
//        signinpage.getUsername().sendKeys("pratibha_mone_1");
//        //signinpage.getUsername().sendKeys("Fleet360A");
//        signinpage.getPassword().click();
//        signinpage.getPassword().sendKeys("123456");
//        // signinpage.getPassword().sendKeys("Password@1");
//        signinpage.getSignIn().click();
//        signinpage.getBasicUser().click();
//        signinpage.getSelectbtn().click();
//        signinpage.getAlertButton().click();
//        signinpage.getFilter().click();
//
//        signinpage.getAssethealth().click();
//        signinpage.scrollAndClick();
//        Thread.sleep(6000);
//
//
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

//        boolean isDTCAlert=false;
//        for (WebElement linearLayout : signinpage.listOfFilters()) {
//            WebElement textView = linearLayout.findElement(By.id("com.spireon.fleet.staging:id/material_drawer_name"));
//            String text = textView.getText();
//       System.out.println(text);
//            if (text.contains("DTC alert")) {
//                // This LinearLayout contains a DTC alert
//                isDTCAlert=true;
//            }

    //   Assert.assertTrue(isDTCAlert,"Basic User");

    @Test(priority = 11)
    public void BacktoCarouselPageVerfication() {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        signinpage.getSignIn().click();
        signinpage.getBackbutton().click();
        Assert.assertTrue(signinpage.getTitle().isDisplayed());
    }

//    @Test
//    public void MaskingUnmaskingOfPassword()
//    {
//
//    }

    @Test(priority = 12)
    public void AccountScreenDisplayVerification() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        signinpage.getSignIn().click();
        signinpage.getUsername().click();
        signinpage.getUsername().sendKeys("tjbussfl");
        signinpage.getPassword().click();
        signinpage.getPassword().sendKeys("123456");
        signinpage.getSignIn().click();
        Thread.sleep(2000);
        Assert.assertTrue(signinpage.getAccount_Dialogue_Screen().isDisplayed());
        Thread.sleep(2000);
        //  Assert.assertTrue(signinpage.getRadioButton2().isSelected());
        Assert.assertTrue(signinpage.getRadioButton2().getAttribute("checked").equals("true"));
        Thread.sleep(2000);
        signinpage.getCancelbtn().click();
    }

    //Verify account setting is checked tapping on Sign in button for the valid user credentials




    //Verify account setting screen is not shown if user scope is not set
    @Test(priority = 13)
    public void AccountScreenNotDisplayedVerification() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //signinpage.getSignIn().click();
        signinpage.getCancelbtn2().click();
        signinpage.getUsername().click();
        signinpage.getUsername().clear();
        signinpage.getUsername().sendKeys("Fleet360A");
        signinpage.getPassword().click();
        signinpage.getPassword().clear();
        signinpage.getPassword().sendKeys("Password@1");
        signinpage.getSignIn().click();
        Assert.assertTrue(signinpage.getHomeScreen().isDisplayed());
        Thread.sleep(6000);
        if (signinpage.getHomeScreen().isDisplayed() == true)
            System.out.println("Account Screen pop up is not displayed");
        else
            System.out.println("Account Screen pop up is  displayed");

        signinpage.getAccount_icon().click();
        signinpage.getLogout().click();
        signinpage.getConfirm_btn().click();
    }


    @Test(priority = 14)
    public void AfterAccountSelectionNetworkVerfication()
    {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         signinpage.getSignIn().click();
        signinpage.getUsername().click();
        signinpage.getUsername().sendKeys("tjbussfl");
        signinpage.getPassword().click();
        signinpage.getPassword().sendKeys("123456");
        signinpage.getSignIn().click();
        signinpage.getRadioButton().click();
        driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());
        signinpage.getSelectbtn().click();
        String ActualErrorMessage = signinpage.getNetworkErrMsg();
        String ExpectedResult = "Please check your network connection and try again.";
        Assert.assertEquals(ActualErrorMessage, ExpectedResult);
        //To enable wifi / data connection
        driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled().build());

    }

}




