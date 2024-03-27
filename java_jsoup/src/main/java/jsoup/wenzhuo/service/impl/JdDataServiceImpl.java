package jsoup.wenzhuo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jsoup.wenzhuo.entity.JdData;
import jsoup.wenzhuo.mapper.JdDataMapper;
import jsoup.wenzhuo.service.JdDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 京东商品表(JdData)表服务实现类
 *
 * @author makejava
 * @since 2024-03-26 20:54:46
 */
@Service("jdDataService")
public class JdDataServiceImpl extends ServiceImpl<JdDataMapper, JdData> implements JdDataService {

    @Resource
    private  JdDataMapper JDmapper;
    @Override
    public void saveJdData(JdData jdData) {
        JDmapper.insert(jdData);
    }

    @Override
    public List<JdData> selectJdData(JdData jdData) {
        List<JdData> data = JDmapper.selectList(new QueryWrapper<>(jdData));
        return data;
    }
}
