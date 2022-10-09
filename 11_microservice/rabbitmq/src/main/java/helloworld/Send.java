package helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置 RabbitMQ 地址
//        factory.setHost("192.168.159.128");
//        factory.setHost("http://119.3.15.211");
        factory.setHost("119.3.15.211");
        factory.setUsername("aki");
        factory.setPassword("root");
        //建立连接
        Connection connection = factory.newConnection();
        //获得信道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //发布消息
        String message = "Hello World!1";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        System.out.println("发送了消息：" + message);
        // 关闭连接
        channel.close();
        connection.close();
    }
}