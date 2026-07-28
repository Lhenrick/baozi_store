package com.luan.baozi_store.controller;

import com.luan.baozi_store.model.Cliente;
import com.luan.baozi_store.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
     public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }
}



