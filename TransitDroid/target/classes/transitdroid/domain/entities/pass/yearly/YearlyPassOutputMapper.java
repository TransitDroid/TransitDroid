package transitdroid.domain.entities.pass.yearly;

import java.sql.SQLException;


import transitdroid.data.LostUpdateException;
import transitdroid.data.pass.yearly.YearlyPassTOG;
import transitdroid.domain.core.BaseOutputMapper;
import transitdroid.domain.core.exceptions.MapperException;


public class YearlyPassOutputMapper extends BaseOutputMapper<IYearlyPass>{
	
	@Override	
	public boolean insert(IYearlyPass yearlyPass){
		try {
			
			YearlyPassTOG.insert(yearlyPass.getId(), yearlyPass.getVersion());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public boolean update(IYearlyPass yearlyPass) throws MapperException{
		try {
			final int count = YearlyPassTOG.update(yearlyPass.getId(), yearlyPass.getVersion());
			throwLostUpdateOnCountOfZero(yearlyPass, count);
			yearlyPass.setVersion(yearlyPass.getVersion() + 1);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		} catch (LostUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	private void throwLostUpdateOnCountOfZero(IYearlyPass yearlyPass, int count) throws LostUpdateException {
		// TODO Auto-generated method stub
		if (count == 0)
			throw new LostUpdateException("YearlyPass: id = " + yearlyPass.getId()
					+ "; version = " + yearlyPass.getVersion() + " not found");
		
	}
	@Override
	public boolean remove(IYearlyPass yearlyPass) throws LostUpdateException, MapperException {
		// TODO Auto-generated method stub
		try {
			final int count = YearlyPassTOG.delete(yearlyPass.getId(), yearlyPass.getVersion());
			throwLostUpdateOnCountOfZero(yearlyPass, count);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		}
	}

}
