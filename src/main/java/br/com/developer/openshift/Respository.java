package br.com.developer.openshift;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Respository extends MongoRepository<Pessoa, String> {

}
