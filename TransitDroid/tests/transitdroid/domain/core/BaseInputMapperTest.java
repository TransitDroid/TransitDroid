package transitdroid.domain.core;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.util.UUID;

import org.junit.Test;
import org.mockito.Mockito;

import transitdroid.domain.entities.user.User;
import transitdroid.domain.entities.user.UserInputMapper;


public class BaseInputMapperTest {

	@Test
	public void testFind() {
		
		UserInputMapper im = new UserInputMapper();
		UUID id = UUID.randomUUID();
		User user = im.find(id);
		assertNotNull(user);
		
	}

	@Test
	public void testMap() {
		
		@SuppressWarnings("unused")
		UserInputMapper im = new UserInputMapper();
		@SuppressWarnings("unused")
		ResultSet resultSetMock = Mockito.mock(ResultSet.class);
		
		
		//User user = im.map(resultSetMock);
		
		
	}

}
