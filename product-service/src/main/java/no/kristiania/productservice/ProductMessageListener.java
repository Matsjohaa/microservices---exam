package no.kristiania.productservice;

import lombok.AllArgsConstructor;
import no.kristiania.orderservice.entity.OrderEvent;
import no.kristiania.productservice.entity.Product;
import no.kristiania.productservice.repository.ProductRepository;
import no.kristiania.productservice.service.ProductService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductMessageListener {

    private final ProductService productService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "productQueue", durable = "true"),
            exchange = @Exchange(value = "orderExchange", type = ExchangeTypes.TOPIC),
            key = "order.placed"
    ))
    public void onOrderPlaced(OrderEvent event) {
        productService.decreaseQuantity(event.getProductId(), event.getQuantity());
    }


}