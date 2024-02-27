package no.kristiania.orderservice.service.impl;

import lombok.AllArgsConstructor;
import no.kristiania.orderservice.dto.OrderDto;
import no.kristiania.orderservice.entity.Order;
import no.kristiania.orderservice.repository.OrderRepository;
import no.kristiania.orderservice.service.OrderService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Override
    public OrderDto placeOrder(OrderDto orderDto) {
        Order order = new Order(
                orderDto.getId(),
                orderDto.getOrderLineItems(),
                orderDto.getUserId()
        );

        Order savedOrder = orderRepository.save(order);

        OrderDto savedOrderDto = new OrderDto(
                savedOrder.getId(),
                savedOrder.getOrderLineItems(),
                savedOrder.getUserId()
        );

        return savedOrderDto;

    }
}
