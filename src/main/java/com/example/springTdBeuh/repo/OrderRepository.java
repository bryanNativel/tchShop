package com.example.springTdBeuh.repo;

import com.example.springTdBeuh.model.OrderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderUser, Long> {
}
