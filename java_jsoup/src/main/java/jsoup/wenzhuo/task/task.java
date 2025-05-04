package jsoup.wenzhuo.task;

import jsoup.wenzhuo.StringUtils;
import jsoup.wenzhuo.entity.Img;
import jsoup.wenzhuo.mapper.ImgMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;


import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static com.sun.webkit.perf.WCFontPerfLogger.log;

/**
 * @className: task
 * @author: wenzhuo4657
 * @date: 2024/3/26 20:47
 * @Version: 1.0
 * @description:
 */

@Component
@ConfigurationProperties(prefix = "pa")
public class task {
    private  String  key;
    private  Integer count;

    private Logger logger= LoggerFactory.getLogger(task.class);

    @Resource
    private DataSourceTransactionManager transactionManager;

    @Resource
    private ImgMapper imgMapper;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Scheduled(fixedDelay = 1000*60*60*24)
    public  void Download_jop() throws IOException, InterruptedException {
        for (int i=0;i<count;i++){
            String url= "https://ssr1.scrape.center/";
            urlParse(url);
        }
        System.out.println("抓取完成！！！  抓取次数："+count);

    }

    private void urlParse(String url) throws InterruptedException {
        Document document=null;
        try{
            document=Jsoup.parse(new URL( url),30000);
        } catch (MalformedURLException e) {
            logger.info("{}",e);
        } catch (IOException e) {
            logger.info("{}",e);
        }
        Elements elements=document.select("img");

        List<Img> list=new ArrayList<>();
        for (Element img:elements){
                String img_src=img.attr("src");
                if (img_src!=null&&!ImgsrcIsempty(img_src)){
                    list.add(new Img(img_src));
                }
            }
        TransactionDefinition definition=
               new DefaultTransactionDefinition();
        TransactionStatus status=transactionManager.getTransaction(definition);
        try {
            for (Img img:list){
                logger.info(img.toString());
                imgMapper.insert(img);
            }
            transactionManager.commit(status);
        }catch (Exception e){
            transactionManager.rollback(status);
            throw  new RuntimeException("事务提交失败");
        }
    }

    /**
    * @Author wenzhuo4657
    * @Description
    * @Date 20:45 2024-03-27
    * @Param [imgSrc]
    * @return boolean true表示为空，false表示图片链接不为空，可以正常使用
    **/
    private boolean ImgsrcIsempty(String imgSrc) {
        //  wenzhuo TODO 2024/3/27 : 对图片链接的校验
        if (StringUtils.isEmpty(imgSrc)){
            return true;
        }
        if (isImage(imgSrc)){
            return  false;
        }
        return true;
    }

    public static boolean isImage(String imageUrl) {
        try {
            BufferedImage image = ImageIO.read(new URL(imageUrl));
            return image != null;
        } catch (IOException e) {
            return false;
        }
    }
}