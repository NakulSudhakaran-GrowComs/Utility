package utilities;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


public class AutomationLibrary {

    private static Logger log=LogManager.getLogger(AutomationLibrary.class);
	
    
	public static String getProperty(String path,String key) {
		
		String value="";
		
		try {
			Properties property=new Properties();
			property.load(new FileInputStream(path));
		
			value=property.getProperty(key);
			if(value!=null) {
				log.info("The value in "+key+" is: "+value);
				return value;
			}
			else {
				log.info("The value in "+key+" is: NULL");
				return " ";
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return"";
	}
	
	
	public static String getCellValue(String path,String sheet,int r,int c) {
		String value="";
		try {
			log.info("Inside the Excel file in Sheet :"+sheet);
			Workbook workbook=WorkbookFactory.create(new FileInputStream(path));
			value=workbook.getSheet(sheet).getRow(r).getCell(c).toString();
			log.info("Retrive the value :"+value);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return value;
	}
	
	public static int getRowCount(String path, String sheet) {
		int rowCount=0;
		try {
			log.info("Inside the Excel file in Sheet :"+sheet);
			Workbook workbook=WorkbookFactory.create(new FileInputStream(path));
			rowCount=workbook.getSheet(sheet).getLastRowNum();
			log.info("Retrive the row count :"+rowCount);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return rowCount;
	}
	
	public static ChromeOptions chromeBrowserPermissions() {
		
		HashMap<String, Integer> contentSettings=new HashMap<String, Integer>();
		HashMap<String, Object> profile=new HashMap<String, Object>();
		HashMap<String, Object> prefs=new HashMap<String, Object>();
		
		contentSettings.put("notifications", 2);
		contentSettings.put("geolocation", 2);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
	
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("disable-notifications");
		options.addArguments("diasable-geolocation");
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("disable-notifications");
		options.addArguments("diasable-geolocation");
		
		return options;
	}
	
	public static FirefoxOptions firefoxBrowserPermissions() {
		FirefoxOptions firefoxOptions=new FirefoxOptions();
		firefoxOptions.addPreference("browser.geolocation.warning.infoURL", false);
		
		return firefoxOptions;
	}
	
	
	public static int implicitTimeOut(String path,String key) {
		 int ito = Integer.parseInt(getProperty(path, key));
		log.info("calling implicitly time out of "+ito+"s");
		return ito;
	}
	 
	
}
