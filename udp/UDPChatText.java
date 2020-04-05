package cn.tedu.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

import java.net.SocketException;
import java.util.Scanner;

public class UDPChatText {
    public static void main(String[] args) {
        //开启线程
        new Thread(new Sender()).start();
        new Thread(new Receiver()).start();
    }
}



//代表发送端的类---线程
class Sender implements Runnable{
    //声明对象
    DatagramSocket ds;
    Scanner s;
    @Override
    public void run() {
        try {
            ds=new DatagramSocket();
            s=new Scanner(System.in);
            //实现能一直发送数据
            while (true){
                //要发送数据
               byte[] bs =s.next().getBytes();
               //创建数据包---指明往哪发送数据
                DatagramPacket dp=new DatagramPacket
                        (bs,bs.length, new InetSocketAddress
                                        ("255.255.255.255",8001));

                //发送数据包
                ds.send(dp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//代表接收端的类---线程
class Receiver implements Runnable{
    //声明对象
    DatagramSocket ds;
    DatagramPacket dp;
    @Override
    public void run() {
        try {
            ds=new DatagramSocket(8001);
            //创建数据
            dp=new DatagramPacket(new byte[1024],1024);
            //
            while (true){
               //接受数据
                ds.receive(dp);
                //解析数包
                System.out.println(dp.getAddress());
                System.out.println
                        (new String(dp.getData(),0,dp.getLength()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}