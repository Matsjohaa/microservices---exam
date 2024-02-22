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
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto){
        ProductDto savedProductDto = productService.saveProduct(productDto);

        return new ResponseEntity<>(savedProductDto, HttpStatus.CREATED);
    }

    @GetMapping

    public ResponseEntity<List<Product>> getAllProducts(){

        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long productId){
        ProductDto productDto = productService.getProduct(productId);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
}
