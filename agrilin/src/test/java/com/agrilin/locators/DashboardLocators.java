package com.agrilin.locators;

public class DashboardLocators {

	
	//Dashboard WebElements
	public static final String USER_NAME_XPATH="//div[@class='flex justify-between']/div/div[1]";
	
	//Order Statistics WebElements
	//PENDING
	public static final String PENDING_XPATH="//div/button[1][@type='button']/p";
	public static final String PENDING_COUNT_XPATH="//div/button[1][@type='button']/div[2]";
	//OPEN
	public static final String OPEN_XPATH="//div/button[2][@type='button']/p";
	public static final String OPEN_COUNT_XPATH="//div/button[2][@type='button']/div[2]";
	//CLOSED
	public static final String CLOSED_XPATH="//div/button[3][@type='button']/p";
	public static final String CLOSED_COUNT_XPATH="//div/button[3][@type='button']/div[2]";
	//CANCELLED
	public static final String CANCELLED_XPATH="//div/button[4][@type='button']/p";
	public static final String CANCELLED_COUNT_XPATH="//div/button[4][@type='button']/div[2]";
	//DISPUTE
	public static final String DISPUTE_XPATH="//div/button[5][@type='button']/p";
	public static final String DISPUTE_COUNT_XPATH="//div/button[5][@type='button']/div[2]";
	
	//Top Trending Product WebElements
	
	//.../div/div['n'] where value in 'n' brings each 'product' from all trending products 
	public static final String TRENDING_PRODUCTS_XPATH="//div[@class='w-full']/div/div"; //6 WebElements
	//.../div[2]/div['n']/div[1]/div[1]...where value in 'n' brings each 'more details' of the product in the product tile 
	public static final String TRENDING_PRODUCT_MORE_DETAILS_XPATH="//div[@class='w-full']/div[2]/div[n]/div[1]/div[1]/div[1]/button[1]";
	//.../div[2]/div['n']/div[1]/div[1]...where value in 'n' brings each 'name' of the product in the product tile 
	public static final String TRENDING_PRODUCT_NAME_XPATH="//div[@class='w-full']/div[2]/div[n]/div[1]/div[2]/span";
	//.../div/div['n']/div[1]...where value in 'n' brings each product category from all trending product
	public static final String TRENDING_PRODUCT_CATEGORY_XPATH="//div[@class='w-full']/div[2]/div[n]/div[1]/div[3]/div/h4";
	//.../div[2]/div['n']/div[1]..where value in 'n' brings each product price, if the product is not under 'price on request'.
	public static final String TRENDING_PRODUCT_PRICE_XPATH="//div[@class='w-full']/div[2]/div[n]/div[1]/div[3]/div[2]/div[2]/div/div[1]";
	//xpath for price on request in trending products, it gives webelements.
	public static final String TRENDING_PRODUCT_PRICE_ON_REQUEST_XPATH="//div/button/span/img[@alt='request']";
	
	//    //div[4][@class='w-full']/div[2]/div -- gives each trending products tile

	
	
}
