package cn.wenzhuo4657.leetcode;

/**
 * @author: wenzhuo4657
 * @date: 2025/1/1
 * @description:
 */
public class leetcode3280 {



    public String convertDateToBinary(String date) {
        String year = date.substring(0, 4);
        String mouth = date.substring(5, 7);
        String day = date.substring(8, 10);
        return  toBinary(year)+"-"+toBinary(mouth)+"-"+toBinary(day);
    }

    private String toBinary(String day) {

        StringBuffer buffer=new StringBuffer();
        for (Integer i=Integer.valueOf(day);i!=0; i >>= 1){
            i|= 1;
            buffer.append(i&1);//拿到最低位，最终循环结束得到一个颠倒的字符串
        }
        return buffer.reverse().toString();

    }
}
