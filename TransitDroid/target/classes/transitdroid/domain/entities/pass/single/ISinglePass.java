package transitdroid.domain.entities.pass.single;

import java.util.Date;

import transitdroid.domain.core.IDomainObject;

public interface ISinglePass extends IDomainObject {

	public int getVersion();
	
	public void setVersion(int i);
	public int getQuantity();

	public void setQuantity(int quantity);

	public double getPrice();

	public void setPrice(double price);

	public Date getValidUntil();

	public void setValidUntil(Date validUntil);


}
