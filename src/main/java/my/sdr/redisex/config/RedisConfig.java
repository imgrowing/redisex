package my.sdr.redisex.config;

import my.sdr.redisex.dto.InvoicePoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setTestOnBorrow(true);

        JedisConnectionFactory factory = new JedisConnectionFactory(poolConfig);
        factory.setHostName("127.0.0.1");
        factory.setPort(6379);
        factory.setUsePool(true);
        return factory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        System.out.println("redisTemplate - String/Obj 1 : " + redisTemplate);
        return redisTemplate;
    }

    @Bean
    public RedisTemplate<String, InvoicePoint> redisTemplateInvoice() {
        RedisTemplate<String, InvoicePoint> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(InvoicePoint.class));
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(InvoicePoint.class));
        System.out.println("redisTemplate - String/Obj 1 : " + redisTemplate);
        return redisTemplate;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate1() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        System.out.println("redisTemplate - Obj/Obj : " + redisTemplate);
        return redisTemplate;
    }
}
