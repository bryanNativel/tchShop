package com.example.springTdBeuh.repo;

import com.example.springTdBeuh.model.OrderLine;
import com.example.springTdBeuh.model.OrderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

    @Query(value = " select oi from OrderLine oi JOIN oi.orderUser oe where oe.dateOrder BETWEEN :startDate AND :endDate")
    List<OrderLine> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
