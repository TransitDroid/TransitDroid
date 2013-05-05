package transitdroid.domain.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
/**
 *
 * 
 * @author TransitDroid Team
 * @mainpage TransitDroid
 * 
 * TransitDroid is a software system that complements and expands upon the OPUS system, currently
 * used by the Societe de Transport de Montreal (STM). The TransitDroid mobile application will allow an
 * individual to enter the public transit system using a Near Field Communication (NFC) enabled mobile
 * device. Similar to how the OPUS card is currently used, clients will hold their NFC-enabled mobile
 * device over the reader instead of a card. Our solution is not a replacement of the existing infrastructure
 * that is already effective and heavily used. Rather, it provides clients with a mobile alternative. For the
 * purpose of this project, we will be focusing on the Android operating system with the option of eventually
 * extending to other NFC compliant platforms.
 *
 * @class BaseInputMapper
 *  An abstract class to all Input Mappers. This Class is to be extended by all InputMappers.
 * 		  It accepts as a parameter and object which extends a DomainObject type.
 * @param <T> 
 */
public abstract class BaseInputMapper<T extends DomainObject> {

	public abstract T find(UUID id) throws SQLException;
	protected abstract T map(ResultSet set) throws SQLException;
}
