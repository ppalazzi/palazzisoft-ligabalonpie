package com.palazzisoft.ligabalonpie.converters;

import java.text.SimpleDateFormat;
/**
 * 
 * @author ppalazzi
 *
 */
public class ConverterUtil {

	public static SimpleDateFormat getFormat() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format;
	}
}
