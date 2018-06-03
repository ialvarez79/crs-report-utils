package com.tercevall.crsreport.util.convert;

import java.util.Calendar;

import org.apache.commons.lang3.time.FastDateFormat;

public class DateConverter {
	private static final FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd");
	
	public static String printDate(Calendar c) {
		return fdf.format(c);
	}
}
