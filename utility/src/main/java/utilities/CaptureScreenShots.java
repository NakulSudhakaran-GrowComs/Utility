package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CaptureScreenShots {
	
	private static Logger log=LogManager.getLogger(CaptureScreenShots.class);

	public static String captureScreenShots(File srcFile ,String folder,String name) {
		
	
		String date= new SimpleDateFormat("EEE MMM dd HH:mm:ss.SSS zzz yyyy").format(new Date()).toString().replaceAll(":", "-");
		
		String path=folder+name+" "+date+".png";
	
		File destFile=new File(path);

		
		try {
			FileUtils.copyFile(srcFile,destFile);
			log.info("Screenshot copied to destFile...");
		}
		catch (Exception e) {
			log.info("Failed to copy Screenshot !!!...");
		}
		
		return destFile.getAbsolutePath();
	}
}
