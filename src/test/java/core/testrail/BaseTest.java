package core.testrail;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import static core.testrail.Constants.*;

public abstract class BaseTest {
    private AppiumDriver driver;
    public static EnvProperties envProperties;
    private static Constants.Platform currentPlatform = Constants.Platform.ANDROID;

    public static final Logger Log = LoggerFactory.getLogger(BaseTest.class);

    protected abstract void init(ITestContext context);
    protected abstract void deInit();

    @Parameters({"emulator", "platformName", "udid", "deviceName", "systemPort",
            "chromeDriverPort", "wdaLocalPort", "webkitDebugProxyPort"})
    @BeforeClass
    public void beforeTest(@Optional("androidOnly") String emulator, @Optional String platformName, @Optional String udid, @Optional String deviceName,
                           @Optional("androidOnly") String systemPort, @Optional("androidOnly") String chromeDriverPort,
                           @Optional("iOSOnly") String wdaLocalPort, @Optional("iOSOnly") String webkitDebugProxyPort,ITestContext context) throws Exception {

        ConsoleLogger.setLoggable(false);

        Properties prop = new Properties();
        String strFile = "logs" + File.separator + platformName + "_" + deviceName;
        File logFile = new File(strFile);
        if (!logFile.exists()) {
            logFile.mkdirs();
        }
        Log.info("log path: " + strFile);

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + CONFIG_PROPERTIES_PATH);
        prop.load(fis);

        URL url = new URL(prop.getProperty(APPIUM_URL));
        switch (Constants.Platform.getPlatformFromName(platformName)) {

            case ANDROID:
                currentPlatform = Constants.Platform.ANDROID;
                UiAutomator2Options options = new UiAutomator2Options();
                options.setDeviceName(prop.getProperty(ANDROID_DEVICE_NAME));
                options.setPlatformName(ANDROID_PLATFORM_NAME);
                options.setAutomationName(prop.getProperty(ANDROID_AUTOMATION_DRIVER));
                if (System.getenv("BITRISE_APK_PATH") == null && System.getenv("BITRISE_SOURCE_DIR") == null) {
                    options.setApp(System.getProperty("user.dir") + prop.getProperty(ANDROID_APP_PATH));
                } else if (System.getenv("BITRISE_APK_PATH") != null) {
                    options.setApp(System.getenv("BITRISE_APK_PATH"));
                } else {
                    options.setApp(System.getenv("BITRISE_SOURCE_DIR") + prop.getProperty(Constants.ANDROID_APP_PATH));
                }

                options.setCapability(ANDROID_SERVER_INSTALL_TIMEOUT, 20000);
                //options.autoGrantPermissions();
                driver = new AndroidDriver(url, options);
                break;
            case iOS:
                currentPlatform = Constants.Platform.iOS;
                XCUITestOptions option = new XCUITestOptions();
                option.setDeviceName(prop.getProperty(IOS_DEVICE_NAME));
                option.setPlatformName(IOS_PLATFORM_NAME);
                option.setAutomationName(prop.getProperty(IOS_AUTOMATION_DRIVER));
                option.setPlatformVersion(prop.getProperty(IOS_VERSION));
                option.setWdaLaunchTimeout(Duration.ofSeconds(30));
                //option.setApp(System.getProperty("user.dir") + "//App//Fleet Staging.app");
                option.setApp(prop.getProperty(IOS_APP_PATH));
                option.autoAcceptAlerts();
                driver = new IOSDriver(url, option);
                break;
            default:
                throw new Exception("Invalid platform! - " + platformName);
        }
        Log.info("driver initialized: " + driver);


        init(context);
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

    @Parameters("environment")
    @BeforeSuite
    public void beforeSuite(ITestContext ctx,@Optional String environment) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + Constants.ENVIRONMENT_CONFIG_PATH));

            JSONObject jsonObject =  (JSONObject) obj;
            ctx.setAttribute(Constants.ENVIRONMENT_CONFIG, jsonObject.get(environment));
            ctx.setAttribute(Constants.ENVIRONMENT_NAME, environment);
            envProperties = new EnvProperties(ctx);
            System.out.println(envProperties.getIdentityBaseUrl());
        } catch (Exception exception) {
            System.out.println("error reading config file --: "+exception);
        }
    }


    @AfterClass(alwaysRun = true)
    public void afterTest() {
        deInit();
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

}
