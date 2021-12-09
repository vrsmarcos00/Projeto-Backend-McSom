package com.marcossa.mcsom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcossa.mcsom.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
