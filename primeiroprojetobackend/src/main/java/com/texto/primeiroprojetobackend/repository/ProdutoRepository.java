package com.texto.primeiroprojetobackend.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.texto.primeiroprojetobackend.model.Produto;
import com.texto.primeiroprojetobackend.model.exception.ResourceNotFoundException;

@Repository
public class ProdutoRepository {
    
    private List<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;
    /**
     * Metodo que retorna uma lista de produtos.
     * @return Lista de Produtos
     */
    public List<Produto> obterTodos(){

        return produtos;

    }

    /**
     * Metodo que retorna um produto por id.
     * @param id do produto que sera localizado.
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id){
    
        return 
        produtos.stream()
        .filter(p -> p.getId() == id).findFirst();

    }
    /**
     * Metodo para adicionar o produto na lista.
     * @param produto que vai ser adicionado.
     * @return produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){

        ultimoId ++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;

    }
    /**
     * Metodo para deletar o produto por id.
     * @param id do produto que vai ser deletado.
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);

    }


    /**
     * Metodo para atualizar o produto na lista.
     * @param produto que sera atualizado.
     * @return produto que foi atualizado.
     */
    public Produto atualizar(Produto produto){
        // Eu tenho que encontrar o produto na lista
        Optional<Produto>  produtoEncontrado = obterPorId(produto.getId());
        if(produtoEncontrado.isEmpty()){
            throw new ResourceNotFoundException("Produto não pode ser atualizado por que não existe");
        }

        //eu tenho que deletar o produto antigo da lista          
        deletar(produto.getId());    

        //adcionar o novo produto no mesmo id mas pode chamar o metodo adcionar por que 
        //dessa forma adiciona ++ na variavel ultimoId.

        produtos.add(produto);

        return produto;

    }

}
