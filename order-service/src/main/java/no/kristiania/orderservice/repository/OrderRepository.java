package no.kristiania.orderservice.repository;

import no.kristiania.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
