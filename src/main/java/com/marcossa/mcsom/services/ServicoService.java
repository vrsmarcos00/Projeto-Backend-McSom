package com.marcossa.mcsom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcossa.mcsom.domain.Servico;
import com.marcossa.mcsom.repositories.ServicoRepository;
import com.marcossa.mcsom.services.exceptions.ObjectNotFoundException;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository repository;
	
	public List<Servico> findAll(){
		return repository.findAll();
	}
	
	public Servico findById(Integer id) {
		Optional<Servico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Serviço não encontrado. Id: " + id + ".Tipo: " + Servico.class.getName()));
	}

}
