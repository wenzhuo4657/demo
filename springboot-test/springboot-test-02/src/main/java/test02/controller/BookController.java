package test02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import test02.enity.Book;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String xxgetById(){
        System.out.println("getById方法正在运行");
        return "getById方法正在运行";
    }

    @RequestMapping("/book")
    @ResponseBody
    public Book xxgetBook(){
        return new Book();
    }

}