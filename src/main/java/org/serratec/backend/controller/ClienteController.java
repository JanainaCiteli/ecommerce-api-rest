package org.serratec.backend.controller;

import java.io.IOException;
import java.util.List;

import org.serratec.backend.dto.ClienteDTO;
import org.serratec.backend.exception.ClienteException;
import org.serratec.backend.model.Cliente;
import org.serratec.backend.model.Foto;
import org.serratec.backend.service.ClienteService;
import org.serratec.backend.service.FotoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private FotoClienteService fotoClienteService;
	@GetMapping
	@ApiOperation(value = "Listar todos Clientes", notes = "Listagem de Clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<List<ClienteDTO>> listar() {

		List<ClienteDTO> clientesDTO = clienteService.listar();
		return ResponseEntity.ok(clientesDTO);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Listar uma Cliente", notes = "Listagem com um Cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ClienteDTO buscar(Long id) {
		return clienteService.buscar(id);
	}

	@PostMapping
	@ApiOperation(value = "Cadastrar Cliente", notes = "Cadastro de Cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cadastrada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ClienteDTO inserir(@RequestPart Cliente cliente, @RequestParam MultipartFile file) throws IOException {
		return clienteService.inserir(cliente, file);
	}

	@GetMapping("/{id}/foto")
	@ApiOperation(value = "Listar a Foto do CLiente", notes = "Exibe a foto do cliene")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Exibe foto do cliente"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<byte[]> buscarPorFoto(@PathVariable Long id) {
		Foto foto = fotoClienteService.buscar(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", foto.getTipo());
		headers.add("content-length", String.valueOf(foto.getDados().length));
		return new ResponseEntity<byte[]>(foto.getDados(), headers, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Editar Cliente", notes = "Edição de Cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Editado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<ClienteDTO> alterar(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO)
			throws ClienteException {

		if (clienteService.editar(id, clienteDTO) != null) {
			return ResponseEntity.ok(clienteDTO);
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclusão de Cliente", notes = "Exclui um Cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Excluída com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		clienteService.apagar(id);
		return ResponseEntity.noContent().build();
	}

}
