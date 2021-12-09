package com.marcossa.mcsom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcossa.mcsom.domain.Comissoes;
import com.marcossa.mcsom.repositories.ComissoesRepository;
import com.marcossa.mcsom.services.exceptions.ObjectNotFoundException;

@Service
public class ComissaoService {
	
	@Autowired
	private ComissoesRepository repository;
	
	public List<Comissoes> findAll(){
		return repository .findAll();
	}
	
	public Comissoes findById(Integer id) {
		Optional<Comissoes> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Comissão não encontrada. Id: " + id + ".Tipo: " +Comissoes.class.getName()));
	}

}
