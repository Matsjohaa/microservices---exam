package no.kristiania.productservice.service.impl;

import lombok.AllArgsConstructor;
import no.kristiania.productservice.dto.ProductDto;
import no.kristiania.productservice.entity.Product;
import no.kristiania.productservice.repository.ProductRepository;
import no.kristiania.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductServiceImpl  implements ProductService{
    private ProductRepository productRepository;

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
}
