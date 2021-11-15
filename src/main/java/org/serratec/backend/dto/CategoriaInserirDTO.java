package org.serratec.backend.dto;

import java.io.Serializable;

import org.serratec.backend.model.Categoria;

public class CategoriaInserirDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String descricao;

	public CategoriaInserirDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoriaInserirDTO(Categoria categoria) {
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
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
	
	
	

}
