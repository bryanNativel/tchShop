package com.example.springTdBeuh.repo;

import com.example.springTdBeuh.model.Variety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarietyRepository  extends JpaRepository<Variety, Long> {
}
