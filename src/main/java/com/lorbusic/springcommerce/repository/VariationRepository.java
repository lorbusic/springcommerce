package com.lorbusic.springcommerce.repository;


import com.lorbusic.springcommerce.model.Variation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariationRepository extends JpaRepository<Variation,Long> {

    @Query("SELECT v FROM Variation v ORDER BY v.id")
    List<Variation> findAllVariationBySortedId();
}
