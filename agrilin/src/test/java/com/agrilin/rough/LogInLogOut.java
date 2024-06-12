package com.agrilin.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.agrilin.generic.LoginLogout;

public class LogInLogOut {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://web.staging.agrilin.com");
		driver.manage().window().maximize();
		Runnable.sleep(2000l);
		LoginLogout.closePopUps(driver);
		Runnable.sleep(2000l);
		LoginLogout.signInButton(driver);
		System.out.println(driver.getCurrentUrl());
		Runnable.sleep(2000l);
		LoginLogout.signInPage(driver, "9996667770");
		System.out.println(driver.getCurrentUrl());
		Runnable.sleep(2000l);
		LoginLogout.enterOtp(driver);
		System.out.println(driver.getCurrentUrl());
		Runnable.sleep(2000l);
		driver.findElement(By.xpath("//h4[text()='Profile']")).click();
		Runnable.sleep(2000l);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		LoginLogout.logOut(driver);
		driver.quit();

	}

}
