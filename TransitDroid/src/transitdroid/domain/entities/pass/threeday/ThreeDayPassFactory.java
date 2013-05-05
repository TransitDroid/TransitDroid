package transitdroid.domain.entities.pass.threeday;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.UUID;

import transitdroid.domain.core.UnitOfWork;

public class ThreeDayPassFactory {

	public static ThreeDayPass createNew(Date date) throws URISyntaxException {
		UUID id = UUID.randomUUID();
		return createNew(id, 1, date);

	}

	public static ThreeDayPass createNew(UUID id, int version, Date date) {
		ThreeDayPass threeDayPass = new ThreeDayPass(id, version, date);
		return threeDayPass;
	}

	@SuppressWarnings("unchecked")
	public static ThreeDayPass createNew() throws URISyntaxException {
		UUID id = UUID.randomUUID();
		ThreeDayPass threeDayPass = new ThreeDayPass(id, 1);
		UnitOfWork.getInstance().RegisterNew(threeDayPass);
		return threeDayPass;
	}

	public static ThreeDayPass createClean(UUID id, int version) {
		ThreeDayPass threeDayPass = new ThreeDayPass(id, version);
		return threeDayPass;
	}

}
