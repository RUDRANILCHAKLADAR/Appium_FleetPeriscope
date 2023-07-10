package AppiumAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utility.ActionClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public AppiumDriverLocalService service;
    public static AppiumDriver driver;
    ActionClass actions;
    public static final Logger Log = LoggerFactory.getLogger(BaseTest.class);


    @Parameters({"emulator", "platformName", "udid", "deviceName", "systemPort",
            "chromeDriverPort", "wdaLocalPort", "webkitDebugProxyPort"})
    @BeforeClass
    public void beforeTest(@Optional("androidOnly")String emulator, String platformName, String udid, String deviceName,
                           @Optional("androidOnly")String systemPort, @Optional("androidOnly")String chromeDriverPort,
                           @Optional("iOSOnly")String wdaLocalPort, @Optional("iOSOnly")String webkitDebugProxyPort) throws Exception {

        Properties prop = new Properties();

        String strFile = "logs" + File.separator + platformName + "_" + deviceName;
        File logFile = new File(strFile);
        if (!logFile.exists()) {
            logFile.mkdirs();
        }
        Log.info("log path: " + strFile);


        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//Configuration//config.properties");
        prop.load(fis);

        URL url = new URL(prop.getProperty("appiumURL"));

        switch(platformName) {

                case "android":
                    currentPlatform= Platform.ANDROID;
                    UiAutomator2Options options = new UiAutomator2Options();
                    options.setDeviceName(prop.getProperty("AndroidDeviceName"));
                    options.setPlatformName("android");
                    options.setAutomationName(prop.getProperty("androidAutomationName"));
                    if(System.getenv("BITRISE_APK_PATH")==null){
                       options.setApp(prop.getProperty("androidAppPath"));
                    }
                    else
                        options.setApp(System.getenv("BITRISE_APK_PATH"));
                    options.setCapability("uiautomator2ServerInstallTimeout", 20000);
                    //options.autoGrantPermissions();
                    driver = new AndroidDriver(url, options);

                    break;
                case "iOS":
                    currentPlatform=Platform.iOS;
                    XCUITestOptions option = new XCUITestOptions();
                    option.setDeviceName(prop.getProperty("iOSDeviceName"));
                    option.setPlatformName("iOS");
                    option.setAutomationName(prop.getProperty("iosAutomationName"));
                    option.setPlatformVersion(prop.getProperty("iOSVersion"));
                    option.setWdaLaunchTimeout(Duration.ofSeconds(30));
                    //option.setApp(System.getProperty("user.dir") + "//App//Fleet Staging.app");
                    option.setApp(prop.getProperty("iOSAppPath"));
                    option.autoAcceptAlerts();
                    driver = new IOSDriver(url, option);
                    break;
                default:
                    throw new Exception("Invalid platform! - " + platformName);
            }
            setDriver(driver);
           Log.info("driver initialized: " + driver);

           actions= new ActionClass(driver);

    }

    private void setDriver(AppiumDriver driver2) {
        driver=driver2;
    }


    public AppiumDriver getDriver() {
        if(currentPlatform== Platform.ANDROID){
            return ((AndroidDriver)driver);
        }

        else
            return ((IOSDriver)driver);
    }


    enum Platform {
        ANDROID,
        iOS
    }
    public Platform currentPlatform = Platform.ANDROID;

    @AfterTest (alwaysRun = true)
    public void afterTest() {
        if(getDriver() != null){
            getDriver().quit();
        }
    }

}
