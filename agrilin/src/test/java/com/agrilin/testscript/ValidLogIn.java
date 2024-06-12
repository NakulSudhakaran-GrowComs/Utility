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

/*
 * Enter Valid mobile Number and Enter valid OTP
 * Verify OTP Message,User Name,Customer Type,User Order Statistics and Trending orders On the dashboard.
 * 
 */

public class ValidLogIn extends BaseTest {
	
	@Test(groups = {"login"})
	public void validLogIn() {
		LinkedHashMap<String, String> validLoginPageData=new LinkedHashMap<String, String>();
		
		ExtentManager.setExtentReportLog("VALID_LOGIN_TEST_NAME", "VALID_LOGIN_TEST_DESCRIPTION", SETTINGS_PATH);
		
		LoginLogout.signInButton(driver);
		
		implicitTimeOut(driver);
		
		LoginLogout.signInPage(driver, AutomationLibrary.getProperty(SETTINGS_PATH, "VALID_MOBILE_NUMBER_1"));
		
		LoginLogout.enterOtp(driver);
		

		Runnable.sleep(2000l);
		TopBarPage topbar=new TopBarPage(driver);
		
		validLoginPageData.put("Customer Name ", topbar.userName());
		validLoginPageData.put("Customer Type : ", topbar.customerType());
		TestListners.setMapData(validLoginPageData);
		LoginLogout.logOut(driver);
		
	}
	
}
