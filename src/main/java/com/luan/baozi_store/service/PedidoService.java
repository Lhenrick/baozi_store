package com.luan.baozi_store.service;

import com.luan.baozi_store.model.Cliente;
import com.luan.baozi_store.model.Pedido;
import com.luan.baozi_store.model.Produto;
import com.luan.baozi_store.repository.PedidoRepository;
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

        Cliente cliente = clienteService.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Produto produto = produtoService.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        pedido.setCliente(cliente);
        pedido.setProduto(produto);

        return pedidoRepository.save(pedido);
    }

    public boolean existsById(Long id){
        return pedidoRepository.existsById(id);
    }

    public void deleteById(Long id){
        pedidoRepository.deleteById(id);
    }

}
