package no.kristiania.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long productId;
    private Integer quantity;
}
