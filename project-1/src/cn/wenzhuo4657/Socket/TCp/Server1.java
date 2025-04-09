package cn.wenzhuo4657.Socket.TCp;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

class SocketS {


    public static void main(String[] args) throws IOException {
        System.out.println("Server");
        //(1,监听主机的9999端口
        ServerSocket Ser=new ServerSocket(9999);
        System.out.println("监听中-----");
        Socket jj=Ser.accept();//注意：该方法会阻塞程序，直至获取到Socket对象
        System.out.println("监听成功；"+jj.getClass());



        //(2,得到输入流
        InputStream Serv= jj.getInputStream();

        //(3.读数据
        byte[] in=new byte[1024];//存储每次读取的数据
        int  reline=0;//读取数据的字节数，具体参考方法
        while ((reline=Serv.read(in))!=-1){
            System.out.print(new String(in,0,reline));
        }

        //(4,关闭各种流
        //注意：相较于客户端，服务器端需要多关一个监听套接字对象
        //说明：
        /*
        ServerSocket 对象在处理完客户端连接后，也需要调用 close() 方法来关闭。
        这是因为 ServerSocket 对象在监听指定端口上的连接请求时会占用系统资源，包括该端口和相关的网络资源。
        当你调用 close() 方法关闭 ServerSocket 对象时，它会释放这些占用的资源，并将该端口释放给系统供其他程序使用。
        这可以避免资源泄漏和端口占用的问题。
        */
        Serv.close();
        jj.close();
        Ser.close();

    }
}
