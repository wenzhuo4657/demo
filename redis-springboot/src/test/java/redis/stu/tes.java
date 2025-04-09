package redis.stu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author: wenzhuo4657
 * @date: 2024/10/24
 * @description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class tes {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForZSet().add("k1",1,6);
        redisTemplate.opsForZSet().add("k1",2,5);
        redisTemplate.opsForZSet().add("k1",3,4);
        Set<Object> k11 = redisTemplate.opsForZSet().rangeByScore("k1", 0, -1);
        while (true);
    }
}
