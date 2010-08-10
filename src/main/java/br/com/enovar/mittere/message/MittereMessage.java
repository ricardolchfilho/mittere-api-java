package br.com.enovar.mittere.message;

import java.util.HashSet;
import java.util.Set;

import br.com.enovar.mittere.validator.MessageContentValidator;
import br.com.enovar.mittere.validator.PhoneNumberValidator;

public class MittereMessage implements MittereMessageBuilder, Message {

	private Set<String> phones = new HashSet<String>();

	private String content;
	
	private final PhoneNumberValidator phoneNumberValidator;
	
	private final MessageContentValidator messageContentValidator;
	
	public MittereMessage(PhoneNumberValidator phoneNumberValidator, MessageContentValidator messageContentValidator) {
		this.phoneNumberValidator = phoneNumberValidator;
		this.messageContentValidator = messageContentValidator;
	}

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
		for (String phoneNumber : phones) {
			phoneNumberValidator.validate(phoneNumber);
		}
	}
	
	private void validateContent() {
		messageContentValidator.validate(this.content);
	}

}
