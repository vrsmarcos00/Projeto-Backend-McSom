package com.marcossa.mcsom.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcossa.mcsom.domain.Vales;
import com.marcossa.mcsom.services.ValesService;

@RestController
@RequestMapping(value = "/vales")
public class ValeResource {
	
	@Autowired
	private ValesService service;
	
	@GetMapping
	public ResponseEntity<List<Vales>> findAll(){
		List<Vales> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Vales> findById(@PathVariable Integer id) {
		Vales obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
