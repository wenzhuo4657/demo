package jsoup.wenzhuo.entity;


import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.transaction.TransactionDefinition;

/**
 * (Img)表实体类
 *
 * @author makejava
 * @since 2024-03-27 20:28:26
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("img")
public class Img  {
    @TableId(type = IdType.AUTO)
    private Integer id;

    //图片链接
    private String src;


    public Img(String imgSrc) {
        src=imgSrc;
    }
}
