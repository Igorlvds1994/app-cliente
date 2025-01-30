package br.com.vdr.app_cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vdr.app_cliente.model.Cliente;
import br.com.vdr.app_cliente.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	public Cliente findbyId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

}
