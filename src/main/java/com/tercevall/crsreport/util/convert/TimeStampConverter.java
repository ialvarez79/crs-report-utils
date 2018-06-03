package com.tercevall.crsreport.util.convert;

import java.util.Calendar;

import org.apache.commons.lang3.time.FastDateFormat;

public class TimeStampConverter {
	private static final FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss");
	
	public static String printDateTime(Calendar c) {
		return fdf.format(c);
	}
}
