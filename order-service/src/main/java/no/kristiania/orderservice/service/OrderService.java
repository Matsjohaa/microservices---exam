package no.kristiania.orderservice.service;

import no.kristiania.orderservice.dto.OrderDto;
import no.kristiania.orderservice.entity.Order;

public interface OrderService{
    public OrderDto placeOrder(OrderDto orderDto);
}
