package com.agrilin.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListners  implements ITestListener{

	public static ExtentReports extent=ExtentManager.createInstance();
	public static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	private static Logger log=LogManager.getLogger(TestListners.class);
	
	public String className;
	public String methodName;
	
	public static String customerName;
	public static String customerType;
	
	public static LinkedHashMap<String, String> mapData;
	public static HashMap<String, List<String>> hashmap;
	
	public static  List<String> listValues;
	public static String stringValue;
	public static int intValue;
	
	@Override
	public void onTestStart(ITestResult result) {

	}
//   ------------------ON SUCCESS-------------------------------------- 
	@Override
	public void onTestSuccess(ITestResult result) {
		methodName=result.getMethod().getMethodName();
		String testName=ExtentManager.getTestName();
		String testDescription=ExtentManager.getTestDescription();
		ExtentTest test=extent.createTest(methodName+" :: "+testName,testDescription);
		extentTest.set(test);
		getData(methodName);
		log.info("On Success method called in TestListeners class..");

		//extentTest.get().log(Status.INFO,( getName()+'\n'+getType()));
		//extentTest.get().log(Status.INFO,MarkupHelper.createUnorderedList(getData(methodName).forEach(
	      //      input ->(input.getKey() + " : " + input.getValue()))));
		//extentTest.get().log(Status.INFO, "Customer Tpye: "+getType());
//		extentTest.get().log(Status.INFO, MarkupHelper.createUnorderedList(getList()));
//		getData(methodName).forEach((k,v)->extentTest.get().log(Status.INFO, k+":"+v));
	//	extentTest.get().log(Status.INFO,MarkupHelper.createUnorderedList(getList()));
		
		String filePath="";
		try {
			WebDriver driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			filePath = BaseTest.takePageScreenshot(driver);
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		try {
			extentTest.get().pass("<b><font>"+"Screenshot of the page"+"</font></b>",
							MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
		} catch (Exception e) {
		extentTest.get().pass("Test Success, But could not attach screenshot!");
		}
		
		String logText="<b>Test Method "+result.getMethod().getMethodName()+" Successful</b>";
		Markup markUp=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS,markUp);
	}

	//----------------ON FAILURE------------------------------
	@Override
	public void onTestFailure(ITestResult result) {
		log.info("On Failure method called in TestListeners class...");

		methodName=result.getMethod().getMethodName();
		String testName=ExtentManager.getTestName();
		String testDescription=ExtentManager.getTestDescription();
		ExtentTest test=extent.createTest(methodName+" :: "+testName,testDescription);
		extentTest.set(test);
		
		String methodName=result.getMethod().getMethodName();
		getData(methodName);
		String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details><summary><b><font color=red>"+
								"Eception Occured, Click to see details:"+"</font><b></summary>"+
								exceptionMessage.replaceAll(",", "<br>")+"</details>\n");		
		String path="";
		try {
			WebDriver driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			path = BaseTest.takePageScreenshot(driver);
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		try {
			
			extentTest.get().fail("<b><font color-red>"+"Screenshot of failure"+"</font></b>",
							MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (Exception e) {
		extentTest.get().fail("Test Failed, cannot attach screenshot");
		}
		
		String logText="<b>Test Method "+methodName+" Failed</b>";
		Markup markUp=MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL,markUp);
	}

//	-----------------------ON SKIPPED---------------------------------	
	@Override
	public void onTestSkipped(ITestResult result) {
		
		log.info("On Skipped method called in TestListeners class");

		methodName=result.getMethod().getMethodName();
		String testName=ExtentManager.getTestName();
		String testDescription=ExtentManager.getTestDescription();
		ExtentTest test=extent.createTest(methodName+" :: "+testName,testDescription);
		extentTest.set(test);

		String logText="<b>Test Method "+result.getMethod().getMethodName()+" Skipped</b>";
		Markup markUp=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP,markUp);
	}

	
	@Override
	public void onFinish(ITestContext context) {
		if(extent!=null) {
			extent.flush();
		}
	}
	
	public static void setMapData(Map<String, String> orderlist) {
		
		mapData=new LinkedHashMap<String, String>(orderlist);	
	}

	public static LinkedHashMap<String, String> getMapData() {
		return mapData;
	}
	
// -----------------REPORT GENERATION & ATTACHMENTS------------------------	
	
	public static void getData(String methodName) {
		
		log.info("Inside getData method of TestListeners class ");

	switch(methodName) {
		
	
		case "orderStatistics":
			for(int i=0;i<getList().size();) {
				extentTest.get().log(Status.INFO,MarkupHelper.createUnorderedList(getList().get(i)));

					for(int j=1;j<6;j++) {
					extentTest.get().log(Status.INFO,MarkupHelper.createUnorderedList(getList().get(i+j)));
					

				}
				i=i+6;
			}break;
					
					
		case "trendingProducts":
			extentTest.get().log(Status.INFO,"<b><font>"+"Total number of Trending products: "+"</font></b>"+getIntegerValue());
			for(int i=0;i<getIntegerValue();i++) {
				try {
					
					extentTest.get().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(getList().get(i)).build());
				} catch (Exception e) {
				extentTest.get().fail("Test Failed, cannot attach screenshot");
				}
			}
			break;
			
			
		case "inValidLoginScenaio_1":
			extentTest.get().log(Status.INFO,"<b><font>"+"Error Message: "+"</font></b>"+getStringValue());
			break;
			
			
		case "inValidLoginScenaio_2":	
			extentTest.get().log(Status.INFO,"<b><font>"+"Error Message: "+"</font></b>"+getStringValue());
			break;
			
		default :
			break;
		}
		
	}
	
	public static void setValues(String custName,String custType) {
	
		customerName=custName;
		customerType=custType;
	}
	
	public String getName() {
		return customerName;
	}
	
	public String getType() {
		return customerType;
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	public static void setMapData(HashMap<String, List<String>> hashmapData) {
		hashmap=new HashMap<String, List<String>>(hashmapData);
		
	}

	public static  void setList(List<String> list) {
		listValues=new ArrayList<String>();
		listValues.addAll(list);
		
	}

	public static List<String> getList() {
		return listValues;
	}
	
	public static void setIntegerValue(int value) {
		intValue=value;
	}

	public static int getIntegerValue() {
		return intValue;
	}
	
	public static void setStringValue(String value) {
		stringValue=value;
	}
	
	public static String getStringValue() {
		return stringValue;
		
	}
}
