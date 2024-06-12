package com.agrilin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.agrilin.locators.HomePageLocators;


public class HomePage  {
	
	@FindBy(xpath = HomePageLocators.SEND_REQUEST_DEMO_XPATH)
	private WebElement sendDemoRequestCloseBTN;
	
	@FindBy(id =HomePageLocators.IFRAME_ID )
	private WebElement iFrameId;
	
	@FindBy(xpath = HomePageLocators.CHAT_WITH_US_MINIMIZE_XPATH)
	private WebElement chatWithUsMinimizeBTN;
	
	@FindBy(xpath=HomePageLocators.SINGN_IN_XPATH)
	private WebElement signInBTN;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void closeSendDemoRequest() {
		sendDemoRequestCloseBTN.click();
	}

	public void minimizeChatWithUs() {
		chatWithUsMinimizeBTN.click();
	}
	
	public void signIn() {
		signInBTN.click();
	}
	
	public void getInsideFrame(WebDriver driver) {
		driver.switchTo().frame(iFrameId);
	}
	
	public void getOutFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
}
