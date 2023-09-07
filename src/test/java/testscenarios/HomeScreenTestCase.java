package testscenarios;

import core.testrail.BaseTest;
import core.testrail.TestUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pageobjects.HomeScreenPage;

import java.time.Duration;




public class HomeScreenTestCase extends BaseTest {

    public HomeScreenPage homeScreenPage;

    AppiumDriver  homeScreenPageDriver;

    @Override
      protected void init(ITestContext context)
    {
        homeScreenPage = new HomeScreenPage(getDriver());
        homeScreenPageDriver = getDriver();
        homeScreenPageSetup();
    }



    @Override
    protected void deInit() {
        TestUtils.logOutUser(homeScreenPage,homeScreenPageDriver);
    }



    public void homeScreenPageSetup() {
        TestUtils.logInUser(homeScreenPage, homeScreenPageDriver, "Fleet360A", "Password@1",this);
        TestUtils.waitForVisibility(homeScreenPage.homeIcon, homeScreenPageDriver);
        homeScreenPage.homeIcon.click();
        TestUtils.handlelocationPopup(this,homeScreenPage,homeScreenPageDriver);
        new WebDriverWait(homeScreenPageDriver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(homeScreenPage.getMap()));
        Assert.assertTrue(homeScreenPage.getMap().isDisplayed(),"Home page is not displayed");
    }


    @Test(priority = 0)
    public void testHomeScreenUIElements()
    {
        Assert.assertTrue(homeScreenPage.getSettingButton().isEnabled(), "The settings button is not enabled");
        Assert.assertTrue(homeScreenPage.getSearchIcon().isEnabled(), "The search button is not enabled ");
        Assert.assertEquals(homeScreenPage.getHomeTitleText(), homeScreenPage.homeTitle, "Periscope text is not displayed on Home Screen");
        if(isAndroidPlatform())
        {
            Assert.assertTrue(homeScreenPage.getFabMap().isEnabled(), "the Fab button is not enabled");
            Assert.assertTrue(homeScreenPage.getFabCurrentLocation().isEnabled(), "the current location button is not enabled");
            Assert.assertTrue(homeScreenPage.getRefreshButton().isEnabled(), "the Refresh button is not enabled");

        }
        else
        {
            Assert.assertTrue(homeScreenPage.getAssetsIcon().isEnabled(),"The assets icon is not enabled");
            Assert.assertTrue(homeScreenPage.getTrackingIcon().isEnabled(),"The tracking icon is not enabled");
            Assert.assertTrue(homeScreenPage.getLandmarkIcon().isEnabled(),"The landmark icon is not enabled");

        }
    }


}
