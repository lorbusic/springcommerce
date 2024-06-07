package com.lorbusic.springcommerce.repository;

import com.lorbusic.springcommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT p FROM Product p ORDER BY p.id DESC")
    List<Product> findAllSortedById();

    @Query("SELECT p FROM Product p ORDER BY p.productName DESC")
    List<Product> findAllSortedByProductName();

    @Query("SELECT p FROM Product p ORDER BY p.productDescription DESC")
    List<Product> findAllSortedByProductDescription();

    @Query("SELECT p FROM Product p ORDER BY p.productPrice DESC")
    List<Product> findAllSortedByProductPrice();

}
