package org.example.ioc;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author: wenzhuo4657
 * @date: 2024/11/12
 * @description:
 */
@SPI
public interface Pen {

    @Adaptive({"PenRes"})
    void run(URL url);
}
