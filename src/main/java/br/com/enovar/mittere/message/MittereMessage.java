package br.com.enovar.mittere.message;

public interface MittereMessage {
	
	MittereMessage to(String... phones);
	
	MittereMessage withMessage(String messa);
	
	void send();

}
