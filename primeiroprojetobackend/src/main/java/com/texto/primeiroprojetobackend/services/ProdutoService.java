package com.texto.primeiroprojetobackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texto.primeiroprojetobackend.model.Produto;
import com.texto.primeiroprojetobackend.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Metodo que retorna uma lista de produtos.
     * @return Lista de Produtos
     */
    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
    }

    /**
     * Metodo que retorna um produto por id.
     * @param id do produto que sera localizado.
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id){
    
        return produtoRepository.obterPorId(id);
    }
    /**
     * Metodo para adicionar o produto na lista.
     * @param produto que vai ser adicionado.
     * @return produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){
        return produtoRepository.adicionar(produto);

    }
    /**
     * Metodo para deletar o produto por id.
     * @param id do produto que vai ser deletado.
     */
    public void deletar(Integer id){
        produtoRepository.deletar(id);
    }


    /**
     * Metodo para atualizar o produto na lista.
     * @param produto que sera atualizado.
     * @param id do produto que sera atualizado.
     * @return produto que foi atualizado.
     */
    public Produto atualizar(Integer id,Produto produto){
        produto.setId(id);
        return produtoRepository.atualizar(produto);

    }
}
