package com.example.springTdBeuh.repo;

import com.example.springTdBeuh.model.OrderLine;
import com.example.springTdBeuh.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE (:serialNumber is null or p.serialNumber = :serialNumber)")
    List<Product> findCustomerSearchName(@Param("serialNumber") String serialNumber);

    @Query("SELECT p FROM Product p WHERE (:variety is null or p.listOfVariety.name = :variety)")
    List<Product> findCustomerSearchVariety(@Param("variety") String variety);

    @Query("SELECT p FROM Product p WHERE (:price is null or p.price <= :price)")
    List<Product> findCustomerSearchPrice(@Param("price") int price);

    @Query("SELECT p FROM Product p WHERE ( p.quantityInStock > 0)")
    List<Product> findCustomerSearchStock();
}
