package com.marcossa.mcsom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcossa.mcsom.domain.Comissoes;

@Repository
public interface ComissoesRepository extends JpaRepository<Comissoes, Integer> {

}
