package jsoup.wenzhuo.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
//  wenzhuo TODO 2024/3/27 : 参数获取待校验
    private  String  key;
    private  Integer count;

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
    public  void Download_jop(){
        for (int i=0;i<count;i++){
            String url= "https://search.jd.com/Search?keyword="+key+"&page="+i;
            urlParse(url);
        }
        System.out.println("抓取完成！！！关键词条："+key+"抓取次数："+count);
    }

    private void urlParse(String url) {
        //  wenzhuo TODO 2024/3/27 : 待做
    }
}