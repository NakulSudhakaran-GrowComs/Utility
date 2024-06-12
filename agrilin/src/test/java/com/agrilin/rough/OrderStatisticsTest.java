package com.agrilin.rough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.agrilin.generic.BaseTest;
import com.agrilin.generic.ExtentManager;
import com.agrilin.generic.LoginLogout;
import com.agrilin.page.DashboardPage;
import com.agrilin.rough.Runnable;

import utilities.AutomationLibrary;

public class OrderStatisticsTest extends BaseTest {
	
	public static ArrayList<HashMap<String, String>> arrayListRowsFirst = new ArrayList<HashMap<String, String>>();
	
	public static LinkedHashMap<String, String> orderStatisticsData=new LinkedHashMap<String, String>();

	public static Map<String, String> orderlist= new HashMap<>();
	
	public static HashMap<String, List<String>> hashmap=new HashMap<String, List<String>>();
	
	
	public void orderStatistics() {
		
		ExtentManager.setExtentReportLog("ORDER_STATISTICS_NAME", "ORDER_STATISTICS_DESCRIPTION", SETTINGS_PATH);
		
		//Mobile Number count in Excel Sheet 
		int rowCount=AutomationLibrary.getRowCount(EXCEL_SHEET_PATH, "Login");
		orderStatisticsData.put("Total Number of Customers from Excel Sheet", Integer.toString(rowCount));
		System.out.println("Row COunt :"+rowCount);
		for(int i=1;i<=rowCount;i++) {
			String mobileNumber=AutomationLibrary.getCellValue(EXCEL_SHEET_PATH, "Login", i, 0);
			System.out.println(mobileNumber);
			Runnable.sleep(2000l);
			LoginLogout.signInButton(driver);
			Runnable.sleep(2000l);
			LoginLogout.signInPage(driver,mobileNumber);
			Runnable.sleep(2000l);

			LoginLogout.enterOtp(driver);
			Runnable.sleep(2000l);

			DashboardPage dashboard=new DashboardPage(driver);
			
			
			List<String> list=new ArrayList<String>();
			list.add(dashboard.userName());
//			list.add("PENDING: "+dashboard.pendingCount());
//			list.add("OPEN: "+dashboard.openCount());
//			list.add("CLOSED: "+dashboard.closedCount());
//			list.add("CANCELLED: "+dashboard.cancelledCount());
//			list.add("DISPUTE: "+dashboard.disputeCount());
//			
//			orderlist.put("Customer Name ", dashboard.userName());
//			TestListners.extentTest.get().log(Status.INFO, "Customer Name: "+userName);
			orderlist.put(dashboard.pending(),dashboard.pendingCount());
			orderlist.put(dashboard.open(),dashboard.openCount());
			orderlist.put(dashboard.closed(),dashboard.closedCount());
			orderlist.put(dashboard.cancelled(),dashboard.cancelledCount());
			orderlist.put(dashboard.dispute(),dashboard.disputeCount());
//			orderlist.forEach((k,v)->TestListners.extentTest.get().log(Status.INFO, k+":"+v));
			//hashmap.put(dashboard.userName(),list);
			
			//TestListners.setData(userName,list);
			//TestListners.setMapData(orderlist);
			//TestListners.setList(list);
			LoginLogout.logOut(driver);	
			
		}
	
		
	}
}
