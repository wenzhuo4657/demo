package bionioaio.learn.Buffer;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @className: demo2
 * @author: wenzhuo4657
 * @date: 2024/4/21 13:24
 * @Version: 1.0
 * @description: 只读缓冲区
 */
public class demo2 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[]{0,1, 2, 3, 4, 5, 6, 7, 8, 9});
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        buffer.put(0,(byte) 30);
//        readOnlyBuffer.array():查看源码可知，只读缓冲区不能使用array，但可以使用get方法
        while (readOnlyBuffer.hasRemaining()){
            System.out.print(readOnlyBuffer.get()+"\t");
        }
    }
}