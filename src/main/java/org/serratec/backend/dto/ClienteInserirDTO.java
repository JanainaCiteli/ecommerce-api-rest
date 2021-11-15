package org.serratec.backend.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.serratec.backend.model.Cliente;

public class ClienteInserirDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Email
	@Size(min = 0, max = 30, message = "O Campo não pode ser maior que 30!")
	@Column(length = 30, nullable = false)	
	private String email;
	
	private String nome_usuario;
	
	private String nome_completo;
	
	private String senha;
	@CPF
	private String cpf;
	
	private String numero;
	private String complemento;
	
	private String telefone;
	@Past 
	private LocalDate data_nasc;
	private String uri;

	public ClienteInserirDTO() {

	}

	public ClienteInserirDTO(Cliente cliente) {
		super();

		this.email = cliente.getEmail();
		this.nome_usuario = cliente.getNome_usuario();
		this.nome_completo = cliente.getNome_completo();
		this.senha = cliente.getSenha();
		this.cpf = cliente.getCpf();
		this.numero = cliente.getNumero();
		this.complemento = cliente.getComplemento();
		this.telefone = cliente.getTelefone();
		this.data_nasc = cliente.getData_nasc();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(LocalDate data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	

}
