package org.serratec.backend.dto;

import java.io.Serializable;

import org.serratec.backend.model.ItemPedido;
import org.serratec.backend.model.Pedido;
import org.serratec.backend.model.Produto;

public class ItemPedidoInserirDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private Integer quantidade;
	private Float preco_venda;
	private Pedido pedido;
	private Produto produto;
	
	public ItemPedidoInserirDTO() {
		
	}

	public ItemPedidoInserirDTO(ItemPedido itemPedido) {
		super();
		this.quantidade = itemPedido.getQuantidade();
		this.preco_venda = itemPedido.getPreco_venda();
		this.pedido = itemPedido.getPedido();
		this.produto = itemPedido.getProduto();
	}


	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Float getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(Float preco_venda) {
		this.preco_venda = preco_venda;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
}
