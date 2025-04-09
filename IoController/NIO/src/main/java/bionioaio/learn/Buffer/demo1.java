package bionioaio.learn.Buffer;


import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @className: buffer
 * @author: wenzhuo4657
 * @date: 2024/4/21 13:01
 * @Version: 1.0
 * @description: 子缓冲区
 */
public class demo1 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[]{0,1, 2, 3, 4, 5, 6, 7, 8, 9});
        buffer.position(4);
        buffer.limit(7);
        ByteBuffer slice = buffer.slice();//子缓冲区，和buffer共用一片空间
        slice.put(0,(byte) 30);
        System.out.println(Arrays.toString(slice.array()));

    }

}