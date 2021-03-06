package org.serratec.backend.dto;

import java.io.Serializable;

import org.serratec.backend.model.ItemPedido;
import org.serratec.backend.model.Pedido;
import org.serratec.backend.model.Produto;

public class ItemPedidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer quantidade;
	private Float preco_venda;
	private Pedido pedido;
	private Produto produto;

	public ItemPedidoDTO() {

	}

	public ItemPedidoDTO(ItemPedido itemPedido) {
		super();
		this.id = itemPedido.getId();
		this.quantidade = itemPedido.getQuantidade();
		this.pedido = itemPedido.getPedido();
		this.preco_venda = itemPedido.getPreco_venda();
		this.produto = itemPedido.getProduto();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoDTO other = (ItemPedidoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
