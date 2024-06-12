package com.agrilin.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agrilin.locators.DashboardLocators;

public class DashboardPage {
	
	@FindBy(xpath = DashboardLocators.TRENDING_PRODUCTS_XPATH)
	private List<WebElement> treandingProducts;
	
	@FindBy(xpath = DashboardLocators.USER_NAME_XPATH)
	private WebElement userName;
	
	@FindBy(xpath = DashboardLocators.PENDING_XPATH)
	private WebElement pending;
	
	@FindBy(xpath = DashboardLocators.PENDING_COUNT_XPATH)
	private WebElement pendingCount;
	
	@FindBy(xpath = DashboardLocators.OPEN_XPATH)
	private WebElement open;
	
	@FindBy(xpath = DashboardLocators.OPEN_COUNT_XPATH)
	private WebElement openCount;
	
	@FindBy(xpath = DashboardLocators.CLOSED_XPATH)
	private WebElement closed;
	
	@FindBy(xpath = DashboardLocators.CLOSED_COUNT_XPATH)
	private WebElement closedCount;
	
	@FindBy(xpath = DashboardLocators.CANCELLED_XPATH)
	private WebElement cancelled;
	
	@FindBy(xpath = DashboardLocators.CANCELLED_COUNT_XPATH)
	private WebElement cancelledCount;
	
	@FindBy(xpath = DashboardLocators.DISPUTE_XPATH)
	private WebElement dispute;
	
	@FindBy(xpath = DashboardLocators.DISPUTE_COUNT_XPATH)
	private WebElement disputeCount;
	
	public DashboardPage(WebDriver webDriver) {
		
		PageFactory.initElements(webDriver, this);
	}
	
	public int trendingProductCount() {
		int productCount= treandingProducts.size();
		return productCount;
	}
	
	public String pending() {
		String pendingText=pending.getText();
		return pendingText;
	}
	
	public String pendingCount() {
		String pending=pendingCount.getText();
		return pending;
	}

	public String open() {
		String openText=open.getText();
		return openText;
	}
	
	public String openCount() {
		String open=openCount.getText();
		return open;
	}
	
	public String closed() {
		String closedText=closed.getText();
		return closedText;
	}
	public String closedCount() {
		String closed=closedCount.getText();
		return closed;
	}
	
	public String cancelled() {
		String cancelledText=cancelled.getText();
		return cancelledText;
	}
	
	public String cancelledCount() {
		String cancelled=cancelledCount.getText();
		return cancelled;
	}
	
	public String dispute() {
		String disputeText=dispute.getText();
		return disputeText;
	}
	
	public String disputeCount() {
		String dispute=disputeCount.getText();
		return dispute;
	}
	
	public String userName() {
		String name=userName.getText();
		return name;
	}
	
	public List<WebElement> orderStaticsWebelements(){
		List<WebElement> list=new ArrayList<WebElement>();
		list.addAll(Arrays.asList(userName,pending,pendingCount,open,openCount,closed,closedCount,cancelled,cancelledCount,dispute,disputeCount));
		return list;
	}
	
	public List<WebElement> getTrendingProductsElement() {
		return treandingProducts;
	}
}
