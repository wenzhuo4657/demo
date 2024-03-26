package jsoup.wenzhuo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jsoup.wenzhuo.entity.JdData;
import jsoup.wenzhuo.mapper.JdDataMapper;
import jsoup.wenzhuo.service.JdDataService;
import org.springframework.stereotype.Service;

/**
 * 京东商品表(JdData)表服务实现类
 *
 * @author makejava
 * @since 2024-03-26 20:54:46
 */
@Service("jdDataService")
public class JdDataServiceImpl extends ServiceImpl<JdDataMapper, JdData> implements JdDataService {

}
