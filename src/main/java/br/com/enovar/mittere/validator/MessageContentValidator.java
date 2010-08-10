package br.com.enovar.mittere.validator;

public final class MessageContentValidator {
	
	public void validate(String content) throws InvalidMessageContentException {
		if (content == null || content.trim().isEmpty()) {
			throw new InvalidMessageContentException();
		}
	}

}
