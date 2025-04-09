package redis.stu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @className: RedsiTempliate
 * @author: wenzhuo4657
 * @date: 2024/5/9 15:17
 * @Version: 1.0
 * @description:  使用json处理value的序列化和反序列化
 * 注入自定义redisTempliate,
 * 该bean有默认配置，但功能不全，例如没有对《K，V》进行序列化、反序列化配置
 */
@Configuration
@ConfigurationProperties
public class RedsiTempliate {


    @Bean
    public  RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> template=new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        GenericJackson2JsonRedisSerializer jsonRedisSerializer =
                new GenericJackson2JsonRedisSerializer();
        template.setKeySerializer(RedisSerializer.string());
        template.setHashKeySerializer(RedisSerializer.string());
        template.setValueSerializer(jsonRedisSerializer );
        template.setHashValueSerializer(jsonRedisSerializer);
        return  template;
    }




}