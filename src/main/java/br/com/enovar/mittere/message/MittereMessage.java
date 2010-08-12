package br.com.enovar.mittere.message;

import java.util.HashSet;
import java.util.Set;

import br.com.enovar.mittere.validator.ContentValidator;
import br.com.enovar.mittere.validator.PhoneNumberValidator;

public class MittereMessage implements MittereMessageBuilder, Message {

	private Set<String> phones = new HashSet<String>();

	private String content;
	
	private static PhoneNumberValidator phoneValidator = new PhoneNumberValidator();
	
	private static ContentValidator contentValidator = new ContentValidator();
	
	@Override
	public MittereMessageBuilder to(String... phones) {
		for (int i = 0; i < phones.length; i++) {
			this.phones.add(phones[i]);
		}

		return this;
	}

	@Override
	public MittereMessageBuilder withMessage(String content) {
		this.content = content;
		return this;
	}

	@Override
	public void send() {
		validatePhoneNumbers();
		validateContent();
	}
	
	@Override
	public Set<String> getPhones() {
		return this.phones;
	}
	
	private void validatePhoneNumbers() {
		for (String phone : phones) {
			if (!phoneValidator.validate(phone)) {
				throw new InvalidPhoneNumberException(phone + " is invalid!");
			}
		}
	}
	
	private void validateContent() {
		if (!contentValidator.validate(this.content)) {
			throw new InvalidMessageContentException("'" + this.content + "' cannot be sent!");
		}
	}

	public static void setPhoneValidator(PhoneNumberValidator phoneValidator) {
		MittereMessage.phoneValidator = phoneValidator;
	}

	@Override
	public String getContent() {
		return this.content;
	}

	public static void setContentValidator(ContentValidator contentValidator) {
		MittereMessage.contentValidator = contentValidator;
	}

}
