package com.scaler.ecommerce.services;

import com.scaler.ecommerce.dtos.FakeStoreProductDto;
import com.scaler.ecommerce.exception.ProductNotFoundException;
import com.scaler.ecommerce.models.Product;

import java.util.List;

public interface ProductService {
    FakeStoreProductDto[] getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product replaceProduct(Long id,Product product);
    Product getProductsById(Long id) throws ProductNotFoundException;
    Product updateProduct(Long id,Product product);
    Product createProduct(Product product);
    void deleteProduct();
}
