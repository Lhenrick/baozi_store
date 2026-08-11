package com.luan.baozi_store.controller;

import com.luan.baozi_store.model.Pedido;
import com.luan.baozi_store.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> findAll(){
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Optional<Pedido> pedido = pedidoService.findById(id);

        if(pedido.isPresent()){
            return ResponseEntity.ok(pedido.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pedido> savePedido(@RequestBody Pedido pedido){
        Pedido pedidoSalvo = pedidoService.save(pedido);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedidoSalvo.getId()).toUri();

        return ResponseEntity.created(location).body(pedidoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if(pedidoService.existsById(id)){
            pedidoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
