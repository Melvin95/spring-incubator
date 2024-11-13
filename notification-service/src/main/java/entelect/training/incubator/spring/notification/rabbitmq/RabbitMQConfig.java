package entelect.training.incubator.spring.notification.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

   @Bean public Queue queue(){
       return new Queue("sms-notification-queue",false);
   }

   @Bean public Exchange exchange(){
       return new DirectExchange("notification-exchange", false, false);
   }

   @Bean Binding binding(Queue queue, Exchange exchange){
       return BindingBuilder.bind(queue)
               .to(exchange)
               .with("sms-key")
               .noargs();
   }
}
