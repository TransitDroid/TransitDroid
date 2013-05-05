package transitdroid.domain.core;

public class CommandAttribute {
	private Object value;
	private Class<?> commClass;
	
	public CommandAttribute(Object value){
		this.setCommClass(value.getClass());
		this.value = value;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.setCommClass(value.getClass());
		this.value = value;
	}
	public Class<?> getCommClass() {
		return commClass;
	}
	private void setCommClass(Class<?> commClass) {
		this.commClass = commClass;
	}
	
}
