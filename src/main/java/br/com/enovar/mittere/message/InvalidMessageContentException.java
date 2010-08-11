package br.com.enovar.mittere.message;

public class InvalidMessageContentException extends RuntimeException {

	private static final long serialVersionUID = -1006556417029827496L;

	public InvalidMessageContentException(String message) {
		super(message);
	}
	
}
