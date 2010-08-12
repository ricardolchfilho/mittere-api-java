package br.com.enovar.mittere.validator;

public final class PhoneNumberValidator {

	private final static Integer MAX_NUMBERS = 10;

	public boolean validate(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
			return false;
		}

		try {
			Long.valueOf(phoneNumber);
		} catch (NumberFormatException exception) {
			return false;
		}

		return phoneNumber.length() == PhoneNumberValidator.MAX_NUMBERS;
	}

}
