package com.palazzisoft.ligabalonpie.converters;

import java.text.SimpleDateFormat;
/**
 * 
 * @author pablo
 *
 */
public class ConverterUtil {

	public static SimpleDateFormat getFormat() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format;
	}
}
