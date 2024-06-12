
	package com.agrilin.rough;

	import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

import com.agrilin.locators.DashboardLocators;
	
	public class Runnable {

		
		public static void main(String[] args) throws InterruptedException {
			
			
			WebDriver driver;
			
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		
			driver.get("https://web.staging.agrilin.com");
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));	
			sleep(5000l);
			
			closePopUps(driver);
			String otpMessage=signIn(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));			//sleep(3000l);
			otpInput(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));	
			//sleep(3000l);
			String userName=welcomePage(driver);
			
			System.out.println(driver.getTitle());
			//System.out.println(otpMessage);
			System.out.println(userName);
			List <String> values=orderStatics(driver);
			for(int i=0;i<values.size();i++) {
				System.out.println(values.get(i));
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));	
			//sleep(3000l);
			List<WebElement> productMoreDetailsLists=driver.findElements(By.xpath("//div[@class='w-full']/div/div/div[1]/div[1]/div[1]/button[1]"));
			for(WebElement pl:productMoreDetailsLists) {
				pl.click();
				sleep(2000l);
				System.out.println(driver.findElement(By.xpath("//main/div/div[2]/div[2]/div/h2")).getText());
				System.out.println("Catogery :"+driver.findElement(By.xpath("//main/div/div[2]/div[2]/div/p/span[2]")).getText());
				driver.findElement(By.xpath("//main[@class='min-h-[90vh]']/button/p")).click();
				sleep(2000l);
			}
			
			//WebElement products=driver.findElement(By.xpath("//div[@class='w-full']/div/div[1]/div[1]/div[1]/div[1]/button[1]"));
		//	System.out.println(product.getText());
			//product.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));	
			//sleep(3000l);
//			WebElement productName=driver.findElement(By.xpath("//main/div/div[2]/div[2]/div/h2"));
//			System.out.println(productName.getText());
//			System.out.println("Catogery :"+driver.findElement(By.xpath("//main/div/div[2]/div[2]/div/p/span[2]")).getText());
			logOut(driver);
			
			driver.close();	
			
		}
		
		public static void closePopUps(WebDriver driver) {
			driver.findElement(By.xpath("//div//img[@class='block w-full']")).click();
			driver.switchTo().frame("siqiframe");
			driver.findElement(By.xpath("//div[@id='min_window']")).click();
			driver.switchTo().defaultContent();
		}
		
		public static String signIn(WebDriver driver) throws InterruptedException {
			driver.findElement(By.xpath("//div/button[text()='SIGN IN']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div/input[@class='form-control ']")).sendKeys("9996667770");
			driver.findElement(By.xpath("//span[contains(text(),'Request OTP')]")).click();
			Thread.sleep(3000);
			return driver.findElement(By.xpath("//div[@class='go3958317564']")).getText();	
		}
		
		public static void otpInput(WebDriver driver) {
			driver.findElement(By.xpath("//input[@aria-label='Please enter verification code. Digit 1']")).sendKeys("1");
			driver.findElement(By.xpath("//input[@aria-label='Digit 2']")).sendKeys("2");
			driver.findElement(By.xpath("//input[@aria-label='Digit 3']")).sendKeys("1");
			driver.findElement(By.xpath("//input[@aria-label='Digit 4']")).sendKeys("2");
			driver.findElement(By.xpath("//span[contains(text(),'Confirm OTP')]")).click();		
		}
		
		public static String welcomePage(WebDriver driver) {
			String userName=driver.findElement(By.xpath("//div[@class='flex justify-between']/div/div[1]")).getText();
			return userName;
		}
		
		
		public static List orderStatics(WebDriver driver) {
			
			List<String> orderstatics=new ArrayList();
			orderstatics.add(driver.findElement(By.xpath(DashboardLocators.PENDING_XPATH)).getText());
			orderstatics.add(driver.findElement(By.xpath(DashboardLocators.OPEN_XPATH)).getText());
			orderstatics.add(driver.findElement(By.xpath(DashboardLocators.CLOSED_XPATH)).getText());
			orderstatics.add(driver.findElement(By.xpath(DashboardLocators.CANCELLED_XPATH)).getText());
			orderstatics.add(driver.findElement(By.xpath(DashboardLocators.DISPUTE_XPATH)).getText());
			 return orderstatics;
		}
		
		public static void logOut(WebDriver driver) {
			driver.findElement(By.xpath("//img[@alt='avatar image']")).click();
			driver.findElement(By.xpath("//div[@class='relative']//div/button[3]//span[2] ")).click();
		}
		
		public static void sleep(Long sleepTime)  {
			try {
			Thread.sleep(sleepTime);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}

	}



