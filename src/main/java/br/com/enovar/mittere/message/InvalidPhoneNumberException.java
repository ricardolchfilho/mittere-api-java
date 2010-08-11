package br.com.enovar.mittere.message;

public class InvalidPhoneNumberException extends RuntimeException {

	private static final long serialVersionUID = 5390264681488906244L;
	
	public InvalidPhoneNumberException(String message) {
		super(message);
	}

}
