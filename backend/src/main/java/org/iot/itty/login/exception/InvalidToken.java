package org.iot.itty.login.exception;

public class InvalidToken extends RuntimeException{
	public InvalidToken(String message){
		super(message);
	}
}
