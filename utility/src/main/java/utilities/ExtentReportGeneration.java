package utilities;

import java.util.Date;
import java.util.LinkedHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGeneration  {
	
	private static Logger log=LogManager.getLogger(ExtentReportGeneration.class);
	
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static String browserName;
	
	
	public static void initializeReport(String projectDirectory,String methodName ) {
		
		String date=new Date().toString().replaceAll(":", "-");
		sparkReporter= new ExtentSparkReporter(projectDirectory+"/reports/"+browserName+" "+methodName+" "+date+".html");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Test Execution Report in "+browserName+" browser");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy hh:mm a '('zzz')'");
		extentReport=new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		log.info("Extent Report initialised..");
	}
	
	public static String[] extentReportLog(String testName, String testDescription, String path) {
		String extentReportsCredentialSettingsPath=AutomationLibrary.getProperty(path, "EXTENT_REPORT_CREDENTIALS_SETTINGS_PATH");
		System.out.println(extentReportsCredentialSettingsPath);
		String methodNameInfo=AutomationLibrary.getProperty(extentReportsCredentialSettingsPath,testName);
		String classNameInfo=AutomationLibrary.getProperty(extentReportsCredentialSettingsPath,testDescription);
		String [] testDetails=new String[] {methodNameInfo,classNameInfo};
		return testDetails;
	}
	
	
//	public static void extentReportLog(String methodName, String className, String path) {
//		String extentReportsCredentialSettingsPath=AutomationLibrary.getProperty(path, "EXTENT_REPORT_CREDENTIALS_SETTINGS_PATH");
//		System.out.println(extentReportsCredentialSettingsPath);
//		String methodNameInfo=AutomationLibrary.getProperty(extentReportsCredentialSettingsPath,"VALID_LOGIN_METHOD_NAME_INFO");
//		String classNameInfo=AutomationLibrary.getProperty(extentReportsCredentialSettingsPath,"VALID_LOGIN_CLASS_NAME_INFO");
//		String typeOfTesting=AutomationLibrary.getProperty(extentReportsCredentialSettingsPath,"TYPE_OF_TESTING");
//		System.out.println(methodNameInfo+"------"+classNameInfo+"----"+typeOfTesting);
//		extentTest=extentReport.createTest(methodName,methodNameInfo);
//		extentTest=extentReport.createTest(className,classNameInfo).info(typeOfTesting).addScreenCaptureFromPath(typeOfTesting);
//		extentTest.assignCategory(typeOfTesting);
//	}
//	
	public static void extentReportLog(String methodName, String className, String methodNameInfo, String classNameInfo, String typeOfTesting) {
		
		//ExtentReportGeneration.extentTest=ExtentReportGeneration.extentReport.createTest(methodName,methodNameInfo);
		extentTest=extentReport.createTest(className,classNameInfo).info(typeOfTesting).addScreenCaptureFromPath(typeOfTesting);
		
		
		ExtentReportGeneration.extentTest.assignCategory(typeOfTesting);
	}
	
	public static void extentReportData(LinkedHashMap<String, String> orderStatistics) {
		
		ExtentReportGeneration.extentTest.log(Status.INFO,MarkupHelper.createUnorderedList(orderStatistics));
	}
	
	public static void endReport() {
		extentReport.flush();
	}

}
