package AppiumAutomation;

import android.AlertsPage;
import android.ForgotPasswordPage;
import android.MapScreenPage;
import android.SignInPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.PointOption.point;

public class BaseClass {

    public static AndroidDriver driver;
    public SignInPage signinpage;
    public ForgotPasswordPage forgotPasswordPage;

    public MapScreenPage mapScreenPage;
    public AlertsPage alertsPage;
    public void pullToRefresh() {
        int deviceWidth = BaseClass.driver.manage().window().getSize().getWidth();
        int deviceHeight = BaseClass.driver.manage().window().getSize().getHeight();
        int midX = deviceWidth / 2;
        int midY = deviceHeight / 2;
        int bottomEdge = (int)((float)deviceHeight * 0.85F);
        (new TouchAction(BaseClass.driver)).press(PointOption.point(midX, midY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10L))).moveTo(PointOption.point(midX, bottomEdge)).release().perform();
    }


    @BeforeClass
    public void ConfigureAppium() throws IOException, InterruptedException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//Configuration//config.properties");
        prop.load(fis);
        String ipAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("iPort");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(prop.getProperty("AndroidDeviceName"));
        options.setPlatformName("android");
        options.setApp(prop.getProperty("androidAppPath"));
        //options.setDeviceName("Pixel 4 ");
        driver = new AndroidDriver(new URL(prop.getProperty("appiumURL")), options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        signinpage = new SignInPage(driver);
        forgotPasswordPage=new ForgotPasswordPage(driver);
         mapScreenPage=new MapScreenPage(driver);
        alertsPage=new AlertsPage(driver);
    }
        @AfterClass
        public void tearDown()
        {
            driver.quit();
            // service.stop();
        }
    }



