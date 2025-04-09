package cn.wenzhuo4657.Socket.UDp;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        //(1,指定当前主机向外传输/接收数据的端口，
        DatagramSocket  socket=new DatagramSocket(9999);
       //(2.填充数据报
        byte [] i="hello ,吃了吗》---".getBytes();

        DatagramPacket packet =new DatagramPacket(i,i.length,InetAddress.getLocalHost(),9998);
        System.out.println("主机1等待中----");
        socket.send(packet);
        System.out.println("成功");


        socket.close();

    }
}
