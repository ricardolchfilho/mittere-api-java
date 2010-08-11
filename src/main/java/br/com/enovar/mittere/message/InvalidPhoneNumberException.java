package br.com.enovar.mittere.message;

public class InvalidPhoneNumberException extends RuntimeException {

	public InvalidPhoneNumberException() {
		super("This phone number is invalid");
	}
	
	public InvalidPhoneNumberException(String phoneNumber) {
		super(phoneNumber + " is invalid!");
	}
	
}
