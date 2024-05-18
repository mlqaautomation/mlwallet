package KPX_WEB;

import com.utility.LoggingUtils;
import org.testng.Assert;
import com.utility.propertyReader;
import com.utility.WebUtilities;
import com.utility.ExtentReporter;

public abstract class Base_Steps {
    WebUtilities utilities = new WebUtilities();
    ExtentReporter extentReporter = new ExtentReporter();
    Google_PageObjects google_PageObjects = new Google_PageObjects();
    Login_PageObjects loginPageObjects =  new Login_PageObjects();
    yamlReader reader = new yamlReader();
    LoggingUtils logger = new LoggingUtils();


    final String filepath = "src\\test\\java\\resources\\testData.properties";
    propertyReader propertyReader = new propertyReader(filepath);
    Assert anAssert;
}
