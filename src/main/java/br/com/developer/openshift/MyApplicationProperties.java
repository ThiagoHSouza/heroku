package br.com.developer.openshift;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties("heroku")
public class MyApplicationProperties {

	private Info info;
	private Cache cache;

	/**
	 * Cache
	 */
	@Data
	public static class Cache {
		private List<String> names;
		private Timeout timeout;
	}

	/**
	 * Timeout
	 */
	@Data
	public static class Timeout {
		private int defaultExpiration;
	}

	/**
	 * Info class
	 */
	@Data
	public static class Info {
		private String projectName;
		private String version;
		private String timestamp;
	}

}