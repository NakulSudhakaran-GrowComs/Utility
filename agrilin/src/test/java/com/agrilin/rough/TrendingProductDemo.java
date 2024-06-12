package com.agrilin.rough;

import java.util.List;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.agrilin.generic.IAutoConst;
import com.aventstack.extentreports.Status;

import utilities.ExtentReportGeneration;

public class TrendingProductDemo implements IAutoConst{

	public static void main(String[] args) throws InterruptedException {
		
		
	
		WebDriver driver;
		
		String methodName= new Exception().getStackTrace()[0].getMethodName();
		String className= new Exception().getStackTrace()[0].getClassName();
		ExtentReportGeneration.initializeReport(PROJECT_DERECTORY,methodName);
		ExtentReportGeneration.extentTest=ExtentReportGeneration.extentReport.createTest(methodName, "Sign in and verify page title");
		ExtentReportGeneration.extentTest.log(Status.INFO, "Open login page and verify the title");
		ExtentReportGeneration.extentTest.assignCategory("Sanity Testing");
		
		
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://web.staging.agrilin.com");
		
		Runnable.sleep(5000l);
		
		Runnable.closePopUps(driver);
		
		String otpMessage=Runnable.signIn(driver);
		
		Runnable.sleep(2000l);
		System.out.println(driver.findElement(By.xpath("//div[@role='status']")).getText());
		
		Runnable.otpInput(driver);
		Runnable.sleep(3000l);
		String userName=Runnable.welcomePage(driver);
		
		System.out.println(driver.getTitle());
		
		List<WebElement> trendingProductsCount=driver.findElements(By.xpath("//div[4][@class='w-full']/div[2]/div"));
		System.out.println("There are "+trendingProductsCount.size()+" number of Trending products listed..");
		Runnable.sleep(2000l);
		ExtentReportGeneration.endReport();
		String s=driver.findElement(By.xpath("//div/button[5][@type='button']/div[2]")).getText();
		System.out.println("Order : "+s);
		driver.quit();
	}

}
