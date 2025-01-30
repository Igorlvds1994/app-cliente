package br.com.vdr.app_cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import br.com.vdr.app_cliente.model.Cliente;
import br.com.vdr.app_cliente.service.ClienteService;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    // Lista todos os clientes
    @GetMapping("/clientes")
    public String listarclientes(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "clientes";  // Retorna a página com a lista de clientes
    }
    
    // Exibe os detalhes de um cliente específico
    @GetMapping("/cliente/{id}")
    public String exibirCliente(@PathVariable("id") Long id, Model model) {
    	
    	Cliente cliente = clienteService.findbyId(id);
    	if(cliente == null) {
    		return "redirect:/clientes";
    	}
    	model.addAttribute("cliente", cliente);
    	return "detalhes_clientes";
    	
    }
    // Exibe o formulário para criar um novo cliente
    @GetMapping("/cliente/novo")
    public String exibirFormularioNovoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());  // Passa um novo objeto Cliente
        return "form_cliente";  // Retorna o formulário para criação
    }

    // Salva um cliente novo ou atualizado
    @PostMapping("/cliente/salvar")
    public String salvarCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";  // Redireciona para a lista de clientes
    }
    
    // Exibe o formulário de edição de um cliente
    @GetMapping("/cliente/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.findbyId(id));
        return "form_cliente";  // Retorna o formulário de edição
    }

    // Deleta um cliente
    @GetMapping("/cliente/deletar/{id}")
    public String deletarCliente(@PathVariable("id") Long id) {
        clienteService.delete(id);
        return "redirect:/clientes";  // Redireciona para a lista de clientes após a exclusão
    }
}
