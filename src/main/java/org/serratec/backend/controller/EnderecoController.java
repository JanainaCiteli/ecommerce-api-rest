package org.serratec.backend.controller;

import java.util.List;

import org.serratec.backend.dto.EnderecoDTO;
import org.serratec.backend.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	@ApiOperation(value = "Listar todos Endereços cadastrados", notes = "Listagem de Endereços")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Lista todos Endereços"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<List<EnderecoDTO>> listar() {
		return ResponseEntity.ok(enderecoService.listar());
	}

	@GetMapping("{cep}")
	@ApiOperation(value = "Listar um Endereço", notes = "Listagem com um Endereço")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista todos Endereços"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<EnderecoDTO> buscar(@PathVariable String cep) {
		EnderecoDTO enderecoDTO = enderecoService.buscar(cep);
		if (enderecoDTO == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(enderecoDTO);
		}

	}
	
	
}
