package com.example.demo.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.entity.Usuario;

public interface Repository extends PagingAndSortingRepository<Usuario,Integer>{

    public Iterable<Usuario> findBynomeContainingIgnoreCase(String parteNome);

    @Query("SELECT p FROM Usuario p WHERE p.nome LIKE %:nome%")
	public Iterable<Usuario> searchByNameLike(@Param("nome") String nome);
}
