package com.example.zej.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zej.model.RPP;

@Repository
public interface RPPRepo extends JpaRepository<RPP, Long> {
  
}
