package com.luan.baozi_store.service;

import com.luan.baozi_store.model.Cliente;
import com.luan.baozi_store.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public boolean existsById(Long id) {
        return clienteRepository.existsById(id);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}