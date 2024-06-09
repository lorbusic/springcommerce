package com.lorbusic.springcommerce.repository;

import com.lorbusic.springcommerce.model.Cart;
import com.lorbusic.springcommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

    @Query("SELECT c FROM Cart c ORDER BY c.id DESC")
    List<Cart> getAllVariation();
}

