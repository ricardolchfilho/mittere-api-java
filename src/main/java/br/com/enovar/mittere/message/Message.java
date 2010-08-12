package br.com.enovar.mittere.message;

import java.util.Set;

public interface Message {
	
	String getContent();
	
	Set<String> getPhones();

}
