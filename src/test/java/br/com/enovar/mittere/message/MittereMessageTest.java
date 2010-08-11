package br.com.enovar.mittere.message;

import org.junit.Before;
import org.junit.Test;

import br.com.enovar.mittere.validator.PhoneNumberValidator;

public class MittereMessageTest {
	
	MittereMessage mittereMessage;
	
	@Before
	public void setUp() throws Exception {
		mittereMessage = new MittereMessage();
		MittereMessage.setPhoneValidator(new PhoneNumberValidator());
	}
	
	@Test(expected = InvalidPhoneNumberException.class)
	public void shouldNotSendMittereMessageWhenHasAnInvalidPhoneNumber() {
		mittereMessage
			.to("8588311227", "823212x32")
			.withMessage("Benevas!!!")
			.send();
	}
	
	@Test(expected = InvalidMessageContentException.class)
	public void shouldNotSendMittereMessageWhenHasANullContent() {
		mittereMessage
		.to("8588311227", "8532723429")
		.withMessage(null)
		.send();
	}
	
	@Test(expected = InvalidMessageContentException.class)
	public void shouldNotSendMittereMessageWhenHasAnEmptyContent() {
		mittereMessage
		.to("8588311227", "8532723429")
		.withMessage("   ")
		.send();
	}

}
