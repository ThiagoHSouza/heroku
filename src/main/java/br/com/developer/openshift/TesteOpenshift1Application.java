package br.com.developer.openshift;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TesteOpenshift1Application {
	
	@Autowired
	private Respository rep;

	public static void main(String[] args) {
		SpringApplication.run(TesteOpenshift1Application.class, args);
	}
	
	private static Integer count = 0;
	
	@GetMapping("redis/{id}")
	@Cacheable("count")
	public String testeRedis(@PathVariable("id") String id){
		return "Redis : " + id + " : CACHE : " + (count++);
	}
	
	@GetMapping("save/{text}")
	public Pessoa save((@PathVariable("text") String text){
		return rep.save(new Pessoa(text));
	}
	
	@GetMapping("get")
	public List<Pessoa> get(){
		return rep.findAll();
	}
	
	@GetMapping("/")
	public String teste(){
		return "HelloWorld 2";
	}
}
