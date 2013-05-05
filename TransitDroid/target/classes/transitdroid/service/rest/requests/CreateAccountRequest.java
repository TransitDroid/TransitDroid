package transitdroid.service.rest.requests;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CreateAccountRequest{

	private String name;

	public CreateAccountRequest(){
		
	}
	
	public CreateAccountRequest(String name){
		this.name = name;
	}
	
	@XmlElement
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
