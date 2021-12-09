package com.marcossa.mcsom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcossa.mcsom.domain.Vales;
import com.marcossa.mcsom.repositories.ValeRepository;
import com.marcossa.mcsom.services.exceptions.ObjectNotFoundException;

@Service
public class ValesService {
	
	@Autowired
	private ValeRepository repository;
	
	public List<Vales> findAll(){
		return repository.findAll();
	}
	
	public Vales findById(Integer id) {
		Optional<Vales> obj = repository.findById(id);
		return obj.orElseThrow((() -> new ObjectNotFoundException("Vale não encontrado. Id: " + id + "Tipo: " +Vales.class.getName())));
	}

}
