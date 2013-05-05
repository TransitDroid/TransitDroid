package transitdroid.domain.core;

public class KeyValuePair<KEY, VAL> {

	private KEY key;
	private VAL value;
	public KeyValuePair(KEY key, VAL value){
		this.key = key;
		this.value = value;
	}
	
	public KEY getKey(){
		return this.key;
	}
	public VAL getValue(){
		return this.value;
	}
}
