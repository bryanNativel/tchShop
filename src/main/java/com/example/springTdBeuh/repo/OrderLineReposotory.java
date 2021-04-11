package com.example.springTdBeuh.repo;

import com.example.springTdBeuh.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineReposotory extends JpaRepository<OrderLine, Long> {
}
