package cn.wenzhuo4657.Socket.UDp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws IOException {
        //(1,指定当前主机接收/发送数据的端口
        DatagramSocket socket=new DatagramSocket(9998);
        //（2，填充数据报
        byte[] i=new byte[1024];
        DatagramPacket packet=new DatagramPacket(i,i.length);
        System.out.println("主机2等待中-----");
        socket.receive(packet);


        int length=packet.getLength();
        byte [] s=packet.getData();
        String b=new String(s,0,length);
        System.out.println("主机1:"+b);

        //(3.关闭
        socket.close();

    }
}
