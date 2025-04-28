package com.scaler.ecommerce;

import com.scaler.ecommerce.models.Category;
import com.scaler.ecommerce.models.Product;
import com.scaler.ecommerce.projections.ProductWithTitleAndDescription;
import com.scaler.ecommerce.repositories.CategoryRepository;
import com.scaler.ecommerce.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class FirstSpringApiApplicationTests {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Test
	void contextLoads() {
	}
	@Test
	public void testTc(){

		Optional<Category> optionalcategory=categoryRepository.findById(2L);
		Category category=optionalcategory.get();
		System.out.println("Fetching products related to above category");
		List<Product>products=category.getProducts();
		System.out.println(products.get(0).getTitle());

		ProductWithTitleAndDescription productWithTitleAndDescription= productRepository.someRandomQuery(1L);
		System.out.println(ProductWithTitleAndDescription.getTitle());
		System.out.println(ProductWithTitleAndDescription.getDescription());

		ProductWithTitleAndDescription product =productRepository.someOtherRandomQuery(2L);
		System.out.println(ProductWithTitleAndDescription.getTitle());
		System.out.println(ProductWithTitleAndDescription.getDescription());
		System.out.println("Debug");
	}
}
