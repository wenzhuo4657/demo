package cn.wenzhuo4657.Socket.TCp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

class SocketClient {
     public static void main(String[] args) throws IOException {
         //（1，链接服务器的指定端口
         Socket jj=new Socket(InetAddress.getLocalHost(),9999);
         System.out.println("客户端："+jj.getClass());
         //（2，得到输出流
         OutputStream jjj= jj.getOutputStream();
         //注意：该输出流位于jj（cn.wenzhuo4657.Socket）中，所以只需向该输出流中写入数据，就可向服务器端发送
         //(3,发送数据至服务器端
         jjj.write("hello world".getBytes());


         //(4,关闭各种流
         jjj.close();
         jj.close();
         System.out.println("客户端退出-----");

     }
}
