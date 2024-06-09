package com.lorbusic.springcommerce.repository;

import com.lorbusic.springcommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    /*@Query(value = "SELECT distinct q.* FROM question q JOIN difficulty_level d on q.id_difficulty_level = d.id JOIN macro_category m on q.id_macro_category = m.id " +
            "JOIN question_category qc on q.id_question_category = qc.id JOIN question_type qt on q.id_question_type = qt.id " +
            "JOIN macro_category mc on q.id_macro_category = mc.id " +
            "WHERE qc.category_code = :questionCategoryCode AND d.level_code = :difficulty AND mc.macro_category_code = :macroCategory AND q.language = :language", nativeQuery = true)
    Optional<List<Product>> findByCriteria(@Param("questionCategoryCode") String questionCategory, @Param("difficulty") String difficulty,
                                           @Param("macroCategory") String macroCategory, @Param("language") String language);*/

}
