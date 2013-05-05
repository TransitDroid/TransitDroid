package transitdroid.domain.core;

public class Guard {

	public static boolean notNull(Object... params){		
		for (Object param : params){
			if (param == null) return false;
		}
		return true;
	}
}
