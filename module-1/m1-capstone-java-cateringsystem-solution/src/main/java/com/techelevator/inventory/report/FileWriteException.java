package com.techelevator.inventory.report;

public class FileWriteException extends RuntimeException {

	private static final long serialVersionUID = 4727517351235598998L;

	public FileWriteException(String message, Throwable originalError) {
		super(message, originalError);
	}
}
