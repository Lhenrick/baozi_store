package com.luan.baozi_store.service;

import com.luan.baozi_store.model.Cliente;
import com.luan.baozi_store.model.Pedido;
import com.luan.baozi_store.repository.ClienteRepository;
import com.luan.baozi_store.repository.PedidoRepository;
import com.luan.baozi_store.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public PedidoService(ClienteService clienteService, ProdutoService produtoService, PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Long id){
        return pedidoRepository.findById(id);
    }

    public Pedido save(Pedido pedido) {
        Long clienteId = pedido.getCliente().getId();
        Long produtoId = pedido.getProduto().getId();


        if(clienteService.existsById(clienteId) && produtoService.existsById(produtoId)){

            return pedidoRepository.save(pedido);
        }

        throw new RuntimeException("Cliente ou pedido não encontrado");
    }



}
