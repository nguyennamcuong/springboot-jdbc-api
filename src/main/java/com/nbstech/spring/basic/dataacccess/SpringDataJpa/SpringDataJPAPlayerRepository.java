package com.nbstech.spring.basic.dataacccess.SpringDataJpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJPAPlayerRepository extends JpaRepository<PlayerEntity,Integer> {
    // Parse to JPQL
    public List<PlayerEntity> findByNationality(String nationality);
}
