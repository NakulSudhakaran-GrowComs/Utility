package com.agrilin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agrilin.locators.TopBarLocators;

public class TopBarPage {

	@FindBy(xpath=TopBarLocators.USER_NAME_XPATH)
	private WebElement userName;
	
	@FindBy(xpath=TopBarLocators.CUSTOMER_TYPE_XPATH)
	private WebElement customerType;
	
	@FindBy(xpath=TopBarLocators.DROPDOWN_XPATH)
	private WebElement dropDown;
	
	@FindBy(xpath= TopBarLocators.LOG_OUT_XPATH)
	private WebElement logOutBTN;
	
	public TopBarPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String userName() {
		return userName.getText();	
	}
	
	public String customerType() {
		return customerType.getText();
	}
	
	public void dropDown() {
		dropDown.click();
	}
	
	public void logOut() {
		logOutBTN.click();
	}
}
