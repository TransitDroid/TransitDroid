package transitdroid.domain.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class GuardTest {

	@Test
	public void testNotNull() {
		Object a = null;
		Object b = new Object();
		Object c = new Object();
		
		
		assertFalse(Guard.notNull(a,b,c));
		
		a = new Object();
		
		assertTrue(Guard.notNull(a,b,c));
	}

}
