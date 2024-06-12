package com.agrilin.testscript;

import org.testng.annotations.Test;

import com.agrilin.generic.BaseTest;
import com.agrilin.generic.ExtentManager;
import com.agrilin.generic.LoginLogout;
import com.agrilin.generic.TestListners;
import com.agrilin.page.DashboardPage;
import com.agrilin.rough.Runnable;

public class TrendingProductsTest extends BaseTest {

	
	@Test(groups = {"trending"})
	public void trendingProducts() {
		
		ExtentManager.setExtentReportLog("TRENDING_PRODUCTS_NAME", "TRENDING_PRODUCTS_DESCRIPTION", SETTINGS_PATH);
	
		LoginLogout.signInButton(driver);
		LoginLogout.signInPage(driver, "9996667770");
		LoginLogout.enterOtp(driver);
		Runnable.sleep(1000l);
		driver.navigate().refresh();
		Runnable.sleep(3000l);
		DashboardPage dashboardpage=new DashboardPage(driver);
		int count=dashboardpage.trendingProductCount();
		TestListners.setIntegerValue(count);
		TestListners.setList(takeElementScreenshot(dashboardpage.getTrendingProductsElement()));
		
		LoginLogout.logOut(driver);	
		
	}
	
}
