package org.serratec.backend.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.dto.CategoriaDTO;
import org.serratec.backend.dto.CategoriaInserirDTO;
import org.serratec.backend.exception.CategoriaException;
import org.serratec.backend.service.CategoriaService;
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
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	@ApiOperation(value = "Listar todas as Categorias", notes = "Listagem de Categorias")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Lista todas categorias"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<List<CategoriaDTO>> listar() {
		return ResponseEntity.ok(categoriaService.listar());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Listar uma Categoria", notes = "Listagem com uma Categoria")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista todas categorias"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<CategoriaDTO> buscar(@PathVariable Long id) throws CategoriaException {
		CategoriaDTO categoriaDTO = categoriaService.buscar(id);
		if (categoriaDTO == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(categoriaDTO);
		}

	}

	@PostMapping
	@ApiOperation(value = "Cadastrar Categoria", notes = "Cadastro de Categoria")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Cadastrada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<Object> inserir(@Valid @RequestBody CategoriaInserirDTO categoriaInserirDTO) {
		try {
			CategoriaDTO categoriaDTO = categoriaService.inserir(categoriaInserirDTO);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(categoriaDTO.getId())
					.toUri();
			return ResponseEntity.created(uri).body(categoriaDTO);
		} catch (CategoriaException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Editar Categoria", notes = "Edição de Categoria")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Editada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<CategoriaDTO> alterar(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO)
			throws CategoriaException {

		if (categoriaService.editar(id, categoriaDTO) != null) {
			return ResponseEntity.ok(categoriaDTO);
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclusão de Categoria", notes = "Exclui uma Categoria")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Excluída com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		categoriaService.apagar(id);
		return ResponseEntity.noContent().build();
	}

}
