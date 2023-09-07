package testscenarios;

import core.testrail.BaseTest;
import core.testrail.TestUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pageobjects.LandmarkPage;


import java.time.Duration;

public class LandmarksTestCase extends BaseTest
{

    public LandmarkPage landmarkPage;

    AppiumDriver landmarkPageDriver;
    @Override
    protected void init(ITestContext context) {
        landmarkPage = new LandmarkPage(getDriver());
        landmarkPageDriver = getDriver();
        landmarkPageSetup();

    }

    @Override
    protected void deInit() {
        TestUtils.logOutUser(landmarkPage,landmarkPageDriver);
    }



    public void landmarkPageSetup() {
        TestUtils.logInUser(landmarkPage, landmarkPageDriver, "Fleet360A", "Password@1",this);
        TestUtils.waitForVisibility(landmarkPage.landmarkBottomBarIcon, landmarkPageDriver);
        landmarkPage.landmarkBottomBarIcon.click();
        TestUtils.handlelocationPopup(this,landmarkPage,landmarkPageDriver);
        new WebDriverWait(landmarkPageDriver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(landmarkPage.getLandmarkList()));
        Assert.assertTrue((landmarkPage.getLandmarkList().isDisplayed()));
    }




    @Test(priority = 0)
   public void testLandmarksUIElements()
    {
        Assert.assertTrue(landmarkPage.getSearchIcon().isEnabled());
        Assert.assertEquals(landmarkPage.getLandmarkTitle().getText(),landmarkPage.landmarkText);
       // Assert.assertTrue(landmarkPage.getlandmarkTotalCnt().isDisplayed());
        Assert.assertTrue(landmarkPage.getFilterLandmarks().isEnabled());
    }

}
