package br.com.enovar.mittere.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PhoneNumberValidationTest {
	
	PhoneNumberValidator validator;
	
	@Before
	public void setUp() throws Exception {
		this.validator = new PhoneNumberValidator();
	}
	
	@Test
	public void shouldValidateBrazilianPhoneNumbers() {
		assertTrue(validator.validate("8588311227"));
	}
	
	@Test
	public void shouldNotValidatePhoneNumbersWithExcessiveNumbers() {
		assertFalse(validator.validate("85823831122723243"));
	}
	
	@Test
	public void shouldNotValidateShortPhoneNumbers() {
		assertFalse(validator.validate("8532212"));
	}
	
	@Test
	public void shouldNotValidateEmptyPhoneNumber() {
		assertFalse(validator.validate(""));
	}
	
	@Test
	public void shouldNotValidateNullPhoneNumbers() {
		assertFalse(validator.validate(null));
	}
	
	@Test
	public void shouldNotValidateInvalidPhoneNumbers() {
		assertFalse(validator.validate("sd3434xsdd"));
	}

}
