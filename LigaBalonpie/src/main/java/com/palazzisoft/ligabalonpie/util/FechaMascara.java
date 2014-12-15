package com.palazzisoft.ligabalonpie.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaMascara {

	public static String dateAFechaMesAno(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		
		return format.format(date);
	}
	
	public static Date stringToDateFormat(String stringDate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		
		return format.parse(stringDate);
	}
}
