package com.agrilin.generic;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.agrilin.page.EnterOTPPage;
import com.agrilin.page.HomePage;
import com.agrilin.page.SignInPage;
import com.agrilin.page.TopBarPage;
import com.agrilin.testscript.HomePageTest;

import utilities.AutomationLibrary;

public class LoginLogout implements IAutoConst {
	
		private static Logger log;
	
		// Closes 'Send Demo Request' pop up and minimizes 'Chat with us pop up'
		public static void closePopUps(WebDriver driver){
		log=LogManager.getLogger(HomePageTest.class);
		HomePage homePage=new HomePage(driver);
		log.info("Implicit timeout calling!!");
		implicitTimeOut(driver);
		log.info("Closing the Send Demo Request pop up!!");
		homePage.closeSendDemoRequest();
		homePage.getInsideFrame(driver);
		log.info("Minimizing Chat with us!!!");
		homePage.minimizeChatWithUs();
		homePage.getOutFrame(driver);
		log.info("Clicked on sign in button");
		}
	
	
		// Clicks on 'Sign In' from the home page
		public static void signInButton(WebDriver driver) {
			HomePage homePage=new HomePage(driver);
			homePage.signIn();
		}
	
		// In the 'Sign In' page and enters mobile number,clicks on 'Request' button and gets OTP message
		public static void signInPage(WebDriver driver,String mobileNumber) {
	
			SignInPage signinpage=new SignInPage(driver);
			signinpage.enterMobileNumber(mobileNumber);
			signinpage.clickOnRequestOTPButton();
			
		}
		
		public static String otpMessage(WebDriver driver) {
			SignInPage signinpage=new SignInPage(driver);
			String otpMessage=signinpage.otpMessage();
			return otpMessage;
		}
		
		// In the 'Enter OTP' page OTP enters and clicks on 'Confirm OTP' button
		public static void enterOtp(WebDriver driver) {
			EnterOTPPage enterotppage=new EnterOTPPage(driver);
			enterotppage.enterOTP();
			enterotppage.confirmOTP();
			implicitTimeOut(driver);
		}
		
		// Calls Implicitly Time Out
		public static void implicitTimeOut(WebDriver driver) {
		
			int ITO = AutomationLibrary.implicitTimeOut(SETTINGS_PATH, "IMPLICIT_TIMEOUT");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ITO));
		}
		
		// Calls Explicit Time Out
		public static void explicitWait(WebDriver driver,String xpath) {
			long s=Long.parseLong(AutomationLibrary.getProperty(SETTINGS_PATH, "EXPLICIT_WAIT"));
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(s));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		}

		// In Welcome page clicks on drop down and clicks on 'Log Out' button 
		public static void logOut(WebDriver driver) {
			TopBarPage topbar=new TopBarPage(driver);
			topbar.dropDown();
			topbar.logOut();
		}

		
		
	
}
