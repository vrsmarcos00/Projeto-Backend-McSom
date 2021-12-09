package com.marcossa.mcsom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcossa.mcsom.domain.Funcionario;
import com.marcossa.mcsom.repositories.FuncionarioRepository;
import com.marcossa.mcsom.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repository;
	
	public List<Funcionario> findAll(){
		return repository.findAll();
	}
	
	public Funcionario findById(Integer id) {
		Optional<Funcionario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Funcionário não encontrado. Id: " + id + ". Tipo: " + Funcionario.class.getName()));
	}

}
