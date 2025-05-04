package study.lis;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import study.lis.study1.domain.ter.impl.TerHysImpl;

/**
 * @className: main
 * @author: wenzhuo4657
 * @date: 2024/5/27 11:36
 * @Version: 1.0
 * @description:
 */

@SpringBootApplication
@ComponentScan(basePackages = {"study.lis.study1"})
public class main {

}