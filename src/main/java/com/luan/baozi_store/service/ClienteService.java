package com.luan.baozi_store.service;

import com.luan.baozi_store.model.Cliente;
import com.luan.baozi_store.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }


    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){

            return ResponseEntity.ok(cliente.get());

        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
        Cliente clienteSalvo = clienteRepository.save(cliente);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clienteSalvo.getId()).toUri();

        return ResponseEntity.created(location).body(clienteSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }

}
