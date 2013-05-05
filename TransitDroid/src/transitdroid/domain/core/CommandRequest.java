package transitdroid.domain.core;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author psmelser
 */
public abstract class CommandRequest {
	private Map<String, CommandAttribute> attributes = new HashMap<String, CommandAttribute>();
	
	public void set(String name, Object value){
		
		attributes.put(name, new CommandAttribute(value));
	}
	
	public Object get(String name){
		return attributes.get(name).getValue();
	}
}
