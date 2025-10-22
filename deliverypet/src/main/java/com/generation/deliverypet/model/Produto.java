package com.generation.deliverypet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 255)
	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min = 4, message = "O atributo nome deve conter no mínimo 4 caracteres")
	private String nome;
	
	@Column(length = 255)
	@NotBlank(message = "O atributo descrição é obrigatório!")
	@Size(min = 3, message = "O atributo descrição deve conter no mínimo 3 caracteres")
	private String descricao;
	
	@NotBlank(message = "O atributo preço é obrigatório!")
	private Double preco;
	
	@Column(length = 255)
	@NotBlank(message = "O atributo foto é obrigatório!")
	@Size(min = 3, message = "O atributo foto deve conter no mínimo 3 caracteres")
	private String foto;
	
	@NotBlank(message = "O atributo quantidade é obrigatório!")
	private int quantidade;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
