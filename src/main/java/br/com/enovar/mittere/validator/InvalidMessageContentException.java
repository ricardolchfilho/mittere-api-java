package br.com.enovar.mittere.validator;

public class InvalidMessageContentException extends RuntimeException {
	
	public InvalidMessageContentException() {
		super("Message is invalid!");
	}
	
	public InvalidMessageContentException(String message) {
		super(message + "Message is invalid!");
	}

}
