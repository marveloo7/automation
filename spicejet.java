package test;



import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Common.Browser;
import Common.config;
import PLibrary.App_Add_passengers;



public class spicejet
{
	
	@BeforeTest
	@Parameters({"browser","url"})
	public void getdrivers(String browser,String url) throws Exception {
	 Browser.beforeMethod(url, browser);
	 
	}

	@Test(priority = 1)
	@Parameters("url")
	public void TC01Spicejet(String url) throws InterruptedException
	{
			App_Add_passengers.First();	
			
	}

	@Test(priority = 2, dependsOnMethods = {"TC01Spicejet"})
	public void TC02FlightsSpicejet() throws InterruptedException
	{
		App_Add_passengers.Second();
	}


	
	
	
	
	@AfterTest
	public void quit() {
		config.driver.quit();
	}
	@AfterMethod
	 public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			File scrFile = ((TakesScreenshot)config.driver).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(scrFile, new File("Screenshorts/" + testResult.getName() + "-" 
					+ Arrays.toString(testResult.getParameters()) +  ".png"));
		}
	}	

}
