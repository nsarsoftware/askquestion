package question.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import question.service.beans.SayGreeting;

@RestController
@SpringBootApplication
@EntityScan(basePackages = "question.model")
@EnableJpaRepositories(basePackages = "question.service.repo")
public class QuestionWebRunner {
	//@Autowired
	public SayGreeting greeting;
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";//+greeting.SayHello();
	}

	public static void main(String[] args) { 
		SpringApplication.run(QuestionWebRunner.class, args);
		
	}
}
