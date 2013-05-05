package transitdroid.domain.entities.pass.single;

import java.util.Date;
import java.util.UUID;


import transitdroid.domain.core.BaseProxy;

public class SinglePassProxy extends BaseProxy<SinglePass> implements ISinglePass {

	public SinglePassProxy(UUID id) {
		super(id, SinglePass.class);
	}

	public int getVersion() {

		return getInnerObject().getVersion();
	}

	public void setVersion(int version) {

		getInnerObject().setVersion(version);
	}

	public int getQuantity() {

		return getInnerObject().getQuantity();
	}

	public void setQuantity(int quantity) {

		getInnerObject().setQuantity(quantity);
	}

	public double getPrice() {

		return getInnerObject().getPrice();
	}

	public void setPrice(double price) {

		getInnerObject().setPrice(price);
	}

	public Date getValidUntil() {

		return getInnerObject().getValidUntil();
	}

	public void setValidUntil(Date validUntil) {

		getInnerObject().setValidUntil(validUntil);
	}

	public int hashCode() {

		return getInnerObject().hashCode();
	}

	public boolean equals(Object obj) {

		return getInnerObject().equals(obj);
	}

	public String toString() {

		return getInnerObject().toString();
	}


}
