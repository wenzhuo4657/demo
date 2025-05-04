package jsoup.wenzhuo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jsoup.wenzhuo.entity.Img;
import jsoup.wenzhuo.mapper.ImgMapper;
import jsoup.wenzhuo.service.ImgService;
import org.springframework.stereotype.Service;

/**
 * (Img)表服务实现类
 *
 * @author makejava
 * @since 2024-03-27 20:28:26
 */
@Service("imgService")
public class ImgServiceImpl extends ServiceImpl<ImgMapper, Img> implements ImgService {

}
