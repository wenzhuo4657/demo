package org.example;
 

import org.example.MailUtil.impl.EmailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@Component
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendEmailApplicationTests {
 
    /**
     * 注入发送邮件的接口
     */
    @Autowired
    private EmailUtil mailService;
 
    /**
     * 测试发送文本邮件
     */
    @Test
    public void sendmail() {
        mailService.sendSimpleMail("2537099525@qq.com","主题：你好普通邮件","内容：第一封邮件");
    }
 
    @Test
    public void sendmailHtml(){
        mailService.sendHtmlMail("xxx@qq.com","主题：你好html邮件","<h1>内容：第一封html邮件</h1>");
    }
}