package com.agrilin.generic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.ExtentReportGeneration;

public class CreateDriver implements IAutoConst {

	private static CreateDriver instance;
	private static Logger log=LogManager.getLogger(CreateDriver.class);

	private ThreadLocal<WebDriver> webDriverThreadLocal=new ThreadLocal<WebDriver>();
	
	private CreateDriver() {
		
	}
	
	public static CreateDriver getInstance() {
		
		if(instance==null) {
			instance=new CreateDriver();
			log.info("CreateDriver instance created :"+instance);

			
		}
		return instance;
	}
	
	public void setDriver(String browserType) {
		
		ExtentReportGeneration.browserName=browserType;
		switch(browserType) {
		
		case "chrome":	
						//ChromeOptions options=AutomationLibrary.chromeBrowserPermissions();
						webDriverThreadLocal.set(new ChromeDriver());
						break;
		case "firefox":
						webDriverThreadLocal.set(new FirefoxDriver());
						break;
						
		case "edge":
						EdgeOptions options=new EdgeOptions();
						options.addArguments("--disable-notifications");
						options.addArguments("--disable-extentions");
						options.addArguments("--guest");
						webDriverThreadLocal.set(new EdgeDriver(options));
						break;				
		}	
	}
	
	
	public WebDriver getDriver() {
		return webDriverThreadLocal.get();
	}
	
	public void removeDriver() {
		webDriverThreadLocal.get().quit();
		webDriverThreadLocal.remove();	
		
		
	}
}

