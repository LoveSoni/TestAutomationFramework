
package utilities;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class RabbitMQPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
//        ConnectionFactory factory = new ConnectionFactory();
//        // for localhost we need to set host/port/credentials
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.queueDeclare("JavaQueue1", false, false, false, null);
//        for (int i = 0; i <= 1000; i++) {
//            String message = String.valueOf(i);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            channel.basicPublish("", "JavaQueue", null, message.getBytes());
//            System.out.println("Msg sent successfully");
//        }
//        connection.close();
        int []a = {1,2,4,5};
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list.get(1));
    }
}
