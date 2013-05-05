package transitdroid.domain.entities.pass.single;

import java.util.Date;
import java.util.UUID;

import transitdroid.domain.core.DomainObject;

public class SinglePass extends DomainObject implements ISinglePass {

	private int quantity;
	private double price;
	private Date validUntil;

	public SinglePass(UUID id, int version, int quantity, double price,
			Date validUntil) {
		super(id, version);
		this.quantity = quantity;
		this.price = price;
		this.validUntil = validUntil;
	}

	public SinglePass() {
	}

	public SinglePass(UUID id, int version) {
		super(id, version);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}


}
