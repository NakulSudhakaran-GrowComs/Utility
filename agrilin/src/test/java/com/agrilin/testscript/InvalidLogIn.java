package com.agrilin.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.agrilin.generic.BaseTest;
import com.agrilin.generic.ExtentManager;
import com.agrilin.generic.LoginLogout;
import com.agrilin.generic.TestListners;
import com.agrilin.page.SignInPage;

import utilities.AutomationLibrary;

public class InvalidLogIn extends BaseTest{

	@Test(groups = {"login","invalid login"})
	public void inValidLoginScenaio_1() {

		ExtentManager.setExtentReportLog("INVALID_LOGIN_WITH_NOT_REGISTERED_MOBILENUMBER_NAME", "INVALID_LOGIN_WITH_NOT_REGISTERED_MOBILENUMBER_DESCRIPTION", SETTINGS_PATH);
		
		LoginLogout.signInButton(driver);
		SignInPage signinpage=new SignInPage(driver);
		
			String mobileNumber=AutomationLibrary.getCellValue(EXCEL_SHEET_PATH, "Invalid Login", 1, 0);
			System.out.println(mobileNumber);
			LoginLogout.signInPage(driver,mobileNumber);
			String actualMessage=signinpage.invalidMobilenumberErrorMessage();
			String expectedMessage="must be a valid phone number";
			TestListners.setStringValue(actualMessage);
			Assert.assertEquals(expectedMessage, actualMessage);
	
	}
	
	@Test(groups= {"login","invalid login"})
	public void inValidLoginScenaio_2() {
		

		ExtentManager.setExtentReportLog("INVALID_LOGIN_WITH_PARTIAL_MOBILENUMBER_NAME", "INVALID_LOGIN_WITH_PARTIAL_MOBILENUMBER_DESCRIPTION", SETTINGS_PATH);
		
		LoginLogout.signInButton(driver);
		SignInPage signinpage=new SignInPage(driver);
		String mobileNumber=AutomationLibrary.getCellValue(EXCEL_SHEET_PATH, "Invalid Login", 2, 0);
		LoginLogout.signInPage(driver,mobileNumber);
		String actualMessage=signinpage.invalidMobilenumberErrorMessage();
		String expectedMessage="user not found";
		TestListners.setStringValue(actualMessage);
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	
}
