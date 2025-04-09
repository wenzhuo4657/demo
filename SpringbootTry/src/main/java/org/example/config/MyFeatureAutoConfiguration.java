
package org.example.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(MyFeature.class)
@ConditionalOnProperty(prefix = "myfeature", name = "enabled", matchIfMissing = true)
public class MyFeatureAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MyFeature myFeature() {

        return new MyFeature();
    }
}
