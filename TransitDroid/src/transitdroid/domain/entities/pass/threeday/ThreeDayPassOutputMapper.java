package transitdroid.domain.entities.pass.threeday;

import java.sql.SQLException;


import transitdroid.data.LostUpdateException;
import transitdroid.data.pass.threeday.ThreeDayPassTOG;
import transitdroid.domain.core.BaseOutputMapper;
import transitdroid.domain.core.exceptions.MapperException;


public class ThreeDayPassOutputMapper extends BaseOutputMapper<IThreeDayPass>{
	@Override
	public boolean insert(IThreeDayPass threeDayPass){
		try {
			
			ThreeDayPassTOG.insert(threeDayPass.getId(), threeDayPass.getVersion());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public boolean update(IThreeDayPass threeDayPass) throws MapperException{
		try {
			final int count = ThreeDayPassTOG.update(threeDayPass.getId(), threeDayPass.getVersion());
			throwLostUpdateOnCountOfZero(threeDayPass, count);
			threeDayPass.setVersion(threeDayPass.getVersion() + 1);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		} catch (LostUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private void throwLostUpdateOnCountOfZero(IThreeDayPass threeDayPass,
			int count) throws LostUpdateException {
		// TODO Auto-generated method stub
		if (count == 0)
			throw new LostUpdateException("ThreeDayPass: id = " + threeDayPass.getId()
					+ "; version = " + threeDayPass.getVersion() + " not found");
		
	}
	@Override
	public boolean remove(IThreeDayPass threeDayPass) throws LostUpdateException, MapperException {
		// TODO Auto-generated method stub
		try {
			final int count = ThreeDayPassTOG.delete(threeDayPass.getId(), threeDayPass.getVersion());
			throwLostUpdateOnCountOfZero(threeDayPass, count);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		}
	}

}
