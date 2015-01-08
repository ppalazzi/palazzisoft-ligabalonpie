package com.palazzisoft.ligabalonpie.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author ppalazzi
 *
 */
public class FechaMascara {

	private final static String DATE_PATTERN = "MM/dd/yyyy";
	
	public static String dateAFechaMesAno(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);		
		return format.format(date);
	}
	
	public static Date stringToDateFormat(String stringDate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);		
		return format.parse(stringDate);
	}
}
