package br.com.enovar.mittere.validator;

public final class MessageContentValidator {
	
	public boolean validate(String content) {
		if (content == null || content.trim().isEmpty()) {
			return false;
		}
		
		return true;
	}

}
