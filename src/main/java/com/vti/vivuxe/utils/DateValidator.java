package com.vti.vivuxe.utils;

import java.text.SimpleDateFormat;

public class DateValidator {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	//	Check date Format
	public static Boolean valDate(String dateStr) {
		try {
			sdf.parse(dateStr);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

}
