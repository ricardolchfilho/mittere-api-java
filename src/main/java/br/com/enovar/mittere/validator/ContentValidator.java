package br.com.enovar.mittere.validator;

public class ContentValidator {
	
	private final Integer MAX_CHARACTERS = 1024;

	public boolean validate(String content) {
		if (content == null || content.trim().isEmpty()) {
			return false;
		}
		
		return content.length() <= MAX_CHARACTERS;
	}

}
