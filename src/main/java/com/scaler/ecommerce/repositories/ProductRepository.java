package com.scaler.ecommerce.repositories;

import com.scaler.ecommerce.models.Product;

import com.scaler.ecommerce.projections.ProductWithTitleAndDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findAllById(Long id);
    List<Product>findByTitle(String word);
    List<Product>findByTitleContains(String str);
    List<Product>findByTitleAndDescription(String title,String Description);

    @Override
    void delete(Product entity);
    Product save (Product product); //create and update
    //HQL queuery(mix of sql+oops)
    @Query("select p.title as title,p.description as description from Product p where p.id=:id")
    ProductWithTitleAndDescription someRandomQuery(@Param("id") Long id);

    //sql queries native
    @Query(value = "select title,description  from product where id=:id",nativeQuery = true)
    ProductWithTitleAndDescription someOtherRandomQuery(@Param("id") Long id);

}
