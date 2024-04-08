package org.buildproduct.buildproductecom.controllers;

import lombok.Setter;
import org.buildproduct.buildproductecom.Services.ProductService;
import org.buildproduct.buildproductecom.dtos.FakeStoreProductDto;
import org.buildproduct.buildproductecom.models.products;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //allows us to do spring dependency system
public class ProductController {
    private ProductService productService ;

    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<products> getAllProducts(){
        return productService.getAllProduct();


    }
    @GetMapping("/products/{id}")
    public products getSingleProduct(@PathVariable("id") Long iD){
        return productService.getSingleProduct(iD);
    }
    @PostMapping("/products")
    public products createProduct(@RequestBody products product){
        return productService.createProduct(product);
    }
    @PutMapping("/product/{id}")
    public products updateProduct(@RequestBody products product){
        return productService.updateProduct(product);
    }
    @DeleteMapping("/product/{id}")
    public products deleteProduct(@PathVariable("id") Long id ){
        return productService.deleteProducts(id);
    }

}
