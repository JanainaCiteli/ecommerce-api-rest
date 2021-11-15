package org.serratec.backend.dto;

import java.io.Serializable;
import java.util.List;

import org.serratec.backend.model.Cliente;
import org.serratec.backend.model.ItemPedido;
import org.serratec.backend.model.Pedido;

public class PedidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String status;
	private Cliente cliente;
	private List<ItemPedido> itemPedido;

	public PedidoDTO() {

	}

	public PedidoDTO(Pedido pedido) {
		super();
		this.id = pedido.getId();
		this.status = pedido.getStatus();
		this.cliente = pedido.getCliente();
		this.itemPedido = pedido.getItemPedido();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
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
		PedidoDTO other = (PedidoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
