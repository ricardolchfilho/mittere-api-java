package br.com.enovar.mittere.message;

import org.junit.Before;
import org.junit.Test;

import br.com.enovar.mittere.validator.InvalidMessageContentException;
import br.com.enovar.mittere.validator.InvalidPhoneNumberException;
import br.com.enovar.mittere.validator.MessageContentValidator;
import br.com.enovar.mittere.validator.PhoneNumberValidator;

public class MittereMessageTest {
	
	private MittereMessageBuilder mittereMessage;
	
	@Before
	public void setUp() throws Exception {
		mittereMessage = new MittereMessage(new PhoneNumberValidator(), new MessageContentValidator());
	}
	
	@Test(expected = InvalidPhoneNumberException.class)
	public void shouldNotSendMittereMessageWhenPhoneNumberIsInvalid() {
		mittereMessage.to("8588311227", "32723429")
			.withMessage("Fala Benevas!")
			.send();
	}
	
	@Test(expected = InvalidMessageContentException.class)
	public void shouldNotSendMittereMessageWhenMessageContentIsInappropriateOrInvalid() {
		mittereMessage.to("8588311227", "8532723429")
			.withMessage("")
			.send();
	}
	
}
