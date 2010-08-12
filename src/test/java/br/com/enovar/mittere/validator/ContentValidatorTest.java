package br.com.enovar.mittere.validator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ContentValidatorTest {
	
	ContentValidator validator;
	
	@Before
	public void setUp() throws Exception {
		validator = new ContentValidator();
	}
	
	@Test
	public void shouldValidateNormalMessage() {
		assertTrue(validator.validate("Thanks for using Mittere API for Java"));
	}
	
	@Test
	public void shouldNotValidateLargeMessages() {
		String messageToValidate = "";
		
		for (int i = 0; i < 1024; i++) {
			messageToValidate += i;
		}
		
		assertFalse(validator.validate(messageToValidate));
	}
	
	@Test
	public void shouldNotValidateEmptyMessages() {
		assertFalse(validator.validate(""));
	}
	
	@Test
	public void shouldNotValidateNullMessages() {
		assertFalse(validator.validate(null));
	}
	
}
