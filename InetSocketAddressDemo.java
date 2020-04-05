package cn.tedu.net.address;

import java.net.InetSocketAddress;

public class InetSocketAddressDemo {
    public static void main(String[] args) {
        //创建代表IP地址和端口的类的对象



        
        InetSocketAddress inetSocketAddress=new InetSocketAddress
                ("localhost",8090);
        //localhost映射成的IP地址127.0.0.1
        //127.0.0.1永远指向本地
        //返回IP地址、主机名（计算机名称）、端口号
        System.out.println(inetSocketAddress.getAddress());
        System.out.println(inetSocketAddress.getHostName());
        System.out.println(inetSocketAddress.getPort());
    }
}
