package br.com.enovar.mittere.service;

public class PropertiesFileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 9208530509635257093L;

	public PropertiesFileNotFoundException(String message, Exception cause) {
		super(message, cause);
	}

}
