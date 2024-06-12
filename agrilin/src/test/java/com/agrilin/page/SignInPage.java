package com.agrilin.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agrilin.locators.SignInPageLocators;

public class SignInPage {
	
	@FindBy(xpath = SignInPageLocators.ENTER_MOBILE_NUMBER_XPATH )
	private WebElement enterMobileNumberTXTFLD;
	
	@FindBy(xpath = SignInPageLocators.REQUEST_OTP_XPATH)
	private WebElement requestOTPBTN;
	
	@FindBy(xpath = SignInPageLocators.OTP_GENERATED_MESSAGE_XPATH)
	private WebElement otpGenerationMessage;
	
	@FindBy(xpath = SignInPageLocators.INVALID_MOBILE_NUMBER_ERROR_MESSAGE)
	private WebElement invalidMobileNumberErrorMessage;
	
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterMobileNumber(String number) {
		enterMobileNumberTXTFLD.clear();
		enterMobileNumberTXTFLD.sendKeys(number);
	}

	public void clickOnRequestOTPButton() {
		requestOTPBTN.click();
		
	}
	
	public String otpMessage() {
		return otpGenerationMessage.getText();
	}
	
	public void clearMobileNumber(String mobileNumber) {
		
		for(int i=1;i<=mobileNumber.length();i++) {
			enterMobileNumberTXTFLD.sendKeys(Keys.BACK_SPACE);
		}	
	}	
	public String invalidMobilenumberErrorMessage() {
		return invalidMobileNumberErrorMessage.getText();
	}
	
}
