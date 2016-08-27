package question.service.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("greeting")
public class SayGreeting {
	
	@Autowired
	@Qualifier("tr")//springi tr bean ile ba�l�yor serviceten mesaj almas� i�in koymazsak bunu al�nacak birden fazla mesaj oldu�u i�in �a��r�yor
	private MessageService service;
	@Autowired
	@Qualifier("myds")
	private DataSource ds;
	public String SayHello(){
		return service.getMessage()+ "Spring "+ds.getUrl();
	}
}
