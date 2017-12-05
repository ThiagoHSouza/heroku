package br.com.developer.openshift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TesteOpenshift1Application {

	public static void main(String[] args) {
		SpringApplication.run(TesteOpenshift1Application.class, args);
	}
	
	@GetMapping("/")
	public String teste(){
		return "HelloWorld 2";
	}
}
