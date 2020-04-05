package cn.tedu.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPSender {
    public static void main(String[] args) throws IOException {
        //创建发送端对象
        DatagramSocket ds=new DatagramSocket();
        //创建发送包对象
        //byte[]---要发送的数据
        //length---发送数据的长度
        //SocketAddress---需要填入IP地址和端口号
        DatagramPacket dp=new DatagramPacket
                ("你好哇！".getBytes(),
                        "你好哇！".getBytes().length,
                        new InetSocketAddress
                                ("127.0.0.1",8099));
        //发送数据包
        ds.send(dp);

        //关流
        ds.close();
    }
}
