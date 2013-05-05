package transitdroid.domain.core;

import static org.junit.Assert.*;

import org.junit.Test;

import transitdroid.domain.entities.user.User;
import transitdroid.domain.entities.user.UserInputMapper;
import transitdroid.domain.entities.user.UserOutputMapper;

public class MapperRepositoryTest {

	@Test
	public void testGetInputMapper() {
		UserInputMapper im = null;
		im = (UserInputMapper) MapperRepository.getInputMapper(User.class);
		
		assertNotNull(im);
		
	}

	@SuppressWarnings("unused")
	@Test
	public void testGetOutputMapper() {
		UserOutputMapper im = null;
		im = (UserOutputMapper) MapperRepository.getOutputMapper(User.class);
		
	}

}
