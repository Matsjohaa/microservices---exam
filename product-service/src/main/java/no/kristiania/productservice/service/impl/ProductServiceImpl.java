package no.kristiania.productservice.service.impl;

import lombok.AllArgsConstructor;
import no.kristiania.productservice.dto.ProductDto;
import no.kristiania.productservice.entity.Product;
import no.kristiania.productservice.repository.ProductRepository;
import no.kristiania.productservice.service.ProductService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


@Service
@AllArgsConstructor
public class ProductServiceImpl  implements ProductService{
    private ProductRepository productRepository;



    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = new Product(
                productDto.getId(),
                productDto.getProductName(),
                productDto.getProductDescription(),
                productDto.getProductPrice(),
                productDto.getProductStock()
        );

        Product savedProduct = productRepository.save(product);

        ProductDto savedProductDto = new ProductDto(
                savedProduct.getId(),
                savedProduct.getProductName(),
                savedProduct.getProductDescription(),
                savedProduct.getProductPrice(),
                savedProduct.getProductStock()
        );


        return savedProductDto;
    }



    @Override
    public ProductDto getProduct(Long productId) {
        Product product = productRepository.findById(productId).get();

        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getProductPrice(),
                product.getProductStock()
        );

        return productDto;
    }

    @Override
    public List<Product> getAllProducts() {
        List <Product> products = productRepository.findAll();

        return products;
    }

    public void decreaseQuantity(Long productId, Integer quantity) {
        productRepository.findById(productId).ifPresentOrElse(product -> {
            product.setProductStock(product.getProductStock() - quantity);
            productRepository.save(product);
        }, () -> {
            // Log a warning or handle the case when the product is not found
            log.warn("Product with ID {} not found, cannot decrease quantity", productId);
        });
    }
}
