package transitdroid.domain.entities.pass.yearly;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.UUID;

import transitdroid.data.pass.yearly.YearlyPassTIG;
import transitdroid.domain.core.BaseInputMapper;
import transitdroid.domain.core.IdentityMapRepository;

public class YearlyPassInputMapper extends BaseInputMapper<YearlyPass> {

	public YearlyPass find(UUID id) {
		ResultSet set = null;
		YearlyPass yearlyPass = null;
		if ((yearlyPass = (YearlyPass) IdentityMapRepository.getIdentityMap(YearlyPass.class).get(id)) != null) {
			return yearlyPass;
		}
		try {
			set = YearlyPassTIG.find(id);
			if (set.next())
			yearlyPass = map(set);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return yearlyPass;
	}

	protected YearlyPass map(ResultSet set) throws SQLException {
		YearlyPass yearlyPass = null;
		if ((yearlyPass = (YearlyPass) IdentityMapRepository.getIdentityMap(YearlyPass.class).get(
				UUID.fromString(set.getString(1)))) != null) {
			return yearlyPass;
		}
		yearlyPass = YearlyPassFactory.createClean(
				UUID.fromString(set.getString(1)), set.getInt(2));
		IdentityMapRepository.getIdentityMap(YearlyPass.class).put(yearlyPass);
		return yearlyPass;
	}

}
