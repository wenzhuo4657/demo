package jsoup.wenzhuo.entity;

import java.util.Date;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 京东商品表(JdData)表实体类
 *
 * @author makejava
 * @since 2024-03-26 20:54:41
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("jd_data")
public class JdData  {
    //主键@TableId
    @TableId(type = IdType.AUTO)
    private Long id;

    //商品集合id
    private Long spu;
    //商品最小品类单元id
    private Long sku;
    //商品标题
    private String title;
    //商品价格
    private String price;
    //商品图片
    private String pic;
    //商品详情地址
    private String url;
    //创建时间
    private Date created;
    //更新时间
    private Date updated;
    
}
