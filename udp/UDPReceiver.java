package cn.tedu.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        //创建接收端的对象
        //指明发送端的端口号---监听端口号---就能获取通过这个端口号发送数据
        DatagramSocket ds=new DatagramSocket(8099);
        //创建数据包---接受发送端发送的数据
        //byte[]---指代就是以多大的字节数组来接受数据
        //length---表面的是字节数组真正能接受的数据大小
        DatagramPacket dp=new DatagramPacket(new byte[1024],1024);
        //根据数据包进行接受数据
        ds.receive(dp);
        //关流
        ds.close();
        //解析数据包
        System.out.println(dp.getAddress());
        //接受的数据
        byte[] bs=dp.getData();
        System.out.println(new String(bs,0,dp.getLength()));
    }
}
