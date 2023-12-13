package no.kristiania.productservice.service.impl;

import lombok.AllArgsConstructor;
import no.kristiania.productservice.dto.ProductDto;
import no.kristiania.productservice.repository.ProductRepository;
import no.kristiania.productservice.service.ProductService;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductServiceImpl  implements ProductService{
    private ProductRepository productRepository;

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        return null;
    }
}
