package transitdroid.domain.entities.pass.yearly;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.UUID;

import transitdroid.data.pass.yearly.YearlyPassTIG;
import transitdroid.domain.core.BaseInputMapper;

public class YearlyPassInputMapper extends BaseInputMapper<YearlyPass> {

	public YearlyPass find(UUID id) {
		ResultSet set = null;
		YearlyPass yearlyPass = null;
		if ((yearlyPass = YearlyPassIdentityMap.getUniqueInstance().get(id)) != null) {
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
		if ((yearlyPass = YearlyPassIdentityMap.getUniqueInstance().get(
				UUID.fromString(set.getString(1)))) != null) {
			return yearlyPass;
		}
		yearlyPass = YearlyPassFactory.createClean(
				UUID.fromString(set.getString(1)), set.getInt(2));
		YearlyPassIdentityMap.getUniqueInstance().put(yearlyPass.getId(),
				yearlyPass);
		return yearlyPass;
	}

}
