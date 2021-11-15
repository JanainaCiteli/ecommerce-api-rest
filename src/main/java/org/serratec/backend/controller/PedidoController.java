package org.serratec.backend.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.dto.PedidoDTO;
import org.serratec.backend.dto.PedidoInserirDTO;
import org.serratec.backend.exception.PedidoException;
import org.serratec.backend.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	@ApiOperation(value = "Listar todas as Pedidos", notes = "Listagem de Pedidos")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Lista todos Pedidos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<List<PedidoDTO>> listar() {
		return ResponseEntity.ok(pedidoService.listar());
	}

	@GetMapping("{id}")
	@ApiOperation(value = "Listar uma PedidoController", notes = "Listagem com um PedidoController")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista todas Pedidos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<PedidoDTO> buscar(@PathVariable Long id) throws PedidoException {
		PedidoDTO pedidoDTO = pedidoService.buscar(id);
		if (pedidoDTO == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(pedidoDTO);
		}

	}

	@PostMapping
	@ApiOperation(value = "Cadastrar PedidoController", notes = "Cadastro de PedidoController")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Cadastrado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<Object> inserir(@Valid @RequestBody PedidoInserirDTO pedidoInserirDTO) {
		try {
			PedidoDTO pedidoDTO = pedidoService.inserir(pedidoInserirDTO);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(pedidoDTO.getId())
					.toUri();
			return ResponseEntity.created(uri).body(pedidoDTO);
		} catch (PedidoException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Editar PedidoController", notes = "Edição de PedidoController")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Editado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<PedidoDTO> alterar(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO)
			throws PedidoException {

		if (pedidoService.editar(id, pedidoDTO) != null) {
			return ResponseEntity.ok(pedidoDTO);
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclusão de PedidoController", notes = "Exclui uma PedidoController")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Excluído com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		pedidoService.apagar(id);
		return ResponseEntity.noContent().build();
	}

}
