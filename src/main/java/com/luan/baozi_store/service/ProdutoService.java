package com.luan.baozi_store.service;

import com.luan.baozi_store.model.Produto;
import com.luan.baozi_store.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id){
        return produtoRepository.findById(id);
    }

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    public boolean existsById(Long id){
        return produtoRepository.existsById(id);
    }

    public void deleteById(Long id){
        produtoRepository.deleteById(id);
    }

}
