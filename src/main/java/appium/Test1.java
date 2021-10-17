package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Test1 {
	static AppiumDriver<MobileElement>driver;
	static ExtentReports extent = new ExtentReports();

	@BeforeTest
	public static void StartMobile() throws MalformedURLException {
		
DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName","Samsong note 9");
		cap.setCapability("udid","so5t9pwk89onfagq");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","9.0.0");
		
		cap.setCapability("appPackage","co.ordera" );
		cap.setCapability("appActivity", "SplashActivity");
		
		driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), cap);
		System.out.println("app started....");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		ExtentXReporter extentxReporter = new ExtentXReporter("Appium Test");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		
	}
 
	@Test
	public static void Test1() {
		// creating tests
	
		ExtentTest test = extent.createTest("Appium Test 1");
		test.log(Status.PASS, "pass");
		test.log(Status.FAIL, "fail");
		test.pass("details");

		// short-hand for above
		extent
		    .createTest("Our Test")
		    .pass("details");
			
		driver.findElement(By.id("loginBtn")).click();		
		extent
		    .createTest("Our Test", "Test Description")
		    .pass("details");
		
		
	}

}
