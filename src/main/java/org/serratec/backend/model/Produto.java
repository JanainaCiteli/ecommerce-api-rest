package org.serratec.backend.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	private String nome;
	private String descricao;
	private Integer qtd_estoque;
	private LocalDate data_cadastro;
	private Float valor_unitario;
	
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;	

	@OneToOne(mappedBy = "produto")
	private Foto foto;	
	
	
public Produto() {
	// TODO Auto-generated constructor stub
}

	
	public Produto(Long id, String nome, String descricao, Integer qtd_estoque, LocalDate data_cadastro,
		Float valor_unitario, Categoria categoria, Foto foto) {
	super();
	this.id = id;
	this.nome = nome;
	this.descricao = descricao;
	this.qtd_estoque = qtd_estoque;
	this.data_cadastro = data_cadastro;
	this.valor_unitario = valor_unitario;
	this.categoria = categoria;
	this.foto = foto;
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

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

}
