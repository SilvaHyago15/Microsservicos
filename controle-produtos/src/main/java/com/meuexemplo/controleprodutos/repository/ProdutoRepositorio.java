package com.meuexemplo.controleprodutos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meuexemplo.controleprodutos.model.Produtos;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produtos, Integer> {
    
    Optional<Produtos> findById(Integer id);
}