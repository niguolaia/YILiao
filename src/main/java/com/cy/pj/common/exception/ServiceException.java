package com.cy.pj.common.exception;
/**
 * 自定义异常ServiceException
 * @author PHP
 *
 */
public class ServiceException extends RuntimeException{
	private static final long serialVersionUID = 5843835376260549700L;
	
	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	public ServiceException() {
		super();
	}
	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(Throwable cause) {
		super(cause);
	} 
}
