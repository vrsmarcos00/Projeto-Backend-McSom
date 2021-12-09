package com.marcossa.mcsom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcossa.mcsom.domain.Vales;

@Repository
public interface ValeRepository extends JpaRepository<Vales, Integer> {

}
