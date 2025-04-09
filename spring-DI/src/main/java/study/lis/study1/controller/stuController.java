package study.lis.study1.controller;

import org.springframework.stereotype.Controller;
import study.lis.study1.domain.ter.impl.TerHysImpl;

/**
 * @className: stuController
 * @author: wenzhuo4657
 * @date: 2024/5/27 11:37
 * @Version: 1.0
 * @description:
 */
@Controller
public class stuController {

    private final TerHysImpl terHys;

    public stuController(TerHysImpl terHys) {
        this.terHys = terHys;
    }

    public TerHysImpl getTerHys() {
        return terHys;
    }
}