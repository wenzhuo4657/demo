package study.lis.study1.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.lis.study1.domain.stu;

/**
 * @className: DIconfig
 * @author: wenzhuo4657
 * @date: 2024/5/27 15:50
 * @Version: 1.0
 * @description:
 */
@Configuration
public class DIconfig {

    @Bean
    @ConditionalOnProperty(name = "feature.flag.enable", havingValue = "tru")
    public stu  stu(){
        return new stu();
    }
}