package appiumTest;



	import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
	import java.net.URL;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	//import org.openqa.selenium.remote.CapabilityType;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.testng.annotations.*;


	public class Calculator {
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "8.0.0"); 
		capabilities.setCapability("deviceName","EmulatorA8");
		capabilities.setCapability("platformName","Android");
	 
	   
	   capabilities.setCapability("appPackage", "com.android.calculator2");
	// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
	//Create RemoteWebDriver instance and connect to the Appium server
	 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
	   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test 
	public void testCal() throws Exception {
	   //locate the Text on the calculator by using By.id() and click
	   driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\'Numbers and basic operations\']/android.view.ViewGroup[1]/android.widget.Button[8]")).click();
	   
	   driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"plus\"]")).click();
	   driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Numbers and basic operations\"]/android.view.ViewGroup[1]/android.widget.Button[4]")).click();
	   
	   
	   driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"equals\"]")).click();
	   
	  
	   
	   //locate the edit box of the calculator by using By.id() and get value
	   String actualNumber=(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText());
	   System.out.println(actualNumber);
		//verify the calculated value on the edit box
	assert actualNumber.equals("6"):"Actual value is : "+actualNumber+" did not match with expected value: 6";

	}

	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
	}

