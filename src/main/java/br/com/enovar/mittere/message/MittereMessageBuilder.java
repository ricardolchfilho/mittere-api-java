package br.com.enovar.mittere.message;

public interface MittereMessageBuilder {
	
	MittereMessageBuilder to(String... phones);
	
	MittereMessageBuilder withMessage(String message);
	
	void send();

}
