package com.meuexemplo.controleprodutos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.meuexemplo.controleprodutos.compartilhado.ProdutoDto;
import com.meuexemplo.controleprodutos.model.Produtos;
import com.meuexemplo.controleprodutos.repository.ProdutoRepositorio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepositorio repo;

    @Override
    public ProdutoDto criarProduto(ProdutoDto produto) {
        return salvarProduto(produto);
    }

    @Override
    public List<ProdutoDto> obterTodos() {
        List<Produtos> produtos = repo.findAll();

        return produtos.stream()
                .map(produto -> new ModelMapper().map(produto, ProdutoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProdutoDto> obterPorId(Integer id) {
        Optional<Produtos> produtos = repo.findById(id);

        if (produtos.isPresent()) {
            return Optional.of(new ModelMapper().map(produtos.get(), ProdutoDto.class));
        }

        return Optional.empty();
    }

    @Override
    public void removerProduto(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public ProdutoDto atualizarProduto(Integer id, ProdutoDto produto) {
        produto.setId(id);
        return salvarProduto(produto);
    }

    private ProdutoDto salvarProduto(ProdutoDto produto) {
        ModelMapper mapper = new ModelMapper();
        Produtos produtoEntidade = mapper.map(produto, Produtos.class);
        produtoEntidade = repo.save(produtoEntidade);

        return mapper.map(produtoEntidade, ProdutoDto.class);
    }
}