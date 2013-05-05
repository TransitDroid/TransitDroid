package transitdroid.domain.entities.pass.monthly;

import java.sql.SQLException;


import transitdroid.data.LostUpdateException;
import transitdroid.data.pass.monthly.MonthlyPassTOG;
import transitdroid.domain.core.BaseOutputMapper;
import transitdroid.domain.core.exceptions.MapperException;


public class MonthlyPassOutputMapper extends BaseOutputMapper<IMonthlyPass>{
	
	//TODO: returns
	public boolean insert(IMonthlyPass monthlyPass){
		try {
			
			MonthlyPassTOG.insert(monthlyPass.getId(), monthlyPass.getVersion());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean update(IMonthlyPass monthlyPass) throws MapperException{
		try {
			final int count = MonthlyPassTOG.update(monthlyPass.getId(), monthlyPass.getVersion());
			throwLostUpdateOnCountOfZero(monthlyPass, count);
			monthlyPass.setVersion(monthlyPass.getVersion() + 1);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		} catch (LostUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private void throwLostUpdateOnCountOfZero(IMonthlyPass monthlyPass, int count) throws LostUpdateException {
		// TODO Auto-generated method stub
		if (count == 0)
			throw new LostUpdateException("MonthlyPass: id = " + monthlyPass.getId()
					+ "; version = " + monthlyPass.getVersion() + " not found");
		
	}

	@Override
	public boolean remove(IMonthlyPass monthlyPass) throws LostUpdateException, MapperException {
		// TODO Auto-generated method stub
		try {
			final int count = MonthlyPassTOG.delete(monthlyPass.getId(), monthlyPass.getVersion());
			throwLostUpdateOnCountOfZero(monthlyPass, count);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		}
	}

}
