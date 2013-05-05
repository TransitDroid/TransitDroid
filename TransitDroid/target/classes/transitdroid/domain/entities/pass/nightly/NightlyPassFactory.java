package transitdroid.domain.entities.pass.nightly;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.UUID;

import transitdroid.domain.core.UnitOfWork;

public class NightlyPassFactory {

	public static NightlyPass createNew(Date date) throws URISyntaxException {
		UUID id = UUID.randomUUID();
		return createNew(id, 1, date);

	}

	public static NightlyPass createNew(UUID id, int version, Date date) {
		NightlyPass nightlyPass = new NightlyPass(id, version, date);
		return nightlyPass;
	}

	@SuppressWarnings("unchecked")
	public static NightlyPass createNew() throws URISyntaxException {
		UUID id = UUID.randomUUID();
		NightlyPass nightlyPass = new NightlyPass(id, 1);
		UnitOfWork.getInstance().RegisterNew(nightlyPass);
		return nightlyPass;
	}

	public static NightlyPass createClean(UUID id, int version) {
		NightlyPass nightlyPass = new NightlyPass(id, version);
		return nightlyPass;
	}

}
