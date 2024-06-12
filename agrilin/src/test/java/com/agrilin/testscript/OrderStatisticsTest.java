package com.agrilin.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.agrilin.generic.BaseTest;
import com.agrilin.generic.ExtentManager;
import com.agrilin.generic.LoginLogout;
import com.agrilin.generic.TestListners;
import com.agrilin.page.DashboardPage;
import com.agrilin.rough.Runnable;

import utilities.AutomationLibrary;

public class OrderStatisticsTest extends BaseTest {
	
	public List<String>list=new ArrayList<String>();
	
	@Test
	public void orderStatistics() {
		
		ExtentManager.setExtentReportLog("ORDER_STATISTICS_NAME", "ORDER_STATISTICS_DESCRIPTION", SETTINGS_PATH);
		
		int rowCount=AutomationLibrary.getRowCount(EXCEL_SHEET_PATH, "Login");
		
		for(int i=1;i<=rowCount;i++) {
			String mobileNumber=AutomationLibrary.getCellValue(EXCEL_SHEET_PATH, "Login", i, 0);
			Runnable.sleep(2000l);
			LoginLogout.signInButton(driver);
			Runnable.sleep(2000l);
			LoginLogout.signInPage(driver,mobileNumber);
			Runnable.sleep(2000l);

			LoginLogout.enterOtp(driver);
			Runnable.sleep(2000l);
			
			DashboardPage dashboard=new DashboardPage(driver);
			
			String userName=dashboard.userName();
			list.add("Customer Name: "+userName);
			list.add("PENDING: "+dashboard.pendingCount());
			list.add("OPEN: "+dashboard.openCount());
			list.add("CLOSED: "+dashboard.closedCount());
			list.add("CANCELLED: "+dashboard.cancelledCount());
			list.add("DISPUTE: "+dashboard.disputeCount());
		
			LoginLogout.logOut(driver);	
		}
		
			TestListners.setList(list);
	}

}
