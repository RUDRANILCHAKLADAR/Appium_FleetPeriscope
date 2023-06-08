package AppiumAutomation;

import Android.AlertsPage;
import Android.ForgotPasswordPage;
import Android.MapScreenPage;
import Android.SignInPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
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

    public MapScreenPage  mapScreenPage;
    public AlertsPage     alertsPage;
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
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//Configuration//config");
        prop.load(fis);
        String ipAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("iPort");

//       service = new AppiumServiceBuilder().
//                withAppiumJS(new File("//opt//homebrew//Cellar//node//19.1.0//lib//node_modules//appium//build//lib//main.js")).
//                withIPAddress(ipAddress).usingPort(Integer.parseInt(port))
//                .build();
//       service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(prop.getProperty("AndroidDeviceName"));
        options.setPlatformName("Android");
        options.setApp(prop.getProperty("AppPath"));
        //options.setDeviceName("Pixel 4 ");
        driver = new AndroidDriver(new URL(prop.getProperty("Url")), options);
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



