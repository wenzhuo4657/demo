package study.lis.study1.domain.ter.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import study.lis.study1.domain.ter.Ter;

/**
 * @className: TerHosImpl
 * @author: wenzhuo4657
 * @date: 2024/5/27 12:05
 * @Version: 1.0
 * @description:
 */
@Component(value = "这是自建的")
@Data
public class TerHosImpl implements Ter {
    int ter=90809121;
}