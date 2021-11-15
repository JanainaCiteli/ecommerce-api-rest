package org.serratec.backend.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.serratec.backend.model.Cliente;
import org.serratec.backend.model.ItemPedido;
import org.serratec.backend.model.Pedido;

public class PedidoInserirDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDate data_pedido;
	private LocalDate data_entrega;
	private LocalDate data_envio;
	private String status;
	private Cliente cliente;
	private List<ItemPedido> itemPedido;

	public PedidoInserirDTO() {

	}

	public PedidoInserirDTO(Pedido pedido) {
		super();
		
		this.data_pedido = pedido.getData_pedido();
		this.data_entrega = pedido.getData_entrega();
		this.data_envio = pedido.getData_envio();
		this.status = pedido.getStatus();
		this.cliente = pedido.getCliente();
        //this.itemPedido = pedido.getItemPedido(); 
	}



	public LocalDate getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(LocalDate data_pedido) {
		this.data_pedido = data_pedido;
	}

	public LocalDate getData_entrega() {
		return data_entrega;
	}

	public void setData_entrega(LocalDate data_entrega) {
		this.data_entrega = data_entrega;
	}

	public LocalDate getData_envio() {
		return data_envio;
	}

	public void setData_envio(LocalDate data_envio) {
		this.data_envio = data_envio;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
