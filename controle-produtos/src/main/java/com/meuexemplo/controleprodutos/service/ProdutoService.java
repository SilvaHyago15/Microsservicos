package com.meuexemplo.controleprodutos.service;

import java.util.List;
import java.util.Optional;

import com.meuexemplo.controleprodutos.compartilhado.ProdutoDto;

public interface ProdutoService {
    ProdutoDto criarProduto(ProdutoDto Produto);
    List<ProdutoDto> obterTodos();
    Optional<ProdutoDto> obterPorId(Integer id);
    void removerProduto(Integer id);
    ProdutoDto atualizarProduto(Integer id, ProdutoDto pessoa);
}
