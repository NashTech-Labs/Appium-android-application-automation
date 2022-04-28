package datadriven;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.jboss.logging.BasicLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestPhoneDialer {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    ReadDataConfig excel = new ReadDataConfig("src/test/resources/datadriven.xlsx");  //external data source
    private AndroidDriver driver;  //global variable
    private BasicLogger logger;

    @Before
    public void setUp() throws MalformedURLException {
        // System.out.println("now the shows begins");
        LOGGER.log(Level.INFO, "now the shows begins");
        //essential desired capabilities for setup the connection between appium server and emulator device
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:platformVersion", "11.0");
        desiredCapabilities.setCapability("appium:deviceName", "4.7_WXGA_API_30");
        desiredCapabilities.setCapability("appium:automationName", "appium");
        desiredCapabilities.setCapability("appium:noReset", true);
        desiredCapabilities.setCapability("appium:udid", "emulator-5554"); //special emulator id
        desiredCapabilities.setCapability("appPackage", "com.android.dialer");  //required desired capabilities to launch the particular application
        desiredCapabilities.setCapability("appActivity", "com.android.dialer.main.impl.MainActivity");
        URL remoteUrl = new URL(excel.getData(0, 0, 0)); //appium server url
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void dialNumbers() {
        // trap element description
        MobileElement pressOnRecent = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ImageView");
        pressOnRecent.click();
        MobileElement pressOnCall = (MobileElement) driver.findElementById("com.android.dialer:id/empty_list_view_action");
        pressOnCall.click();
        //phone dialer element description
        MobileElement press8 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0, 4, 1));
        press8.click();
        MobileElement press2 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0, 3, 1));
        press2.click();
        MobileElement press7 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0, 3, 0));
        press7.click();
        MobileElement press6 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0, 2, 1));
        press6.click();
        MobileElement press5 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0, 2, 0));
        press5.click();
        MobileElement press4 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0, 1, 1));
        press4.click();
        MobileElement press3 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0, 1, 0));
        press3.click();
        MobileElement press1 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0, 0, 1));
        press1.click();
        MobileElement press8Again = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0, 4, 1));
        press8Again.click();
        MobileElement press9 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0, 4, 0));
        press9.click();
        MobileElement locateAllElement = (MobileElement) driver.findElementById("com.android.dialer:id/digits");  //locate the edit box of the dialer by using getText()
        locateAllElement.getText();
        //Check the input value on the edit box and assert it
        assert locateAllElement.getText().equals(excel.getData(0, 5, 0)) : "Actual value : " + locateAllElement.getText() + " did not match with expected value";
        LOGGER.log(Level.INFO, " expected value is:" + locateAllElement.getText() + " and the Actual value is:" + excel.getData(0, 5, 0));
    }

    @After
    public void tearDown() {
        LOGGER.log(Level.INFO, "test is completed");
        driver.quit();
    }
}