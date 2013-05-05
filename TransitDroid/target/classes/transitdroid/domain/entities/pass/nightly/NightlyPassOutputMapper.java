package transitdroid.domain.entities.pass.nightly;

import java.sql.SQLException;


import transitdroid.data.LostUpdateException;
import transitdroid.data.pass.nightly.NightlyPassTOG;
import transitdroid.domain.core.BaseOutputMapper;
import transitdroid.domain.core.exceptions.MapperException;


public class NightlyPassOutputMapper extends BaseOutputMapper<INightlyPass>{

	public boolean insert(INightlyPass nightlyPass){
		try {
			
			NightlyPassTOG.insert(nightlyPass.getId(), nightlyPass.getVersion());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean update(INightlyPass nightlyPass) throws MapperException{
		try {
			final int count = NightlyPassTOG.update(nightlyPass.getId(), nightlyPass.getVersion());
			throwLostUpdateOnCountOfZero(nightlyPass, count);
			nightlyPass.setVersion(nightlyPass.getVersion() + 1);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		} catch (LostUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private void throwLostUpdateOnCountOfZero(INightlyPass nightlyPass, int count) throws LostUpdateException {
		// TODO Auto-generated method stub
		if (count == 0)
			throw new LostUpdateException("NightlyPass: id = " + nightlyPass.getId()
					+ "; version = " + nightlyPass.getVersion() + " not found");
	}

	@Override
	public boolean remove(INightlyPass nightlyPass) throws LostUpdateException, MapperException {
		// TODO Auto-generated method stub
		try {
			final int count = NightlyPassTOG.delete(nightlyPass.getId(), nightlyPass.getVersion());
			throwLostUpdateOnCountOfZero(nightlyPass, count);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		}
	}
	
}
