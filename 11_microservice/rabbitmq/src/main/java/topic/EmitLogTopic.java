package topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class EmitLogTopic {

    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) {
        Connection connection = null;
        Channel channel = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("192.168.159.128");
            factory.setUsername("root");
            factory.setPassword("root");

            connection = factory.newConnection();
            channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

            String message = "Animal World";

            String[] routingKeys = new String[9];
            routingKeys[0] = "quick.orange.rabbit";
            routingKeys[1] = "lazy.orange.elephant";
            routingKeys[2] = "quick.orange.fox";
            routingKeys[3] = "lazy.brown.fox";
            routingKeys[4] = "lazy.pink.rabbit";
            routingKeys[5] = "quick.brown.fox";
            routingKeys[6] = "orange";
            routingKeys[7] = "quick.orange.male.rabbit";
            routingKeys[8] = "lazy.orange.male.rabbit";
            for (int i = 0; i < routingKeys.length; i++) {
                channel.basicPublish(EXCHANGE_NAME, routingKeys[i], null,
                        message.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + routingKeys[i] + "':'" + message + "'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception ignore) {
                }
            }
        }
    }
}

