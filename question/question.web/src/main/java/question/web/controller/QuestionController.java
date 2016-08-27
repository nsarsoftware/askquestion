package question.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import question.model.Question;
import question.service.repo.QuestionRepository;


@RestController
public class QuestionController {
	
	@Autowired
	QuestionRepository repo;
	
	
	//4.gün örnegi
	//BURADA GET METODUNU KULLANDIK YANI VERI CEKMEK ICIN 
	//FAKE VERI CEKILDI BU ARADA 
	//ISIM YAZIDIRYOR
	@RequestMapping(value="/gretting/{message}",method=RequestMethod.GET)
	public String gretting(@PathVariable("message")String message){
		return "Hello bro,"+message;
	}
	
	
	
	//5.gün ornegı ORJINAL
	@RequestMapping(value="/questions",method=RequestMethod.GET)
	public java.util.List<Question> getQuestions(){
		return (List<Question>) repo.findAll();
		
		//GEREK KALMADI repo aile @Autowired yaptıgımız ıcın.
//		List<Question> questions = getFakeQuestions();
//		return questions;
	
	}
	
	//
	@RequestMapping(value = "/questions/{id}", method = RequestMethod.GET)
	public Question getSingleQuestion(@PathVariable("id") int id) { // id si
		
		Question lq=repo.findOne(id);
		
		return lq;
	}

	
	//Aynı questions ısımlendırmesı ıle 2 adet WEBSERVİCE saglıyoruz
	//@RequestBody dişarıdan gelen bilgiyi dondur ve question objesine dondur
	@RequestMapping(value="/questions",method=RequestMethod.POST)
	public Question saveQuestion(@RequestBody Question question){
		
		return repo.save(question);
	}
	
	@RequestMapping(value="/questions/{id}",method=RequestMethod.DELETE)
	public Question deleteQuestion(@PathVariable("id") int id){
	//	Question repo =new Question();
		Question qd=repo.findOne(id);
		repo.delete(qd);
		return qd;
	}
	/*
	@RequestMapping(value="/question/{id}",method=RequestMethod.PUT)
	public Question updateQuestion(@PathVariable("id") int id,@PathVariable Question soru){
		Question currentUser=repo.findOne(id);
		currentUser.setId(soru.getId());
		currentUser.setTitle(soru.getTitle());
		currentUser.setText(soru.getText());
		
			return currentUser;
	}*/
	}
