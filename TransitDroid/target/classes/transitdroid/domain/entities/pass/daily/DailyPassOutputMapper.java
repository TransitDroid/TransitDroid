package transitdroid.domain.entities.pass.daily;

import java.sql.SQLException;


import transitdroid.data.LostUpdateException;
import transitdroid.data.pass.daily.DailyPassTOG;
import transitdroid.domain.core.BaseOutputMapper;
import transitdroid.domain.core.exceptions.MapperException;



public class DailyPassOutputMapper extends BaseOutputMapper<IDailyPass>{
	
	
	public boolean insert(IDailyPass dailyPass){
		try {
			
			DailyPassTOG.insert(dailyPass.getId(), dailyPass.getVersion());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean update(IDailyPass dailyPass) throws MapperException{
		try {
			final int count = DailyPassTOG.update(dailyPass.getId(), dailyPass.getVersion());
			throwLostUpdateOnCountOfZero(dailyPass, count);
			dailyPass.setVersion(dailyPass.getVersion() + 1);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		} catch (LostUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	private void throwLostUpdateOnCountOfZero(IDailyPass dailyPass, int count) throws LostUpdateException {
		// TODO Auto-generated method stub
		if (count == 0)
			throw new LostUpdateException("DailyPass: id = " + dailyPass.getId()
					+ "; version = " + dailyPass.getVersion() + " not found");
		
	}
	@Override
	public boolean remove(IDailyPass dailyPass) throws LostUpdateException, MapperException {
		// TODO Auto-generated method stub
		try {
			final int count = DailyPassTOG.delete(dailyPass.getId(), dailyPass.getVersion());
			throwLostUpdateOnCountOfZero(dailyPass, count);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		}
	}


}
