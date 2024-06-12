package com.agrilin.generic;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.AutomationLibrary;
import utilities.CaptureScreenShots;

public class BaseTest implements IAutoConst {
	
	private static Logger log=LogManager.getLogger(BaseTest.class);
	
	
	public WebDriver driver;
	public static List<String> destFileList;
	/*
	 * Parameter selects the browser from the testng
	 * This method calls CreateDriver class and create instance, set the driver with respect to the browser
	 * to the Thread Local.Get the driver,Opens the browser, enter the url,maimie the browser and closes the
	 * pop ups.
	 */
	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser"})
	public  void openBrowser(@Optional ("firefox") String browserType) {
		
		CreateDriver.getInstance().setDriver(browserType);
		log.info("Driver created and called a setDriver method according to "+browserType+" browser");
		
		driver=CreateDriver.getInstance().getDriver();
		CreateDriver.getInstance().getDriver().get(AutomationLibrary.getProperty( SETTINGS_PATH,"AGRILIN_STAGING_URL"));
		driver.manage().window().maximize();
		LoginLogout.closePopUps(driver);	
		log.info("Pop Up closed...");
	}

		//calls Implicit Time Out
		public void implicitTimeOut(WebDriver driver){
			int wait=AutomationLibrary.implicitTimeOut(SETTINGS_PATH,"EXPLICIT_WAIT"); 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
			
		}
		//Calls CaptureScreenshots method and takes screenshot of current PAGE
		public static String takePageScreenshot(WebDriver driver) {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			log.info("Screenshot took in takePageScreenshot method...");
			String destFile=CaptureScreenShots.captureScreenShots(srcFile, SCREENSHOTS_FOLDER_PATH, "Agrilin");
			log.info("Screenshot file path returned...");
			return destFile;
		}
		//Calls CaptureScreenshots method and takes screenshot of WEBELEMENT
		public static List<String> takeElementScreenshot(List<WebElement> elements) {
			destFileList=new ArrayList<String>();
			for(WebElement list: elements){
				File srcFile = ((TakesScreenshot) list).getScreenshotAs(OutputType.FILE);
				String destFile=CaptureScreenShots.captureScreenShots(srcFile, SCREENSHOTS_FOLDER_PATH, "Agrilin");
				destFileList.add(destFile);	
			}
			log.info("Screenshot took in takeElementScreensho method and file path added to List...");
			return destFileList;
		}

	//Call removeDriver method and quit the driver and rmoves the thread.	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		CreateDriver.getInstance().removeDriver();
		log.info("Removed Driver instance in closeBrowser method..");
	}


}