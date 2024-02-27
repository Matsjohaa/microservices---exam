package no.kristiania.orderservice.controller;

import lombok.AllArgsConstructor;
import no.kristiania.orderservice.dto.OrderDto;
import no.kristiania.orderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> placeOrder(@RequestBody OrderDto orderDto) {
        OrderDto savedOrder = orderService.placeOrder(orderDto);
        return ResponseEntity.ok(savedOrder);
    }
}
