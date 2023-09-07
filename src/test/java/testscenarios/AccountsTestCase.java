package testscenarios;

import core.testrail.BaseTest;
import core.testrail.TestUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pageobjects.AccountsPage;


import java.time.Duration;

public class AccountsTestCase extends BaseTest
{

    public AccountsPage accountsPage;
    AppiumDriver  accountPageDriver;
    @Override
    protected void init(ITestContext context) {
        accountsPage = new AccountsPage(getDriver());
        accountPageDriver = getDriver();
        accountsPageSetup();
    }

    @Override
    protected void deInit() {
        TestUtils.logOutUser(accountsPage,accountPageDriver);
    }



    public void accountsPageSetup() {
        TestUtils.logInUser(accountsPage, accountPageDriver, "Fleet360A", "Password@1",this);
        TestUtils.waitForVisibility(accountsPage.accountBottomBar,accountPageDriver);
        accountsPage.accountBottomBar.click();
        TestUtils.handlelocationPopup(this,accountsPage,accountPageDriver);
        new WebDriverWait(accountPageDriver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(accountsPage.getWhatsNewButton()));
        Assert.assertTrue((accountsPage.getWhatsNewButton().isDisplayed()));
    }




    @Test(priority = 0)
    public void testAccountsPageUIElements()
    {
        Assert.assertTrue(accountsPage.getWhatsNewButton().isEnabled(),"The What's new Button is not enabled");
        Assert.assertTrue(accountsPage.getSupportButton().isEnabled()," The support button is not enabled");
        Assert.assertTrue(accountsPage.getProfileButton().isEnabled(),"The Profile button is not enabled");
        Assert.assertTrue(accountsPage.getLogoutButton().isEnabled(),"The Logout button is not enabled");
        TestUtils.clickElement(accountsPage.getProfileButton(),accountPageDriver);
        TestUtils.waitForVisibility(accountsPage.profileTitle,accountPageDriver);
        Assert.assertEquals(accountsPage.getProfileTitle(),accountsPage.profileText,"The Profile text is not displayed");
        TestUtils.clickElement(accountsPage.backButton, accountPageDriver);
        TestUtils.clickElement(accountsPage.getSupportButton(), accountPageDriver);
        TestUtils.waitForVisibility(accountsPage.supportTitle,accountPageDriver);
        Assert.assertEquals(accountsPage.getSupportTitle(),accountsPage.supportText,"The Support text is not displayed");
        TestUtils.clickElement(accountsPage.backButton2, accountPageDriver);
        Assert.assertEquals(accountsPage.getAccountTitle(),accountsPage.accountText,"The Account text is not displayed");
//        accountsPage.getWhatsNewButton().click();
//        accountsPage.getsupportButton().click();
//        accountsPage.getprofileButton().click();


    }

}
