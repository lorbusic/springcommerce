package com.lorbusic.springcommerce.repository;

import com.lorbusic.springcommerce.model.Product;
import com.lorbusic.springcommerce.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    @Query("SELECT u FROM User u ORDER BY u.id DESC")
    List<User> getAllUsersByIdSorted();

}
