package transitdroid.domain.logic.technical;

import java.net.URISyntaxException;
/**
 * 
 * @author TransitDroid Team
 * @class IdFactory
 *  This class acts as a factory for all IDs. It generates new and unique ID's to users.
 *
 */
public class IdFactory {
	private static final String prefix = "jdbc.";
	/**
	 *  Receives a table name, retrieves the most recent ID and generates a new and unique ID
	 * accordingly.
	 * 
	 * @param table
	 * @return long
	 * @throws URISyntaxException
	 */
	public static long getNext(String table) throws URISyntaxException{
		String result = null;
		if ((result = Registry.getProperty(prefix+table)) == null){
			Registry.setProperty(prefix+table, "1", "Adding new table");
			return 1;
		}
		long value = Long.parseLong(result);
		Registry.setProperty(prefix+table, String.valueOf(++value), "increamenting value");
		return value;
	}
}
