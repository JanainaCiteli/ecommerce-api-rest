package org.serratec.backend.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.serratec.backend.model.Categoria;
import org.serratec.backend.model.Produto;

public class ProdutoInserirDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String descricao;
	
	private Integer qtd_estoque;
	
	private LocalDate data_cadastro;
	
	private Float valor_unitario;
	private Categoria categoria;

	public ProdutoInserirDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProdutoInserirDTO(Produto produto) {

		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.qtd_estoque = produto.getQtd_estoque();
		this.data_cadastro = produto.getData_cadastro();
		this.valor_unitario = produto.getValor_unitario();
		this.categoria = produto.getCategoria();
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

	public Integer getQtd_estoque() {
		return qtd_estoque;
	}

	public void setQtd_estoque(Integer qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}

	public LocalDate getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(LocalDate data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public Float getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(Float valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
