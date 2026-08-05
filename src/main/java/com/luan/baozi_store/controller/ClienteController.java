package com.luan.baozi_store.controller;

import com.luan.baozi_store.model.Cliente;
import com.luan.baozi_store.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
         return clienteService.saveCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        return clienteService.deleteById(id);

    }


}



