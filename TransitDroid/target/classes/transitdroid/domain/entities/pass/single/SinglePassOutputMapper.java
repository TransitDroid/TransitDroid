package transitdroid.domain.entities.pass.single;

import java.sql.SQLException;


import transitdroid.data.LostUpdateException;
import transitdroid.data.pass.single.SinglePassTOG;
import transitdroid.domain.core.BaseOutputMapper;
import transitdroid.domain.core.exceptions.MapperException;


public class SinglePassOutputMapper extends BaseOutputMapper<ISinglePass>{
	
	public boolean insert(ISinglePass singlePass){
		try {
			
			SinglePassTOG.insert(singlePass.getId(), singlePass.getVersion());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean update(ISinglePass singlePass) throws MapperException{
		try {
			final int count = SinglePassTOG.update(singlePass.getId(), singlePass.getVersion());
			throwLostUpdateOnCountOfZero(singlePass, count);
			singlePass.setVersion(singlePass.getVersion() + 1);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		} catch (LostUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private void throwLostUpdateOnCountOfZero(ISinglePass singlePass, int count) throws LostUpdateException {
		// TODO Auto-generated method stub
		if (count == 0)
			throw new LostUpdateException("SinglePass: id = " + singlePass.getId()
					+ "; version = " + singlePass.getVersion() + " not found");
		
	}

	@Override
	public boolean remove(ISinglePass singlePass) throws LostUpdateException, MapperException {
		// TODO Auto-generated method stub
		try {
			final int count = SinglePassTOG.delete(singlePass.getId(), singlePass.getVersion());
			throwLostUpdateOnCountOfZero(singlePass, count);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		}
	}

}
