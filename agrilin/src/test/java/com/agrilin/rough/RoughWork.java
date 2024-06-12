package com.agrilin.rough;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RoughWork {

	public static void main(String[] args) {

		Date date=new Date();
		System.out.println(date);
		System.out.println(date);
		System.out.println(getCurrentTimeStamp());
	}

	public static String getCurrentTimeStamp() {
	    return new SimpleDateFormat("EEE MMM dd HH:mm:ss.SSS zzz yyyy").format(new Date());
	}
}
