package com.generation.ladydrive.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.ladydrive.model.Viagem;
import com.generation.ladydrive.repository.ViagemRepository;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/viagens") 
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ViagemController  {
	
	@Autowired
	private ViagemRepository viagemRepository;

	@GetMapping
	public ResponseEntity<List<Viagem>> getAll() {
		return ResponseEntity.ok(viagemRepository.findAll());

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Viagem> getById(@PathVariable Long id){
		return viagemRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/destino/{destino}")
	public ResponseEntity<List<Viagem>> getByTitle(@PathVariable String destino) {
		return ResponseEntity.ok(viagemRepository
				.findAllByDestinoContainingIgnoreCase(destino));
	}
	

	@PostMapping
	public ResponseEntity<Viagem> post(@Valid @RequestBody Viagem viagem){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(viagemRepository.save(viagem));
	}
	
	@PutMapping
	public ResponseEntity<Viagem> put(@Valid @RequestBody Viagem tema){
		return viagemRepository.findById(tema.getId())
	            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
	            .body(viagemRepository.save(tema)))
	            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		Optional<Viagem> tema = viagemRepository.findById(id);
		
		if(tema.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		viagemRepository.deleteById(id);
	}
}