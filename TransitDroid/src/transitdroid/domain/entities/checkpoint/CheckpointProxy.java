package transitdroid.domain.entities.checkpoint;

import java.util.UUID;

import transitdroid.domain.core.BaseProxy;
import transitdroid.domain.core.exceptions.ProxyException;


@Deprecated
public class CheckpointProxy extends BaseProxy<Checkpoint> implements ICheckpoint {


	protected CheckpointProxy(UUID id) {
		super(id, Checkpoint.class);
	}

	public int getVersion() {
		int version = 0;
		try {
			version = getInnerObject().getVersion();
		} catch (ProxyException e) {
			e.printStackTrace();
		}
		return version;
	}

	@Override
	public void setVersion(int i) {
		// TODO Auto-generated method stub
		
	}

}
