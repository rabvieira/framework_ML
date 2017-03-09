package sample;

import java.util.HashMap;
import java.util.Map;

public class Session {
	private static Session instance;
	private Map<String, Object> map = new HashMap<>();

	public static Session getInstance(){
		if(instance !=null)
		return instance;
		else {
			instance=new Session();
			return instance;
		}
	}
	
	public void put(String key, Object value){
		this.map.put(key, value);
	}
	
	public Object get(String key){
		return this.map.get(key);
	}
}
