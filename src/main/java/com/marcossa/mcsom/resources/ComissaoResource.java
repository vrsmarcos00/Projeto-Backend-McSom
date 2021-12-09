package com.marcossa.mcsom.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcossa.mcsom.domain.Comissoes;
import com.marcossa.mcsom.services.ComissaoService;

@RestController
@RequestMapping(value = "/comissoes")
public class ComissaoResource {
	
	@Autowired
	private ComissaoService service;
	
	@GetMapping
	public ResponseEntity<List<Comissoes>> findAll(){
		List<Comissoes> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Comissoes> findById(@PathVariable Integer id){
		Comissoes obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
