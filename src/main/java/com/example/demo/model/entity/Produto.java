package com.example.demo.model.entity;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Produto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
    @Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	@Min(0)	
	private double preco;
	//@Min(0)
	//@Max(1)

	
	
	public Produto() {
		
	}

	

	public Produto(String descricao, double preco) {
		super();
		this.descricao = descricao;
		this.preco = preco;
		
	}



	public double getPreco() {
		return preco;
	}



	public void setPreco(double preco) {
		this.preco = preco;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
