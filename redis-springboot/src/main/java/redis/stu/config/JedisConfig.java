package redis.stu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @className: JedisConfig
 * @author: wenzhuo4657
 * @date: 2024/5/9 14:35
 * @Version: 1.0
 * @description: 注入自定义jedis连接池
 * 该bean没有默认配置
 */

@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class JedisConfig {

   private String database;
    private String host;
    private String port;

    @Value("${spring.redis.jedis.pool.max-active}")
   private int maxActive;
    @Value("${spring.redis.jedis.pool.max-idle}")
   private int maxIdle;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;


    @Bean
    public JedisPool jedisPool(){
        JedisPoolConfig poolConfig =new JedisPoolConfig();
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxIdle(maxIdle);
        JedisPool jedisPool=new JedisPool(poolConfig);
        return jedisPool;

    }


    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }
}