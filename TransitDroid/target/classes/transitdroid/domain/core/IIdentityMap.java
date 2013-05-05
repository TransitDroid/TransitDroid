package transitdroid.domain.core;


public interface IIdentityMap<T extends DomainObject> {

	public void put(T object);
}
