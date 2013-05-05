package transitdroid.domain.core.exceptions;

import java.sql.SQLException;

public class MapperException extends Exception {

	private static final long serialVersionUID = -5083579811552065373L;
	
	public MapperException(SQLException e) {
		// TODO Auto-generated constructor stub
		super(e);
	}
}
