package com.alphaware.exceptions;

public class RecordAlreadyExistException extends Exception {

	public RecordAlreadyExistException() {
	};

	public RecordAlreadyExistException(String message) {
		super(message);
	}
}
