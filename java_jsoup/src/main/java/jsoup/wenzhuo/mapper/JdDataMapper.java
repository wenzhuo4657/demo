package jsoup.wenzhuo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jsoup.wenzhuo.entity.JdData;
import org.apache.ibatis.annotations.Mapper;


/**
 * 京东商品表(JdData)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-26 20:54:40
 */
@Mapper
public interface JdDataMapper extends BaseMapper<JdData> {

}
