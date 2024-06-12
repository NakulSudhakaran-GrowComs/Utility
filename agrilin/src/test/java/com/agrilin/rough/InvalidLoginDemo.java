package com.agrilin.rough;

import org.testng.annotations.Test;

import com.agrilin.generic.BaseTest;
import com.agrilin.generic.LoginLogout;
import com.agrilin.page.SignInPage;

public class InvalidLoginDemo extends BaseTest{

	@Test
	public void invalidLogin() {
		
		LoginLogout.signInButton(driver);
		Runnable.sleep(2000l);
		LoginLogout.signInPage(driver, "8888899993");
		SignInPage sp=new SignInPage(driver);
		Runnable.sleep(2000l);
		sp.clearMobileNumber("8888899993");
		System.out.println("First Mob No:.......... "+sp.invalidMobilenumberErrorMessage());
		takePageScreenshot(driver);
		Runnable.sleep(2000l);
		LoginLogout.signInPage(driver, "000000001");
		System.out.println("Second Mob No:............ "+sp.invalidMobilenumberErrorMessage());
		takePageScreenshot(driver);
		Runnable.sleep(2000l);
	}

}
