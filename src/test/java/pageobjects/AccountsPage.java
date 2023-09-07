package pageobjects;

import core.testrail.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class AccountsPage extends BasePage {

    public AccountsPage(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Account\"`]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    public WebElement accountsText;

    @AndroidFindBy(xpath ="//android.widget.TextView[@text='Account']")
    public WebElement accountTitle;


    @iOSXCUITFindBy(accessibility = "Logout")
    @AndroidFindBy(accessibility ="Logout")
    public WebElement logoutButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Account\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/action_account")
    public WebElement accountBottomBar;

    @iOSXCUITFindBy(accessibility = "What's New")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/tv_account_item")
    public WebElement whatsNewButton;

    @iOSXCUITFindBy(accessibility = "Profile")
    @AndroidFindBy(xpath ="//android.widget.TextView[@text='Profile']")
    public WebElement profileButton;

    @iOSXCUITFindBy(accessibility = "Support")
    @AndroidFindBy(xpath ="//android.widget.TextView[@text='Support']")
    public WebElement supportButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Profile\"`]")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/iv_profile_title")
    public WebElement   profileTitle;

    @iOSXCUITFindBy(accessibility = "Back")
    @AndroidFindBy(id = "com.spireon.fleet.staging:id/iv_back_button")
    public WebElement backButton;

    @iOSXCUITFindBy(accessibility = "Back")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
    public WebElement backButton2;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Support\"`]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Support']")
    public WebElement supportTitle;

    public String getAccountTitle() {
        return accountTitle.getText();
    }
    public String accountText="Account";
    public String getSupportTitle() {
        return supportTitle.getText();
    }
    public String supportText="Support";
    public String getProfileTitle() {
        return profileTitle.getText();
    }
    public String profileText="Profile";

    public WebElement getSupportButton()
    {
        return supportButton;
    }


    public WebElement getProfileButton()
    {
        return profileButton;
    }
    public WebElement getWhatsNewButton()
    {
        return whatsNewButton;
    }

    public WebElement getLogoutButton()
    {
        return logoutButton;
    }

}
