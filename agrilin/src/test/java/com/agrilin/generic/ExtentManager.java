package com.agrilin.generic;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.AutomationLibrary;

public class ExtentManager {

	private static ExtentReports extentReport;
	public static String value1 = "";
	public static String value2 = "";

	public static String testName;
	public static String testDescription;

	public static ExtentReports createInstance() {
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/reports/";
		new File(directory).mkdirs();
		String path = directory + fileName;

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Test Execution Report in  browser");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy hh:mm a '('zzz')'");

		extentReport = new ExtentReports();
		extentReport.setSystemInfo("Organiation", "Growcoms");
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Browser", "Chrome");

		return extentReport;
	}

	public static void setExtentReportLog(String testName, String testDescription, String path) {
		String extentReportsCredentialSettingsPath = AutomationLibrary.getProperty(path,"EXTENT_REPORT_CREDENTIALS_SETTINGS_PATH");
		ExtentManager.testName = AutomationLibrary.getProperty(extentReportsCredentialSettingsPath, testName);
		ExtentManager.testDescription = AutomationLibrary.getProperty(extentReportsCredentialSettingsPath,testDescription);
	}

	public static String getTestName() {
		return testName;
	}

	public static String getTestDescription() {
		return testDescription;
	}
	

	public static String getReportName() {
		Date date = new Date();
		String fileName = "Automation Report" + date.toString().replace(":", "-").replace(" ", "-") + ".html";
		return fileName;
	}
}
