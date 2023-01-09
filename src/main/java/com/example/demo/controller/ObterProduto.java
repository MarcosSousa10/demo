package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.Produto;

import com.example.demo.model.repositories.RepositoryProduto;

@RequestMapping("/produtos")
@RestController
public class ObterProduto {

    @Autowired
    private RepositoryProduto repositorioProduto;

    @PostMapping
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    public @ResponseBody Produto novoproduto (Produto produto){
        repositorioProduto.save(produto);
        return(produto);
    }
    @GetMapping("/descricao/{parteDescricao}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteDescricao) {
		return repositorioProduto.findBydescricaoContainingIgnoreCase(parteDescricao);
		//return repositorioProduto.searchByNameLike(parteDescricao);
	}
	// @GetMapping(path = "/pagina/{numeroPagina}/{qtdPagina}")
	// public Iterable<Produto> obterProdutoPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdPagina){
	// 	if(qtdPagina>=5) qtdPagina = 5;
	// 	PageRequest page = PageRequest.of(numeroPagina, qtdPagina);
	// 	return produtoRepository.findAll(page);
	// }
    @GetMapping
    public Iterable<Produto> obterProduto(){
        return repositorioProduto.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Produto> obterProduto(@PathVariable int id){
         return repositorioProduto.findById(id);//.orElseThrow(()=>{
        //     new ResourceNotFoundExceorion("no records foud for thi ID!")
        // });
    }
	@DeleteMapping("/delete/{id}")
	public void excluirProduto(@PathVariable("id") int id) {
		repositorioProduto.deleteById(id);
	}

}
