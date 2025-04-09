package bionioaio.learn.Other;



import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @className: PipeDemo
 * @author: wenzhuo4657
 * @date: 2024/4/21 14:29
 * @Version: 1.0
 * @description: Pipe管道传输:其重点在于管道对象，
 * 只要是同个管道对象即可以通道pipe.sink()获取输入端写入数据，通过pipe.source();获取输出端读取数据
 */


public class PipeDemo {
    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();
        Thread1 td1=new Thread1(pipe);
        Thread2 td2=new Thread2(pipe);
        td1.start();
        td2.start();

    }
}


class  Thread1  extends Thread{
    private Pipe pipe;

    public Thread1(Pipe pipe) {
        this.pipe = pipe;
    }


    @Override
    public void run() {
        try {
            Pipe.SinkChannel sinkChannel = pipe.sink();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("hello. I'm sink.".getBytes());
            byteBuffer.flip();
            sinkChannel.write(byteBuffer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class  Thread2  extends Thread{
    private Pipe pipe;

    public Thread2(Pipe pipe) {
        this.pipe = pipe;
    }

    @Override
    public void run() {
        try {
            Pipe.SourceChannel source = pipe.source();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int len=0;
            while ((len=source.read(byteBuffer))>0){
                byteBuffer.flip();
                System.out.println(new String( byteBuffer.array(),0,len ));
                byteBuffer.clear();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

