package com.scaler.ecommerce.services;

import com.scaler.ecommerce.dtos.FakeStoreProductDto;
import com.scaler.ecommerce.exception.ProductNotFoundException;
import com.scaler.ecommerce.models.Category;
import com.scaler.ecommerce.models.Product;
import com.scaler.ecommerce.repositories.CategoryRepository;
import com.scaler.ecommerce.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfproductservice")
@Primary
public class SelfProductService implements ProductService{
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public FakeStoreProductDto[] getProductById(Long id) throws ProductNotFoundException {
        //Fectch product with given id in databse

        Optional<Product> optionalProduct= productRepository.findAllById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(id,"product not found");
        }
        return optionalProduct.get();

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product replaceProduct(  Long id, Product product) {
        return null;
    }

    @Override
    public Product getProductsById(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
public Product createProduct(Product product) {
    Category category = product.getCategory();
    if ( category.getId() == null) {
        Category savedCategory = categoryRepository.save(category);
        product.setCategory(savedCategory);
    }else{
        //we should check if cataogeory id is valid or not
    }
    Product savedProduct= productRepository.save(product);
    Optional<Category> optionalCategory=categoryRepository.findById(savedProduct.getCategory().getId());
    Category category1=optionalCategory.get();
    savedProduct.setCategory(category1);
    return savedProduct;
}

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
