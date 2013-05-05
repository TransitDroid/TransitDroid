package transitdroid.domain.entities.pass.monthly;

import transitdroid.domain.core.IDomainObject;

public interface IMonthlyPass extends IDomainObject{
	
	public int getVersion();

	public void setVersion(int version);

	public int getMonth();

	public void setMonth(int month);

	public int getYear();

	public void setYear(int year);

	public int hashCode();

	public boolean equals(Object obj);

	@Override
	public String toString();
}
