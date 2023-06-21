package AppiumAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.Platform;
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
import java.util.HashMap;
import java.util.Properties;

public class BaseTest {



    //public LoginPage signinpage;
    public AppiumDriverLocalService service;
    public static AppiumDriver driver;
    ActionClass actions;


    public static final Logger Log = LoggerFactory.getLogger(BaseTest.class);


//    @BeforeSuite
//    public void beforeSuite() throws Exception {
//        service = getAppiumService(); // -> If using Mac, uncomment this statement and comment below statement
//        //service = getAppiumServerDefault(); // -> If using Windows, uncomment this statement and comment above statement
//        if(!checkIfAppiumServerIsRunnning(4723)) {
//            service.start();
//            service.clearOutPutStreams(); // -> Comment this if you don't want to see server logs in the console
//            Log.info("Appium server started");
//        } else {
//            Log.info("Appium server already running");
//        }
//    }
//
//
//    public AppiumDriverLocalService getAppiumServerDefault() {
//        return AppiumDriverLocalService.buildDefaultService();
//    }
//
//    // for Mac. Update the paths as per your Mac setup
//    public AppiumDriverLocalService getAppiumService() {
//        HashMap<String, String> environment = new HashMap<String, String>();
//        environment.put("ANDROID_HOME", "/Users/MDehury/Library/Android/sdk");
//        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingDriverExecutable(new File("/usr/local/bin/node"))
//                .withAppiumJS(new File("//opt//homebrew//Cellar//node//19.1.0//lib//node_modules//appium//build//lib//main.js"))
//                .usingPort(4723)
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//                .withEnvironment(environment)
//                .withLogFile(new File("ServerLogs/server.log")));
//    }
//
//    @AfterSuite (alwaysRun = true)
//    public void afterSuite() {
//        if(service.isRunning()){
//            service.stop();
//            Log.info("Appium server stopped");
//        }
//    }

    @Parameters({"emulator", "platformName", "udid", "deviceName", "systemPort",
            "chromeDriverPort", "wdaLocalPort", "webkitDebugProxyPort"})
    @BeforeClass
    public void beforeTest(@Optional("androidOnly")String emulator, String platformName, String udid, String deviceName,
                           @Optional("androidOnly")String systemPort, @Optional("androidOnly")String chromeDriverPort,
                           @Optional("iOSOnly")String wdaLocalPort, @Optional("iOSOnly")String webkitDebugProxyPort) throws Exception {

        Properties prop = new Properties();
         //AppiumDriver driver;

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
                    currentPlatform=Platform.ANDROID;
                    UiAutomator2Options options = new UiAutomator2Options();
                    options.setDeviceName(prop.getProperty("AndroidDeviceName"));
                    options.setPlatformName("android");
                    options.setAutomationName(prop.getProperty("androidAutomationName"));
                    options.setApp(prop.getProperty("androidAppPath"));
                    driver = new AndroidDriver(url, options);
                    //loginpage=new LoginPage(driver);

                    break;
                case "iOS":
                    currentPlatform=Platform.iOS;
                    XCUITestOptions option = new XCUITestOptions();
                    option.setDeviceName(prop.getProperty("iOSDeviceName"));
                    option.setPlatformName("iOS");
                    option.setAutomationName(prop.getProperty("iosAutomationName"));
                    option.setPlatformVersion(prop.getProperty("iOSVersion"));
                    option.setWdaLaunchTimeout(Duration.ofSeconds(30));
                    option.setApp(prop.getProperty("iOSAppPath"));
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


    public boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
        boolean isAppiumServerRunning = false;
        ServerSocket socket;
        try {
            socket = new ServerSocket(port);
            socket.close();
        } catch (IOException e) {
            System.out.println("1");
            isAppiumServerRunning = true;
        } finally {
            socket = null;
        }
        return isAppiumServerRunning;
    }



    @AfterTest (alwaysRun = true)
    public void afterTest() {
        if(getDriver() != null){
            getDriver().quit();
        }
    }

}
