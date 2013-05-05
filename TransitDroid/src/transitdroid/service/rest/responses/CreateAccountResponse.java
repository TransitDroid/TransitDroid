package transitdroid.service.rest.responses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CreateAccountResponse{

	public String name;
	public boolean success;
	
	public CreateAccountResponse(String name){
		this.name = name;
		this.success = true;
	}
	
	public CreateAccountResponse(){
		
	}
	@XmlElement
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	@XmlElement
	public boolean isSuccess(){
		return success;
	}

}
