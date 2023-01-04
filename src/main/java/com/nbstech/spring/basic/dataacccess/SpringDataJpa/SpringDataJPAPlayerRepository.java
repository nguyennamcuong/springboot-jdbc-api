package com.nbstech.spring.basic.dataacccess.SpringDataJpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAPlayerRepository extends JpaRepository<PlayerEntity,Integer> {
}
