package br.com.enovar.mittere.validator;


public final class PhoneNumberValidator {
	
	public void validate(String phoneNumber) throws InvalidPhoneNumberException {
		if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
			throw new InvalidPhoneNumberException();
		}
		
		if (phoneNumber.length() != 10) {
			throw new InvalidPhoneNumberException(phoneNumber);
		}
	}
	
}
