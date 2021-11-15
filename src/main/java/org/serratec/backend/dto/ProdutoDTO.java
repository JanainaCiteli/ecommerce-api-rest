package org.serratec.backend.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.serratec.backend.model.Categoria;
import org.serratec.backend.model.Produto;

public class ProdutoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank
	@Column(length = 40, nullable = false)
	private String nome;
	@NotBlank
	@Column(length = 100, nullable = false)
	private String descricao;
	@NotNull
	@PositiveOrZero
	private Integer qtd_estoque;
	@NotNull
	@PastOrPresent
	private LocalDate data_cadastro;
	@NotNull
	@Positive
	private Float valor_unitario;
	private Categoria categoria;
	private String uri;

	public ProdutoDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProdutoDTO(Produto produto) {

		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.qtd_estoque = produto.getQtd_estoque();
		this.data_cadastro = produto.getData_cadastro();
		this.valor_unitario = produto.getValor_unitario();
		this.categoria = produto.getCategoria();
	}

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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	

}
