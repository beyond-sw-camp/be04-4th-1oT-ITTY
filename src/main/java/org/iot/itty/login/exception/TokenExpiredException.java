package org.iot.itty.login.exception;

public class TokenExpiredException extends RuntimeException{
	public TokenExpiredException(String message){
		super(message);
	}
}
