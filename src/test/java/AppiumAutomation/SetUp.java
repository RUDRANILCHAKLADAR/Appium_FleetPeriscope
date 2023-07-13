package AppiumAutomation;
import android.SignInPage;
import android.TripPage;
import android.VehicleDetailsPage;
import android.VehiclePage;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;


public class SetUp{
   public static AppiumDriver driver;
   TripPage tp;
   SignInPage sp;
   VehiclePage vp;
   VehicleDetailsPage vdp;


   @BeforeClass
   public void beforeClass() {
      tp = new TripPage(driver);
      sp = new SignInPage(driver);
      vp = new VehiclePage(driver);
      vdp = new VehicleDetailsPage(driver);
   }

}
