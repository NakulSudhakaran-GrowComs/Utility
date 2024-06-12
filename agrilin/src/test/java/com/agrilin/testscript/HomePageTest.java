package com.agrilin.testscript;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.agrilin.generic.BaseTest;
import com.agrilin.generic.ExtentManager;
import com.agrilin.generic.LoginLogout;
import com.agrilin.generic.TestListners;
import com.agrilin.page.TopBarPage;
import com.agrilin.rough.Runnable;

import utilities.AutomationLibrary;


public class HomePageTest extends BaseTest {

	//private Logger log=LogManager.getLogger(HomePageTest.class);
	
	@Test(groups = {"login"})
	public void logInTest() {
		// LinkedHashMap to store data
		LinkedHashMap<String, String> homePageData=new LinkedHashMap<String, String>();
		//Calls for to display Test Name and Test Description on the Etent Rport
		ExtentManager.setExtentReportLog("HOME_PAGE_TEST_NAME", "HOME_PAGE_TEST_DESCRIPTION", SETTINGS_PATH);
		//Click on Sign in button
		LoginLogout.signInButton(driver);
		
		implicitTimeOut(driver);
		//Enters valid mobile number
		LoginLogout.signInPage(driver, AutomationLibrary.getProperty(SETTINGS_PATH, "VALID_MOBILE_NUMBER_2"));
	
		homePageData.put("OTP Message ", LoginLogout.otpMessage(driver));
		
		LoginLogout.enterOtp(driver);
		
		Runnable.sleep(2000l);
		TopBarPage topbar=new TopBarPage(driver);
		
		homePageData.put("Customer Name ", topbar.userName());
		homePageData.put("Customer Type ", topbar.customerType());

		TestListners.setMapData(homePageData);
		LoginLogout.logOut(driver);
	}

	
}
