package datadriven;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestAppium {
    private AndroidDriver driver;  //global variable

    //external data source
    ReadData excel = new ReadData("TestDataFile/datadriven.xlsx");

    @Before
    public void setUp() throws MalformedURLException {

        System.out.println("now the shows begins");

        //appium desired capabilities start here
        //essential desired capabilities for setup the connection between appium server and emulator device
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("platformName", "Android");

        desiredCapabilities.setCapability("appium:platformVersion", "11.0");

        desiredCapabilities.setCapability("appium:deviceName", "4.7_WXGA_API_30");

        desiredCapabilities.setCapability("appium:automationName", "appium");

        desiredCapabilities.setCapability("appium:noRest", true);

        desiredCapabilities.setCapability("appium:udid", "emulator-5554"); //special emulator id

        //required desired capabilities to launch the particular application
        desiredCapabilities.setCapability("appPackage", "com.android.dialer");

        desiredCapabilities.setCapability("appActivity", "com.android.dialer.main.impl.MainActivity");

        //appium server url
        URL remoteUrl = new URL(excel.getData(0,0,0));

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);


    }

    @Test
    public void sampleTest() {

        // trap element description
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ImageView");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.android.dialer:id/empty_list_view_action");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"9,WXYZ\"]/android.widget.LinearLayout/android.widget.TextView");
        el7.click();

        //phone dialer trap element description
        MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0,0,1));
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0,1,0));
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0,1,1));
        el10.click();
        MobileElement el11 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0,2,0));
        el11.click();
        MobileElement el12 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0,2,1));
        el12.click();
        MobileElement el13 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0,3,0));
        el13.click();
        MobileElement el14 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0,3,1));
        el14.click();
        MobileElement el15 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0,4,0));
        el15.click();
        MobileElement el16 = (MobileElement) driver.findElementByAccessibilityId(excel.getData(0,4,1));
        el16.click();
        //locate the edit box of the dialer by using getText()
        MobileElement el19 = (MobileElement) driver.findElementById("com.android.dialer:id/digits");
        el19.getText();
        //Check the input value on the edit box and assert it
        assert el19.getText().equals("9897654785"):"Actual value is : "+el19.getText()+" did not match with expected value: 9897654785";
        System.out.println("test should be failed");
    }

    @After
    public void tearDown() {
        System.out.println("test is completed");
        driver.quit();

    }

}

