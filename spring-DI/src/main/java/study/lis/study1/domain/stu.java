package study.lis.study1.domain;

import lombok.Data;

/**
 * @className: stu
 * @author: wenzhuo4657
 * @date: 2024/5/27 11:36
 * @Version: 1.0
 * @description:
 */

@Data
public class stu {

    String name ="这是什么东西？";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}