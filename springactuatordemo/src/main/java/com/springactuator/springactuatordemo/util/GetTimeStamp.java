package com.springactuator.springactuatordemo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTimeStamp {
	public static String timeStamp(){
		Date d = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
		return sd.format(d);
	}
}
