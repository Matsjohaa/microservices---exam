package no.kristiania.productservice.controller;

import lombok.AllArgsConstructor;
import no.kristiania.productservice.dto.ProductDto;
import no.kristiania.productservice.entity.Product;
import no.kristiania.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;


    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDto productDto){
        ProductDto savedProductDto = productService.saveProduct(productDto);

        return new ResponseEntity<>(savedProductDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId){
        return null;
    }
}
