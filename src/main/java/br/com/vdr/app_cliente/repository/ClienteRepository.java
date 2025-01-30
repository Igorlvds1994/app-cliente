package br.com.vdr.app_cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vdr.app_cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
