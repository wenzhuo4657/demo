package jsoup.wenzhuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jsoup.wenzhuo.entity.JdData;

import java.util.List;


/**
 * 京东商品表(JdData)表服务接口
 *
 * @author makejava
 * @since 2024-03-26 20:54:44
 */
public interface JdDataService extends IService<JdData> {
    void saveJdData(JdData jdData);

    List<JdData>  selectJdData(JdData jdData);
}
