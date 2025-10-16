package com.generation.caronaBack.controller;

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

import com.generation.caronaBack.model.Viagem;
import com.generation.caronaBack.repository.ViagemRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/viagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ViagemController {

	@Autowired
	private ViagemRepository viagemRepository;

	@GetMapping
	public ResponseEntity<List<Viagem>> getall() {
		return ResponseEntity.ok(viagemRepository.findAll());
		// Select*from td_postagens
	}

	@GetMapping("/{id}")
	public ResponseEntity<Viagem> getByid(@PathVariable Long id) {
		return viagemRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/origem/{origem}")
	public ResponseEntity<List<Viagem>> getAllByOrigem(@PathVariable String titulo) {
		return ResponseEntity.ok(viagemRepository.findAllByOrigemContainingIgnoreCase(titulo));
		// Select*from td_postagens
	}

	@GetMapping("/destino/{destino}")
	public ResponseEntity<List<Viagem>> getAllByDestino(@PathVariable String titulo) {
		return ResponseEntity.ok(viagemRepository.findAllByDestinoContainingIgnoreCase(titulo));
		// Select*from td_postagens
	}

	@PostMapping
	public ResponseEntity<Viagem> post(@Valid @RequestBody Viagem Viagem) {

		Viagem.setId(null);
		return ResponseEntity.status(HttpStatus.CREATED).body(viagemRepository.save(Viagem));
	}

	// Método para atualizar uma Viagem existente
	@PutMapping
	public ResponseEntity<Viagem> put(@Valid @RequestBody Viagem Viagem) {

		if (viagemRepository.existsById(Viagem.getId())) {

			return ResponseEntity.status(HttpStatus.OK).body(viagemRepository.save(Viagem));

		}

		return ResponseEntity.notFound().build();

	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Viagem> Viagem = viagemRepository.findById(id);
		if (Viagem.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		viagemRepository.deleteById(id);

	}
}
