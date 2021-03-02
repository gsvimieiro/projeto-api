package com.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.model.Cliente;
import com.projeto.repository.ClienteRepository;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@GetMapping("/cliente/{id}")
	public Optional<Cliente> listarClienteUnico(@PathVariable(value="id") long id) {
		return clienteRepository.findById(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/cliente")
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
