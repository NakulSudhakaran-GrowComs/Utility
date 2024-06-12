package com.agrilin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agrilin.locators.OTPPageLocators;

public class EnterOTPPage {
	
	@FindBy(xpath = OTPPageLocators.OTP_TXT_FLD1_XPATH)
	private WebElement otpTxtFld1;

	@FindBy(xpath = OTPPageLocators.OTP_TXT_FLD2_XPATH)
	private WebElement otpTxtFld2;
	
	@FindBy(xpath = OTPPageLocators.OTP_TXT_FLD3_XPATH)
	private WebElement otpTxtFld3;
	
	@FindBy(xpath = OTPPageLocators.OTP_TXT_FLD4_XPATH)
	private WebElement otpTxtFld4;
	
	@FindBy(xpath = OTPPageLocators.CONFIRM_OTP_XPATH)
	private WebElement confirmOTPBTN;
	
	public EnterOTPPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterOTP() {
		otpTxtFld1.sendKeys("1");
		otpTxtFld2.sendKeys("2");
		otpTxtFld3.sendKeys("1");
		otpTxtFld4.sendKeys("2");
	}
	
	public void confirmOTP() {
		confirmOTPBTN.click();
	}
	
}
