package com.scaler.ecommerce.services;

import com.scaler.ecommerce.dtos.FakeStoreProductDto;
import com.scaler.ecommerce.exception.ProductNotFoundException;
import com.scaler.ecommerce.models.Category;
import com.scaler.ecommerce.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//import static jdk.javadoc.internal.tool.Main.execute;

@Service("fakestroreproductservice")

public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    private Product convertFakeStoreProductDto(FakeStoreProductDto dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage());

        Category category =new Category();
        category.setId(category.getId());
        product.setCategory(category);

        return product;
    }
    @Override
    public FakeStoreProductDto[] getProductById(Long id) {
//        RestTemplate restTemplate=new RestTemplate(); //1 template can call multiple API
//        return  new Product();
        FakeStoreProductDto[] fakeStoreProductDtos=restTemplate.getForObject("https://fakestoreapi.com/products/" + id,FakeStoreProductDto[].class);
//        if(fakeStoreProductDtos==null){
//            throw new ProductNotFoundException("Product with id" + id + "not found");
//
//        }
//        return convertFakeStoreProductDto(fakeStoreProductDtos);
        return fakeStoreProductDtos;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos=restTemplate.getForObject("https://fakestoreapi.com/products/",FakeStoreProductDto[].class);
//        concert list of fakestore product dto to list of produts
        List<Product>response =new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos){
            response.add(convertFakeStoreProductDto(fakeStoreProductDto));
        }
        return response;

    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImage());
        fakeStoreProductDto.setDescription(product.getDescription());

        RequestCallback requestCallback= restTemplate.httpEntityCallback(product,FakeStoreProductDto.class);
        HttpMessageConverterExtractor <FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor<>(FakeStoreProductDto.class,restTemplate.getMessageConverters());
        FakeStoreProductDto response= restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT,requestCallback,responseExtractor);

        return convertFakeStoreProductDto(response);
    }

    @Override
    public Product getProductsById(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
