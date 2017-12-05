package br.com.developer.openshift;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

	@Autowired
	private StringRedisSerializer stringRedisSerializer;
	
	@Autowired
    private JedisConnectionFactory jedisConnFactory;

	@Autowired
    private MyApplicationProperties myApplicationProperties;

	@Bean
	public StringRedisSerializer stringRedisSerializer() {
		return new StringRedisSerializer(Charset.forName("UTF-8"));
	}

	@Bean
    public RedisTemplate<String, Object> redisTemplate() {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnFactory);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

	@Bean
	public CacheManager cacheManager(final RedisTemplate<?, ?> redisTemplate) {
		
		final RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        cacheManager.setUsePrefix(true);
        cacheManager.setCacheNames(myApplicationProperties.getCache().getNames());
        cacheManager.setDefaultExpiration(myApplicationProperties.getCache().getTimeout().getDefaultExpiration());
        return cacheManager;
	}

}
