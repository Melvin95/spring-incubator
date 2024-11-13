package entelect.training.incubator.spring.notification.rabbitmq;

import com.google.gson.Gson;
import entelect.training.incubator.spring.notification.sms.client.SmsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    private final SmsClient smsClient;
    private final Logger LOG = LoggerFactory.getLogger(RabbitMQConsumer.class);

    public RabbitMQConsumer(SmsClient smsClient) {
        this.smsClient = smsClient;
    }

    @RabbitListener(queues = "sms-notification-queue")
    public void receiveMessage(String message){
        LOG.info("Received message: [{}] !!!!", message);
        SmsQueueMessage smsQueueMessage = new Gson().fromJson(message, SmsQueueMessage.class);
        smsClient.sendSms(smsQueueMessage.getPhoneNumber(), smsQueueMessage.getMessage());
    }
}
