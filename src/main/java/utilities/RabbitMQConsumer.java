
package utilities;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("JavaQueue", false, false, false, null);
        channel.basicConsume("JavaQueue", true, (s, delivery) -> {
                    String msg = new String(delivery.getBody(), "UTF-8");
                    System.out.println("Received msg - + { " + msg + " }");
                }
                , (consumerTag) -> {
                });
    }

}
