package org.iot.itty.login.exception;

public class NotExistingToken extends RuntimeException {
	public NotExistingToken(String message) {
		super(message);
	}
}
