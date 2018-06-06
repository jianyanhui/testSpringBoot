package com.example.demo.exception;

import java.util.Map;

public class BusinessException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    private IErrorCode iErrorCode;
    
    private String errorCode;
    private String errorMessage;
    private Map<String, Object> errorData;
        
        public BusinessException(IErrorCode iErrorCode) {
	        super();
	        this.iErrorCode = iErrorCode;
	        this.errorCode = iErrorCode.getErrorCode();
	        this.errorMessage = iErrorCode.getErrorMessage();
	    }
        
        public BusinessException(String code,String msg,Throwable cause) {
        	super(code+msg,cause);
        	this.errorCode=code;
        }
        
        public BusinessException(String code,String msg) {
        	super(code+msg);
        	this.errorCode=code;
        }
}