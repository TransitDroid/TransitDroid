package transitdroid.data.contract;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import java.sql.PreparedStatement;

public class ContractTOG extends ContractTDG{
	
	static {
		INSERT = "INSERT INTO "+TABLE+" (id, version, mobileDeviceId, cardId, userId, " +
			"key1, key2, key3, key4, salt) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		UPDATE = "UPDATE "+TABLE+" set version=version+1, mobileDeviceId=?, " +
				"cardId=?, userId=?, key1=? , key2=? , key3=? , key4=?, salt=? WHERE id=? and version=?";
		DELETE = "DELETE FROM "+TABLE+" WHERE id=? AND version=?";
	}

	public static synchronized void insert(UUID id, int version, UUID id2, UUID id3,
			UUID id4, List<byte[]> keys, byte[] salt) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement s = prepareStatement(INSERT);
		s.setString(1, id.toString());
		s.setInt(2, version);
		s.setString(3, id2.toString());
		s.setString(4, id3.toString());
		s.setString(5, id4.toString());
		s.setBytes(6, keys.get(0));
		s.setBytes(7, keys.get(1));
		s.setBytes(8, keys.get(2));
		s.setBytes(9, keys.get(3));
		s.setBytes(10, salt);
		
		s.executeUpdate();
	}

	public static synchronized int delete(UUID id, int version) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement s = prepareStatement(DELETE);
		s.setString(1,id.toString());
		s.setInt(2,version);
		
		final int count = s.executeUpdate();
		return count;
	}

	public static synchronized int update(UUID id, int version, UUID id2, UUID id3,
			UUID id4, List<byte[]> keys, byte[] salt) throws SQLException {
		// TODO Auto-generated method stub
		int i = 4;
		PreparedStatement s = prepareStatement(UPDATE);
		s.setString(9, id.toString());
		s.setInt(10, version);
		s.setString(1, id2 == null? null : id2.toString());
		s.setString(2, id3.toString());
		s.setString(3, id4.toString());
		Iterator<byte[]> keysIt = keys.iterator();
		while(keysIt.hasNext())
		{
			s.setBytes(i++, keysIt.next());
		}
		s.setBytes(8, salt);
		
		//count is for the update.
		final int count = s.executeUpdate();
		return count;
	}

}
