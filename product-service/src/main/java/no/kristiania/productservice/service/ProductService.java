package no.kristiania.productservice.service;

import no.kristiania.productservice.dto.ProductDto;
import no.kristiania.productservice.entity.Product;

import java.util.List;

public interface ProductService {
    public ProductDto saveProduct(ProductDto productDto);

    ProductDto getProduct(Long productId);

    List<Product> getAllProducts();

    void decreaseQuantity(Long productId, Integer quantity);
}
