package br.com.developer.openshift;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
@Component
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {
	
	@NotNull
	private String url;
	
	@NotNull
	private Integer port;
}
