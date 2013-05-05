package transitdroid.domain.logic.command.pass.transaction;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ProcessTransactionCommandTest {

	@Test
	public void testExecute() {
		ProcessTransactionCommand command = new ProcessTransactionCommand();
		command.SetPhoneMac("345345345");
		List<String> keys = new ArrayList<String>();
		String e = new byte[10].toString();
		keys.add(e);
		command.setRequestKeys(keys);
		String passcode = new byte[10].toString();
		command.setRequestPasscode(passcode);
		command.execute();
		assertNotNull(command);
	}

	@Test
	public void testSetRequestPasscode() {
		ProcessTransactionCommand command = new ProcessTransactionCommand();
		String passcode = new byte[10].toString();
		command.setRequestPasscode(passcode);
		
	}

	@Test
	public void testSetRequestKeys() {
		ProcessTransactionCommand command = new ProcessTransactionCommand();
		List<String> keys = new ArrayList<String>();
		String element1 = new byte[10].toString();
		keys.add(element1);
		command.setRequestKeys(keys);
		
	}

	@Test
	public void testSetPhoneMac() {
		ProcessTransactionCommand comm = new ProcessTransactionCommand();
		String mac = "macattack";
		comm.SetPhoneMac(mac);
		
	}

	@Test
	public void testGetResponseKey() {
		ProcessTransactionCommand comm = mock(ProcessTransactionCommand.class);
		String value = new byte[10].toString();
		when(comm.getResponseKey(1)).thenReturn(value );
		
		assertEquals(value, comm.getResponseKey(1));
	}

	@Test
	public void testGetResponseKeys() {
		ProcessTransactionCommand comm = mock(ProcessTransactionCommand.class);
		List<String> value = new ArrayList<String>();
		String element1 = new byte[10].toString();
		String element2 = new byte[10].toString();
		value.add(element1);
		value.add(element2);
		when(comm.getResponseKeys()).thenReturn(value );
		assertEquals(value, comm.getResponseKeys());
		
	}

	@Test
	public void testGetResponseCode() {
		ProcessTransactionCommand comm = mock(ProcessTransactionCommand.class);
		String value = "Hello";
		when(comm.getResponseCode()).thenReturn(value);
		assertEquals(value, comm.getResponseCode());
	}

	@Test
	public void testGetResponsePasscode() {
		ProcessTransactionCommand comm = mock(ProcessTransactionCommand.class);
		String value = new byte[10].toString();
		when(comm.getResponsePasscode()).thenReturn(value );
		assertEquals(value, comm.getResponsePasscode());
	}

	@Test
	public void testGetException() {
		ProcessTransactionCommand comm = new ProcessTransactionCommand();
		comm.SetPhoneMac("3245345");
		String passcode = new byte[10].toString();
		comm.setRequestPasscode(passcode);
		List<String> keys = new ArrayList<String>();
		String elem1 = new byte[10].toString();
		String elem2 = new byte[10].toString();
		keys.add(elem1);
		keys.add(elem2);
		comm.setRequestKeys(keys);
		Exception ex = comm.getException();
		assertEquals(ex, comm.getException());
	}

}
