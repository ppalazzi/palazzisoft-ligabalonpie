package com.palazzisoft.ligabalonpie.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaMascara {

	public static String dateAFechaMesAno(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		return format.format(date);
	}
	
}
