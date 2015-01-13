package com.palazzisoft.ligabalonpie.exception;
/**
 * 
 * @author ppalazzi
 *
 */
public class BalonpieException extends Exception {

	private static final long serialVersionUID = 1L;

	public BalonpieException(String message) {
		super(message);
	}
	
	public BalonpieException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
