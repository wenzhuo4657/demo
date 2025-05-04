package jsoup.wenzhuo;

/**
 * @className: StringUtils
 * @author: wenzhuo4657
 * @date: 2024/3/27 21:02
 * @Version: 1.0
 * @description:
 */
public class StringUtils {
    public static boolean isEmpty(String str) {
        if (null ==str||"".equals(str)||"null".equals(str)||"\u0000".equals(str)){
            return  true;
        }else if("".equals(str.trim())){
            return  true;
        }else{
            return  false;
        }
    }

}