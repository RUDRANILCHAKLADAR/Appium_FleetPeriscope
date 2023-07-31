package AppiumAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utility.ActionClass;
import utility.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseTest {
    private AppiumDriver driver;

    private static Constants.Platform currentPlatform = Constants.Platform.ANDROID;

    public static final Logger Log = LoggerFactory.getLogger(BaseTest.class);

    protected abstract void initPage();

    @Parameters({"emulator", "platformName", "udid", "deviceName", "systemPort",
            "chromeDriverPort", "wdaLocalPort", "webkitDebugProxyPort"})
    @BeforeClass
    public void beforeTest(@Optional("androidOnly") String emulator, @Optional("androidOnly") String platformName, @Optional("androidOnly") String udid, @Optional("androidOnly") String deviceName,
                           @Optional("androidOnly") String systemPort, @Optional("androidOnly") String chromeDriverPort,
                           @Optional("iOSOnly") String wdaLocalPort, @Optional("iOSOnly") String webkitDebugProxyPort) throws Exception {

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

//        platformName = "android";
        switch (Constants.Platform.getPlatformFromName(platformName)) {

            case ANDROID:
                currentPlatform = Constants.Platform.ANDROID;
                UiAutomator2Options options = new UiAutomator2Options();
                options.setDeviceName(prop.getProperty("AndroidDeviceName"));
                options.setPlatformName("android");
                options.setAutomationName(prop.getProperty("androidAutomationName"));
                if (System.getenv("BITRISE_APK_PATH") == null && System.getenv("BITRISE_SOURCE_DIR") == null) {
                    options.setApp(System.getProperty("user.dir") + prop.getProperty("androidAppPath"));
                } else if (System.getenv("BITRISE_APK_PATH") != null) {
                    options.setApp(System.getenv("BITRISE_APK_PATH"));
                } else {
                    options.setApp(System.getenv("BITRISE_SOURCE_DIR") + "/src/test/java/App/app-fleetStaging-debug.apk");
                }

                options.setCapability("uiautomator2ServerInstallTimeout", 20000);
                //options.autoGrantPermissions();
                driver = new AndroidDriver(url, options);
                break;
            case iOS:
                currentPlatform = Constants.Platform.iOS;
                XCUITestOptions option = new XCUITestOptions();
                option.setDeviceName(prop.getProperty("iOSDeviceName"));
                option.setPlatformName("iOS");
                option.setAutomationName(prop.getProperty("iosAutomationName"));
                option.setPlatformVersion(prop.getProperty("iOSVersion"));
                option.setWdaLaunchTimeout(Duration.ofSeconds(30));
                //option.setApp(System.getProperty("user.dir") + "//App//Fleet Staging.app");
                option.setApp(System.getProperty("user.dir") + prop.getProperty("iOSAppPath"));
                option.autoAcceptAlerts();
                driver = new IOSDriver(url, option);
                break;
            default:
                throw new Exception("Invalid platform! - " + platformName);
        }

        Log.info("driver initialized: " + driver);

        initPage();
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public AndroidDriver getAndroidDriver() {
        return ((AndroidDriver) driver);
    }

    public IOSDriver getIosDriver() {
        return ((IOSDriver) driver);
    }

    public Constants.Platform getCurrentPlatform() {
        return currentPlatform;
    }

    public static boolean isAndroidPlatform() {
        return currentPlatform == Constants.Platform.ANDROID;
    }

    public static boolean isIosPlatform() {
        return currentPlatform == Constants.Platform.iOS;
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

}
