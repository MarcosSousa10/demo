package com.example.demo.model.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Produto;
@Repository
public interface RepositoryProduto extends CrudRepository <Produto, Integer> {
// public interface RepositoryProduto extends PagingAndSortingRepository<Produto, Integer>{
    public Iterable<Produto> findBydescricaoContainingIgnoreCase(String parteDescricao);

    @Query("SELECT p FROM Produto p WHERE p.descricao LIKE %:descricao%")
	public Iterable<Produto> searchByNameLike(@Param("descricao") String descricao);
}
