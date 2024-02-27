package no.kristiania.orderservice;


import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EventPublisher {


    private RabbitTemplate rabbitTemplate;

    public void publishOrderEvent(OrderEvent orderEvent, String routingKey) {
        rabbitTemplate.convertAndSend("orderExchange", routingKey, orderEvent);
    }
}
