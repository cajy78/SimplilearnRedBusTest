package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.LoginPage;

@Listeners(ListenerClass.class)
public class LoginTest extends BaseClass
{
	@Test(dataProvider="getTestData")
	public void loginTest(Hashtable<String, String> testData) throws InterruptedException, MalformedURLException 
	{	
		/*if(testData.get("browser").equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "/Users/cajetanfernandes/OneDrive/Documents/Studies_and_Certs/Automation_Testing_Masters/Phase_2/Jars/chromedriver");
			capabilities = new DesiredCapabilities();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.ANY);
			String hubURL = "http://192.168.1.34:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(hubURL), capabilities);
			driver.get("https://www.redbus.in");
			LoginPage lp = new LoginPage(driver);
			lp.enterMobileNumber(testData.get("mobile"));
		}
		else if(testData.get("browser").equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "/Users/cajetanfernandes/OneDrive/Documents/Studies_and_Certs/Automation_Testing_Masters/Phase_2/Jars/geckodriver");
			capabilities = new DesiredCapabilities();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.ANY);
			String hubURL = "http://192.168.1.34:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(hubURL), capabilities);
			driver.get("https://www.redbus.in");
			LoginPage lp = new LoginPage(driver);
			lp.enterMobileNumber(testData.get("mobile"));
		}
		else if(testData.get("browser").equals("safari"))
		{
			//System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
			capabilities = new DesiredCapabilities();
			capabilities.setBrowserName("safari");
			capabilities.setPlatform(Platform.ANY);
			String hubURL = "http://192.168.1.34:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(hubURL), capabilities);
			driver.get("https://www.redbus.in");
			LoginPage lp = new LoginPage(driver);
			lp.enterMobileNumber(testData.get("mobile"));
		}*/
		System.setProperty("webdriver.chrome.driver", "/Users/cajetanfernandes/OneDrive/Documents/Studies_and_Certs/Automation_Testing_Masters/Phase_2/Jars/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in");
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(3000);
		lp.enterMobileNumber(testData.get("mobile"));
	}
	
	@DataProvider
	public Object[][] getTestData() throws IOException
	{
		String fileName = "testdata.xlsx";
		String filePath = "/Users/cajetanfernandes/OneDrive/Documents/Studies_and_Certs/Automation_Testing_Masters/Phase_2/Eclipse-2018-09-ws/RedBusTest/";
		String sheetName = "loginData";
		return ExcelReader.ReadTestData(filePath, fileName, sheetName);
	}
}
