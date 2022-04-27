package com.timlad.springweb.repository;

import com.timlad.springweb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p order by p.id asc")
    List<Product> findAllOrderById();

    List<Product> findAllByCoastBetween(Double minCoast, Double maxCoast);

}
