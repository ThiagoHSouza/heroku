package br.com.developer.openshift;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Pessoa {
	
	@Id
	private String id;
	
	private String text;
	
	public Pessoa(String text){
		this.text = text;
	}
	
}
