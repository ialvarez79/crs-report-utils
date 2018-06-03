package com.tercevall.crsreport.util.convert;

import java.math.BigDecimal;
import java.text.DecimalFormat;
public class BigDecimalConverter {
	private static final String FORMAT_PATTERN = "#0.00";

	public static String printTwoDigitDecimal(BigDecimal bd) {
		DecimalFormat df = new DecimalFormat(FORMAT_PATTERN);
		return df.format(bd);
	}
}
