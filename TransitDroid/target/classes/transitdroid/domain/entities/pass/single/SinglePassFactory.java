package transitdroid.domain.entities.pass.single;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.UUID;

import transitdroid.domain.core.UnitOfWork;

public class SinglePassFactory {

	public static SinglePass createNew(int quantity, double price,
			Date validUntil) throws URISyntaxException {
		UUID id = UUID.randomUUID();
		return createNew(id, 1, quantity, price, validUntil);

	}

	public static SinglePass createNew(UUID id, int version, int quantity,
			double price, Date validUntil) {
		SinglePass singlePass = new SinglePass(id, version, quantity, price,
				validUntil);
		return singlePass;
	}

	@SuppressWarnings("unchecked")
	public static SinglePass createNew() throws URISyntaxException {
		UUID id = UUID.randomUUID();
		SinglePass singlePass = new SinglePass(id, 1);
		UnitOfWork.getInstance().RegisterNew(singlePass);
		return singlePass;
	}

	public static SinglePass createClean(UUID id, int version, int quantity,
			double price, Date validUntil) {
		SinglePass singlePass = new SinglePass(id, version,  quantity,
				price, validUntil);
		return singlePass;
	}
}
