package com.springboot.my.org.crudapi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtilities {
	public static String timeStamp(){
		Date d = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
		return sd.format(d);
	}
}
