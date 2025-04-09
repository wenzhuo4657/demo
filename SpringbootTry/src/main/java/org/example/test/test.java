package org.example.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.support.ServletContextAwareProcessor;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @className: test
 * @author: wenzhuo4657
 * @date: 2024/3/26 14:25
 * @Version: 1.0
 * @description:
 */
public class test {
    public static void main(String[] args) throws IOException {
        Document doc= Jsoup.connect("http://spiderbuf.cn/n06").get();
        String html=doc.html();
        System.out.println(html);
    }
}