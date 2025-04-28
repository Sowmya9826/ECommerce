package com.scaler.ecommerce.controllers;

import com.scaler.ecommerce.dtos.FakeStoreProductDto;
import com.scaler.ecommerce.exception.ProductNotFoundException;
import com.scaler.ecommerce.models.Product;
import com.scaler.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

//ideally we have all the API related to only product here
@RestController //will be hosting http APIS
//localhost:8080/products
@RequestMapping("/products")

public class ProductController {
    private ProductService productService;
    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService=productService;
    }
    //localhost:8080/products/1
    @GetMapping("/{id}")

    public ResponseEntity <Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        FakeStoreProductDto[] product= productService.getProductById(id);
        ResponseEntity<Product> responseEntity = null;
        if(product==null){
            responseEntity =new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
//        responseEntity= new ResponseEntity<>(product, HttpStatus.OK);
//        return responseEntity;
//        ResponseEntity<Product> responseEntity=null;
//        try{
//            Product product=productService.getProductById(id);
//            responseEntity = new ResponseEntity<>(product,HttpStatus.OK);
//        }catch(ArithmeticException e){
//            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
     return responseEntity;
//        throw new RuntimeException("something went wrong");

    }
    //localhost:8080/products
    @GetMapping
    public List<Product> getAllProducts(){
        return  new ArrayList<>();
    }

    //createProduct
    //deleteProduct
    //updateProduct Partial update (PATCH)
    //replaceProduct Replace(PUT)
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return productService.replaceProduct(id,product);
    }
    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<Void > handleSomeException(){
        return null;
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
