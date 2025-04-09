package study.lis.study1.controller;

import java.util.List;
import java.util.Map;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import study.lis.study1.domain.ter.Ter;

/**
 * @className: hys
 * @author: wenzhuo4657
 * @date: 2024/5/27 12:11
 * @Version: 1.0
 * @description:
 */

@Data
@Controller
public class hysController {
    private  final List<Ter> list;
    private final Map<String,Ter> map;

    @Autowired
    public hysController(List<Ter> list, Map<String, Ter> map) {
        this.list = list;
        this.map = map;
    }


    public List<Ter> getList() {
        return list;
    }

    public Map<String, Ter> getMap() {
        return map;
    }
}