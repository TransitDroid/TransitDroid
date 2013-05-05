package transitdroid.data.card;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class CardTIGTest {

	@Test
	public void testFindAll() {
		ResultSet result = CardTIG.findAll();
		assertNull(result);
		
	}

	@Test
	public void testFind() throws SQLException {
		String id= "14dd1798-1aab-4485-80a9-4ce2e77b85e5";
		UUID newId = UUID.fromString(id); 
		ResultSet result = CardTIG.find(newId);
		assertNotNull(result);
		
	}

}
