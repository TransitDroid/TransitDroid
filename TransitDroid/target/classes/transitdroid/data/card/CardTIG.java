package transitdroid.data.card;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
/**
 * 
 * @author TransitDroid Team
 * @class CardTIG
 *  Contains the SQL logic to find objects from the database. The CardTIG's methods are static
 *        and to be used in the CardInputMapper. Extends CardTDG to implement and use the preparedStatements.
 *
 */
public class CardTIG extends CardTDG {
	
	static {
		SELECT = "SELECT * FROM "+TABLE+" WHERE id= ?";
		}
	/**
	 *  returns back all the Card Entities in the database
	 * @return ResultSet
	 */
	public static synchronized ResultSet findAll() {
		return null;
				
	}
	/**
	 *  returns back a specific card from the database with the indicated UUID.
	 * 
	 * @param id
	 * @return ResultSet
	 * @throws SQLException
	 */
	public static synchronized ResultSet find(UUID id) throws SQLException {
		PreparedStatement s = prepareStatement(SELECT);
		s.setString(1, id.toString());
		return s.executeQuery();
	}

}
