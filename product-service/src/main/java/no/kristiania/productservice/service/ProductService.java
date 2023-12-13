package no.kristiania.productservice.service;

import no.kristiania.productservice.dto.ProductDto;

public interface ProductService {
    public ProductDto saveProduct(ProductDto productDto);
}
