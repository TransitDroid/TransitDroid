package transitdroid.domain.logic.command.pass.validate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import transitdroid.domain.entities.card.Card;

public class ValidatePassCommandTest {

	

	

	@Test
	public void testExecute() {
		ValidatePassCommand command = new ValidatePassCommand();
		Card card = mock(Card.class);
		command.setCard(card);
		command.execute();
		
		
	}

	@Test
	public void testSetCard() {
		
		ValidatePassCommand command = new ValidatePassCommand();
		Card card = mock(Card.class);
		command.setCard(card);
		
		
	}

	@Test
	public void testIsSuccess() {
		ValidatePassCommand comm = new ValidatePassCommand();
		boolean result = comm.isSuccess();
		assertFalse(result);
		
	}

}
